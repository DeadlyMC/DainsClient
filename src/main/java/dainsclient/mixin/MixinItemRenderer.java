package dainsclient.mixin;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.ItemRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer
{
    @Redirect(method = "updateEquippedItem()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/entity/EntityPlayerSP;getCooledAttackStrength(F)F", ordinal = 0))
    private float getCooledAttackStrength(EntityPlayerSP player, float adjustTicks)
    {
        return 1;
    }
}
