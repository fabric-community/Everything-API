package io.github.fabriccommunity.everything.api.food;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class FabricFoodComponent {
	private int hunger;
	private float saturationModifier;
	private boolean meat;
	private boolean alwaysEdible;
	private boolean snack;
	private List<Pair<StatusEffectInstance, Float>> statusEffects;

	private FabricFoodComponent() {
		this(0, 0, false, false, false, new ArrayList<>());
	}

	private FabricFoodComponent(int hunger, float saturationModifier, boolean alwaysEdible, boolean meat, boolean snack, List<Pair<StatusEffectInstance, Float>> statusEffects) {
		this.hunger = hunger;
		this.saturationModifier = saturationModifier;
		this.meat = meat;
		this.alwaysEdible = alwaysEdible;
		this.snack = snack;
		this.statusEffects = statusEffects;
	}

	public static FabricFoodComponent of(int hunger) {
		return of(hunger, 0.6F);
	}

	public static FabricFoodComponent of(int hunger, float saturationModifier) {
		return new FabricFoodComponent(hunger, saturationModifier, false, false, false, new ArrayList<>());
	}

	public static FabricFoodComponent copy(FoodComponent foodComponent) {
		return new FabricFoodComponent(foodComponent.getHunger(), foodComponent.getSaturationModifier(), foodComponent.isAlwaysEdible(), foodComponent.isMeat(), foodComponent.isSnack(), foodComponent.getStatusEffects());
	}

	public FabricFoodComponent setHunger(int hunger) {
		this.hunger = hunger;
		return this;
	}

	public FabricFoodComponent setSaturationModifier(float saturationModifier) {
		this.saturationModifier = saturationModifier;
		return this;
	}

	public FabricFoodComponent setAlwaysEdible(boolean alwaysEdible) {
		this.alwaysEdible = alwaysEdible;
		return this;
	}

	public FabricFoodComponent setMeat(boolean meat) {
		this.meat = meat;
		return this;
	}

	public FabricFoodComponent setSnack(boolean snack) {
		this.snack = snack;
		return this;
	}

	public FabricFoodComponent setStatusEffects(List<Pair<StatusEffectInstance, Float>> statusEffects) {
		this.statusEffects = statusEffects;
		return this;
	}

	public FoodComponent build() {
		FoodComponent.Builder builder = new FoodComponent.Builder();

		builder.hunger(hunger);
		builder.saturationModifier(saturationModifier);

		if (alwaysEdible) {
			builder.alwaysEdible();
		}

		if (meat) {
			builder.meat();
		}

		if (snack) {
			builder.snack();
		}

		if (!statusEffects.isEmpty()) {
			for (Pair<StatusEffectInstance, Float> statusEffectPair : statusEffects) {
				builder.statusEffect(statusEffectPair.getLeft(), statusEffectPair.getRight());
			}
		}

		return builder.build();
	}
}
