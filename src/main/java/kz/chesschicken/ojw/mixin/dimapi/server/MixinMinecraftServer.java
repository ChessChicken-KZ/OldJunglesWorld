package kz.chesschicken.ojw.mixin.dimapi.server;

import kz.chesschicken.ojw.utils.dimension.DimensionEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftServer.class)
public abstract class MixinMinecraftServer {

    @Redirect(method = "prepareLevel", at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/server/MinecraftServer;levels:[Lnet/minecraft/server/level/ServerLevel;",
            opcode = Opcodes.PUTFIELD
    ))
    private void reeditLevels(MinecraftServer minecraftServer, ServerLevel[] value)
    {
        if(value.length == 2)
            minecraftServer.levels = new ServerLevel[DimensionEvent.INSTANCE.getDimensionSize()];
    }
}
