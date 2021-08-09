package kz.chesschicken.ojw.mixin.dimapi;

import kz.chesschicken.ojw.utils.portal.IBlockPortal;
import net.minecraft.block.BlockBase;
import net.minecraft.block.Portal;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(net.minecraft.class_467.class)
public class Mixin_class_467 implements IBlockPortal {
    @Redirect(method = "method_1531", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/block/Portal;id:I",
            opcode = Opcodes.GETFIELD
    ))
    private int inject_method_1531(Portal portal)
    {
        if(portal.id == BlockBase.PORTAL.id)
        {
            return ((IBlockPortal)this).getBlockPortal();
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
        return ((IBlockPortal)this).getBlockPortal();
    }

    @Redirect(method = "method_1532", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/block/BlockBase;id:I",
            opcode = Opcodes.GETFIELD
    ))
    private int inject_method_1532_1(BlockBase blockBase)
    {
        if(blockBase.id == BlockBase.OBSIDIAN.id)
            return ((IBlockPortal)this).getBlockFrame();
        return blockBase.id;
    }
}
