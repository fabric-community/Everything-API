package io.github.fabriccommunity.everything.api.inventory;

import io.github.fabriccommunity.everything.Examples;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.apache.logging.log4j.Level;

public class InventoryManager {

	/**
	 * Write inventory contents to a CompoundTag with support for ItemStacks greater than 64 in size.
	 */
	public static CompoundTag write(Inventory inventory) {
		return write(inventory, null);
	}

	/**
	 * Write inventory contents to a CompoundTag with support for ItemStacks greater than 64 in size.
	 */
	public static CompoundTag write(Inventory inventory, CompoundTag tag) {
		if (inventory == null || inventory.getInvSize() <= 0) return StackManager.TAG_EMPTY;

		if (tag == null) tag = new CompoundTag();

		CompoundTag inventoryTag = new CompoundTag();

		CompoundTag stacksTag = new CompoundTag();

		inventoryTag.putInt("size", inventory.getInvSize());

		for (int position = 0; position < inventory.getInvSize(); ++position) {
			if (inventory.getInvStack(position) != null && inventory.getInvStack(position) != ItemStack.EMPTY) {
				ItemStack stack = inventory.getInvStack(position);

				if (stack != null && !stack.isEmpty()) {
					CompoundTag stackTag = StackManager.write(inventory.getInvStack(position));

					if (stackTag != StackManager.TAG_EMPTY) {
						stacksTag.put(String.valueOf(position), stackTag);
					}
				}
			}
		}

		inventoryTag.put("stacks", stacksTag);

		tag.put("inventory", inventoryTag);

		return tag;
	}

	/**
	 * Read inventory contents from a CompoundTag with support for ItemStacks greater than 64 in size.
	 */
	public static <T extends ImplementedInventory> T read(CompoundTag tag) {
		if (tag == null) return null;

		if (!tag.contains("inventory")) {
			Examples.LOGGER.log(Level.ERROR, "[Everything-API] Inventory contents failed to be read: " + CompoundTag.class.getName() + " does not contain 'inventory' subtag!");
			return null;
		} else {
			Tag rawTag = tag.get("inventory");

			if (!(rawTag instanceof CompoundTag)) {
				Examples.LOGGER.log(Level.ERROR, "[Everything-API] Inventory contents failed to be read: " + rawTag.getClass().getName() + " is not instance of " + CompoundTag.class.getName() + "!");
				return null;
			} else {
				CompoundTag compoundTag = (CompoundTag) rawTag;

				if (!compoundTag.contains("size")) {
					Examples.LOGGER.log(Level.ERROR, "[Everything-API] Inventory contents failed to be read: " + CompoundTag.class.getName() + " does not contain 'size' value!");
					return null;
				} else {
					int size = compoundTag.getInt("size");

					if (size == 0)
						Examples.LOGGER.log(Level.WARN, "[Everything-API] Inventory contents size successfully read, but with size of zero. This may indicate a non-integer 'size' value!");

					if (!compoundTag.contains("stacks")) {
						Examples.LOGGER.log(Level.ERROR, "[Everything-API] Inventory contents failed to be read: " + CompoundTag.class.getName() + " does not contain 'stacks' subtag!");
						return null;
					} else {
						Tag rawStacksTag = compoundTag.get("stacks");

						if (!(rawStacksTag instanceof CompoundTag)) {
							Examples.LOGGER.log(Level.ERROR, "[Everything-API] Inventory contents failed to be read: " + rawStacksTag.getClass().getName() + " is not instance of " + CompoundTag.class.getName() + "!");
							return null;
						} else {
							CompoundTag stacksTag = (CompoundTag) rawStacksTag;

							ImplementedInventory inventory = new ImplementedInventory(size);

							for (int position = 0; position < size; ++position) {
								if (stacksTag.contains(String.valueOf(position))) {
									Tag rawStackTag = stacksTag.get(String.valueOf(position));

									if (!(rawStackTag instanceof CompoundTag)) {
										Examples.LOGGER.log(Level.ERROR, "[Everything-API] Inventory stack skipped: stored tag not instance of " + CompoundTag.class.getName() + "!");
										return null;
									} else {
										CompoundTag stackTag = (CompoundTag) rawStackTag;

										ItemStack stack = StackManager.read(stackTag);

										if (stack == ItemStack.EMPTY) {
											Examples.LOGGER.log(Level.WARN, "[Everything-API] Inventory stack skipped: stack was empty!");
										} else {
											inventory.setInvStack(position, stack);
										}
									}
								}
							}

							return (T) inventory;
						}
					}
				}
			}
		}
	}
}
