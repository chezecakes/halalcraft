package org.github.chezecakes.items;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/*
 * Grants a positive effect when used
 * TODO: scale positive effect with piety
 * FIXME: double effects on use, one effect does not go away (not even with /effect clear, only on relog)
 * FIXME: recipe tags
 */
public class EmeraldTasbihItem extends Item {
    private static final List<StatusEffect> effects;

    static {
        effects = Registries.STATUS_EFFECT
                .stream()
                .filter(x -> x.getCategory() == StatusEffectCategory.BENEFICIAL)
                .toList();
    }

    public EmeraldTasbihItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 20 * 60);

        var stack = user.getStackInHand(hand);
        var rand_idx = RandomUtils.nextInt(0, effects.size());
        var rand_effect = effects.get(rand_idx);

        user.addStatusEffect(new StatusEffectInstance(rand_effect, 20 * 30, 1)); // 20 ticks = 1 second, * 30 = 30 seconds

        if (!user.getAbilities().creativeMode) {
            stack.damage(1, user, x -> x.sendToolBreakStatus(hand));
        }

        return TypedActionResult.success(stack, world.isClient()); // mirrored from EnderPearlItem
    }
}
