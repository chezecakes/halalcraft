package org.github.chezecakes.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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

import java.util.ArrayList;
import java.util.List;

/*
 * Grants a positive effect when used
 * TODO: scale positive effect with piety
 * FIXME: amplifier not correctly set (once got saturation 2)
 */
public class TasbihItem extends Item {
    private static final List<StatusEffect> effects;

    // todo: remove this logic in favor of better cooldown handling
    private static final List<TasbihItem> tasbih_inst;

    static {
        effects = Registries.STATUS_EFFECT
                .stream()
                .filter(x -> x.getCategory() == StatusEffectCategory.BENEFICIAL)
                .toList();

        tasbih_inst = new ArrayList<>();
    }

    public TasbihItem() {
        super(new FabricItemSettings().maxCount(1).maxDamage(16));

        tasbih_inst.add(this);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        for (var inst : tasbih_inst) {
            user.getItemCooldownManager().set(inst, 20 * 60);
        }

        var stack = user.getStackInHand(hand);
        var rand_idx = RandomUtils.nextInt(0, effects.size());
        var rand_effect = effects.get(rand_idx);

        if (!world.isClient()) {
            user.addStatusEffect(new StatusEffectInstance(rand_effect, 20 * 30, 1)); // 20 ticks = 1 second, * 30 = 30 seconds
        }

        if (!user.isCreative()) {
            stack.damage(1, user, x -> x.sendToolBreakStatus(hand));
        }

        return TypedActionResult.success(stack, world.isClient()); // mirrored from EnderPearlItem
    }
}
