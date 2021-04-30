package kz.chesschicken.ojw.mixin;

import kz.chesschicken.ojw.block.TileMelonSeed;
import kz.chesschicken.ojw.init.OldJunglesWorldListener;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.Dye;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Dye.class)
public class MixinDye {
    @Inject(method = "useOnTile", at = @At("HEAD"), cancellable = true)
    private void addPlant(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing, CallbackInfoReturnable<Boolean> cir)
    {
        if (item.getDamage() == 15) {
            int currentID = level.getTileId(x, y, z);
            if (currentID == OldJunglesWorldListener.blockMelonSeedsTile.id) {
                if (!level.isClient) {
                    ((TileMelonSeed) OldJunglesWorldListener.blockMelonSeedsTile).growCropInstantly(level, x, y, z);
                    --item.count;
                }

                cir.setReturnValue(true);
                cir.cancel();
            }
        }
    }
}
