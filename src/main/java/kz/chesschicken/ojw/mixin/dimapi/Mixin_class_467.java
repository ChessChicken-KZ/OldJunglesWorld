package kz.chesschicken.ojw.mixin.dimapi;

import kz.chesschicken.ojw.utils.portalworks.OJW_class_467;
import net.minecraft.block.BlockBase;
import net.minecraft.block.Portal;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(net.minecraft.class_467.class)
public class Mixin_class_467 implements OJW_class_467 {
    @Redirect(method = "method_1531", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/block/Portal;id:I",
            opcode = Opcodes.GETFIELD
    ))
    private int inject_method_1531(Portal portal)
    {
        if(portal.id == BlockBase.PORTAL.id)
        {
            return ((OJW_class_467)this).getBLOCKPORTAL();
        }else
            return portal.id;
    }


    @Redirect(method = "method_1532", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/block/Portal;id:I",
            opcode = Opcodes.GETFIELD
    ))
    private int inject_method_1532_0(Portal portal)
    {
        return ((OJW_class_467)this).getBLOCKPORTAL();
    }

    @Redirect(method = "method_1532", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/block/BlockBase;id:I",
            opcode = Opcodes.GETFIELD
    ))
    private int inject_method_1532_1(BlockBase blockBase)
    {
        if(blockBase.id == BlockBase.OBSIDIAN.id)
            return ((OJW_class_467)this).getBlockOBSIDIAN();
        return blockBase.id;
    }
}
