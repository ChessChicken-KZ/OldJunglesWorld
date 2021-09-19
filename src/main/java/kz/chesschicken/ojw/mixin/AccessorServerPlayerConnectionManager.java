package kz.chesschicken.ojw.mixin;

import net.minecraft.server.ServerPlayerConnectionManager;
import net.minecraft.server.ServerPlayerView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ServerPlayerConnectionManager.class)
public interface AccessorServerPlayerConnectionManager {
    @Accessor("playerViews")
    ServerPlayerView[] getEyes();

    @Invoker("getPlayerView")
    ServerPlayerView invokeGetEye(int i);
}
