package org.github.chezecakes.items;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

public class TasbihItem extends Item {
    private static final List<StatusEffect> effects;

    static {
        effects = Registries.STATUS_EFFECT
                .stream()
                .filter(x -> x.getCategory() == StatusEffectCategory.BENEFICIAL)
                .toList();
    }

    public TasbihItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        var stack = user.getStackInHand(hand);
        var rand_idx = RandomUtils.nextInt(0, effects.size());
        var rand_effect = effects.get(rand_idx);

        user.addStatusEffect(new StatusEffectInstance(rand_effect, 20 * 30, 1)); // 20 ticks = 1 second, * 30 = 30 seconds

        if (!user.getAbilities().creativeMode) {
            stack.damage(1, user, x -> x.sendToolBreakStatus(hand));
        }

        user.getItemCooldownManager().set(this, 20 * 60);

        return TypedActionResult.success(stack, world.isClient()); // mirrored from enderpearlitem
    }
}
