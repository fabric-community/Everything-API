package io.github.fabriccommunity.everything.api.inventory;

import io.github.fabriccommunity.everything.Examples;
import io.github.fabriccommunity.everything.api.data.Twumair;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;

import java.util.*;
import java.util.function.Supplier;

public class StackManager {
	public static final CompoundTag TAG_EMPTY = new CompoundTag();

	/**
	 * Write item stack to compound NBT with support for counts greater than 64.
	 *
	 * @param stack ItemStack CompoundTag will be written from.
	 * @return ItemStack from tag.
	 */
	public static CompoundTag write(ItemStack stack) {
		Identifier identifier = Registry.ITEM.getId(stack.getItem());

		if (stack.getCount() < 0) {
			Examples.LOGGER.log(Level.ERROR, "[Everything-API] ItemStack failed to be written: count was smaller than zero!");
			return TAG_EMPTY;
		} else {
			CompoundTag tag = new CompoundTag();

			tag.putString("id", identifier.toString());
			tag.putInt("count", stack.getCount());

			if (stack.hasTag()) {
				tag.put("tag", stack.getTag());
			}

			return tag;
		}
	}

	/**
	 * Read item stack from CompoundTag with support for counts greater than 64.
	 *
	 * @param stackTag CompoundTag ItemStack will be read from.
	 * @return ItemStack from tag.
	 */
	public static ItemStack read(CompoundTag stackTag) {
		// Backwards compatibility.
		if (stackTag.contains("Count")) {
			stackTag.put("count", stackTag.get("Count"));
		}

		ItemStack stack;

		if (!stackTag.contains("id")) {
			Examples.LOGGER.log(Level.ERROR, "[Everything-API] ItemStack failed to be read: " + CompoundTag.class.getName() + " does not contain 'id' value!");
			return ItemStack.EMPTY;
		} else {
			String identifierString = stackTag.getString("id");

			if (!Identifier.isValid(identifierString)) {
				Examples.LOGGER.log(Level.ERROR, "[Everything-API] ItemStack failed to be read: " + CompoundTag.class.getName() + "'s 'id' value is not a valid " + Identifier.class.getName() + "!");
				return ItemStack.EMPTY;
			} else {
				Identifier identifier = Identifier.tryParse(identifierString);

				if (!stackTag.contains("count")) {
					Examples.LOGGER.log(Level.ERROR, "[Everything-API] ItemStack failed to be read: " + CompoundTag.class.getName() + " does not contain 'count' value!");
					return ItemStack.EMPTY;
				} else {
					int count = stackTag.getInt("count");

					if (count < 0) {
						Examples.LOGGER.log(Level.ERROR, "[Everything-API] ItemStack failed to be read: count was smaller than zero!");
						return ItemStack.EMPTY;
					} else {
						if (!Registry.ITEM.containsId(identifier)) {
							Examples.LOGGER.log(Level.ERROR, "[Everything-API] ItemStack failed to be read: item registry did not contain a valid item identifier!");
							return ItemStack.EMPTY;
						} else {
							Item item = Registry.ITEM.get(identifier);

							stack = new ItemStack(item, count);

							if (stackTag.contains("tag", 10)) {
								Tag rawTag = stackTag.get("tag");

								if (!(rawTag instanceof CompoundTag)) {
									Examples.LOGGER.log(Level.WARN, "[Everything-API] ItemStack did not fail to be read, but had a non-standard tag which was discarded!");
								} else {
									CompoundTag tagTag = (CompoundTag) rawTag;

									stack.setTag(tagTag);
								}
							}

							if (item.isDamageable()) {
								stack.setDamage(stack.getDamage());
							}
						}
					}
				}
			}
		}

		return stack;
	}

	/**
	 * Support merging stacks with customized maximum count.
	 *
	 * @param supplierA Source ItemStack supplier
	 * @param supplierB Destination ItemStack supplier
	 * @param sA        Max. count of stackA supplier
	 * @param sB        Max. count of stackB supplier
	 * @return Resulting ItemStacks
	 */
	public static Twumair<ItemStack, ItemStack> merge(Supplier<ItemStack> supplierA, Supplier<ItemStack> supplierB, Supplier<Integer> sA, Supplier<Integer> sB) {
		return merge(supplierA.get(), supplierB.get(), sA.get(), sB.get());
	}

	/**
	 * Support merging stacks with customized maximum count.
	 *
	 * @param stackA Source ItemStack
	 * @param stackB Destination ItemStack
	 * @param maxA   Max. count of stackA
	 * @param maxB   Max. count of stackB
	 * @return Resulting ItemStacks
	 */
	public static Twumair<ItemStack, ItemStack> merge(ItemStack stackA, ItemStack stackB, int maxA, int maxB) {
		Item itemA = stackA.getItem();
		Item itemB = stackB.getItem();

		if (equalItemAndTag(stackA, stackB)) {
			int countA = stackA.getCount();
			int countB = stackB.getCount();

			int availableA = Math.max(0, maxA - countA);
			int availableB = Math.max(0, maxB - countB);

			stackB.increment(Math.min(countA, availableB));
			stackA.setCount(Math.max(countA - availableB, 0));
		} else {
			if (stackA.isEmpty() && !stackB.isEmpty()) {
				int countA = stackA.getCount();
				int availableA = maxA - countA;

				int countB = stackB.getCount();

				stackA = new ItemStack(itemB, Math.min(countB, availableA));
				stackA.setTag(stackB.getTag());
				stackB.decrement(Math.min(countB, availableA));
			} else if (stackB.isEmpty() && !stackA.isEmpty()) {
				int countB = stackB.getCount();
				int availableB = maxB - countB;

				int countA = stackA.getCount();

				stackB = new ItemStack(itemA, Math.min(countA, availableB));
				stackB.setTag(stackA.getTag());
				stackA.decrement(Math.min(countA, availableB));
			}
		}

		return Twumair.of(stackA, stackB);
	}

	/**
	 * Asserts whether two ItemStacks are equal in Item and Tag.
	 *
	 * @param stackA Stack one.
	 * @param stackB Stack two.
	 * @return True if one and two match in Item and Tag; False if not.
	 */
	public static boolean equalItemAndTag(ItemStack stackA, ItemStack stackB) {
		return ItemStack.areItemsEqual(stackA, stackB) && stackA.getTag() == stackB.getTag();
	}

	public enum SortType {
		ITEM_NAME,
		ITEM_COUNT
	}

	/**
	 * Sorts this inventory based on:
	 * - Item type
	 * - Item name
	 * - Item count
	 */
	public static void sort(Inventory inventory) {
		HashMap<Item, ArrayList<ItemStack>> byType=  new HashMap<>();

		for (int i = 0; i < inventory.getInvSize(); ++i) {
			ItemStack stack = inventory.getInvStack(i);

			if (!byType.containsKey(stack.getItem())) {
				byType.put(stack.getItem(), new ArrayList<>());
			}

			byType.get(stack.getItem()).add(stack);
		}

		int i = 0;
		for (Map.Entry<Item, ArrayList<ItemStack>> type : byType.entrySet()) {
			ArrayList<ItemStack> stacks = type.getValue();
			boolean finished = false;
			for (int k = 0; k < 128 && !finished; ++k) {
				for (int l = 0; l < stacks.size(); ++l) {
					boolean moved = false;
					if (l < stacks.size() - 1) {
						ItemStack cur = stacks.get(l);
						ItemStack nex = stacks.get(l + 1);

						if (cur.getCount() < nex.getCount()) {
							stacks.set(l + 1, cur);
							stacks.set(l, nex);
							moved = true;
						}
					}
					if (l == stacks.size() - 1 && !moved) {
						finished = true;
					}
				}
			}

			for (ItemStack stack : stacks) {
				inventory.setInvStack(i, stack);
				++i;
			}
		}
	}
}
