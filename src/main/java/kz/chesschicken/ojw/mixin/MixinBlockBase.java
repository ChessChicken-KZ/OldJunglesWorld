package kz.chesschicken.ojw.mixin;

import kz.chesschicken.ojw.utils.BiValue;
import kz.chesschicken.ojw.utils.extendedblocks.CustomBoundingBoxPerMeta;
import net.minecraft.block.BlockBase;
import net.minecraft.level.BlockView;
import net.minecraft.level.Level;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.maths.Box;
import net.minecraft.util.maths.Vec3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.BiFunction;
import java.util.function.Function;

@Mixin(BlockBase.class)
public abstract class MixinBlockBase {
    @Shadow public abstract void updateBoundingBox(BlockView tileView, int x, int y, int z);

    @Inject(method = "isSideRendered", at = @At("HEAD"), cancellable = true)
    private void injectSideRendered(BlockView tileView, int x, int y, int z, int side, CallbackInfoReturnable<Boolean> cir) {
        if(this instanceof CustomBoundingBoxPerMeta) {
            float[] floats = ((CustomBoundingBoxPerMeta) this).getBoundingBoxes(tileView.getTileMeta(x, y, z));
            if (side == 0 && floats[1] > 0.0D)
                cir.setReturnValue(true);
            else if (side == 1 && floats[4] < 1.0D)
                cir.setReturnValue(true);
            else if (side == 2 && floats[2] > 0.0D)
                cir.setReturnValue(true);
            else if (side == 3 && floats[5] < 1.0D)
                cir.setReturnValue(true);
            else if (side == 4 && floats[0] > 0.0D)
                cir.setReturnValue(true);
            else if (side == 5 && floats[3] < 1.0D)
                cir.setReturnValue(true);
            else cir.setReturnValue(!tileView.isFullOpaque(x, y, z));
            cir.cancel();
        }
    }

    @Inject(method = "getOutlineShape", at = @At("HEAD"), cancellable = true)
    private void injectOutlineShape(Level level, int x, int y, int z, CallbackInfoReturnable<Box> cir) {
        if(this instanceof CustomBoundingBoxPerMeta) {
            float[] floats = ((CustomBoundingBoxPerMeta) this).getBoundingBoxes(level.getTileMeta(x, y, z));
            cir.setReturnValue(Box.createButWasteMemory(x + floats[0], y + floats[1], z + floats[2], x + floats[3], y + floats[4], z + floats[5]));
            cir.cancel();
        }
    }

    @Inject(method = "getCollisionShape", at = @At("HEAD"), cancellable = true)
    private void injectMetaCollisionShape(Level level, int x, int y, int z, CallbackInfoReturnable<Box> cir) {
        if(this instanceof CustomBoundingBoxPerMeta) {
            float[] floats = ((CustomBoundingBoxPerMeta) this).getBoundingBoxes(level.getTileMeta(x, y, z));
            cir.setReturnValue(Box.createButWasteMemory(x + floats[0], y + floats[1], z + floats[2], x + floats[3], y + floats[4], z + floats[5]));
            cir.cancel();
        }
    }

    @Unique
    private Vec3f resulting(BiFunction<Vec3f, Integer, Boolean> func, BiFunction<Vec3f, Float, Vec3f> func1, Vec3f v, float f, int meta) {
        Vec3f r = func1.apply(v, f);
        return func.apply(r, meta) ? r : null;
    }

    @Unique
    private BiValue<Vec3f, Byte> replaceIfRequires(BiValue<Vec3f, Byte> resulting, Vec3f current, Function<Vec3f, Double> func, byte state) {
        if(current != null && (resulting.get_first() == null || func.apply(current) < func.apply(resulting.get_first())))
            return new BiValue<>(current, state);
        return resulting;
    }

    @Unique private boolean isInsideYZ(Vec3f vec3f, int meta) {
        if (vec3f == null) return false;
        float[] floats = ((CustomBoundingBoxPerMeta) this).getBoundingBoxes(meta);
        return vec3f.y >= floats[1] && vec3f.y <= floats[4] && vec3f.z >= floats[2] && vec3f.z <= floats[5];
    }

    @Unique private boolean isInsideXZ(Vec3f vec3f, int meta) {
        if (vec3f == null) return false;
        float[] floats = ((CustomBoundingBoxPerMeta) this).getBoundingBoxes(meta);
        return vec3f.x >= floats[0] && vec3f.x <= floats[3] && vec3f.z >= floats[2] && vec3f.z <= floats[5];
    }

    @Unique private boolean isInsideXY(Vec3f vec3f, int meta) {
        if (vec3f == null) return false;
        float[] floats = ((CustomBoundingBoxPerMeta) this).getBoundingBoxes(meta);
        return vec3f.x >= floats[0] && vec3f.x <= floats[3] && vec3f.y >= floats[1] && vec3f.y <= floats[4];
    }

    @Inject(method = "method_1564", at = @At("HEAD"), cancellable = true)
    private void injectNewMetaHitResult(Level arg, int x, int y, int z, Vec3f first, Vec3f second, CallbackInfoReturnable<HitResult> cir) {
        if(this instanceof CustomBoundingBoxPerMeta) {
            this.updateBoundingBox(arg, x, y, z);
            first = first.method_1301(-x, -y, -z);
            second = second.method_1301(-x, -y, -z);

            int m = arg.getTileMeta(x, y, z);
            float[] floats = ((CustomBoundingBoxPerMeta) this).getBoundingBoxes(arg.getTileMeta(x, y, z));

            BiValue<Vec3f, Byte> resulting = new BiValue<>(null, (byte) -1);
            resulting = replaceIfRequires(resulting, resulting(this::isInsideYZ, first::method_1295, second, floats[0], m), first::method_1294, (byte) 4);
            resulting = replaceIfRequires(resulting, resulting(this::isInsideYZ, first::method_1295, second, floats[3], m), first::method_1294, (byte) 5);
            resulting = replaceIfRequires(resulting, resulting(this::isInsideXZ, first::method_1299, second, floats[1], m), first::method_1294, (byte) 0);
            resulting = replaceIfRequires(resulting, resulting(this::isInsideXZ, first::method_1299, second, floats[4], m), first::method_1294, (byte) 1);
            resulting = replaceIfRequires(resulting, resulting(this::isInsideXY, first::method_1302, second, floats[2], m), first::method_1294, (byte) 2);
            resulting = replaceIfRequires(resulting, resulting(this::isInsideXY, first::method_1302, second, floats[5], m), first::method_1294, (byte) 3);

            cir.setReturnValue(resulting.get_first() == null ? null : new HitResult(x, y, z, resulting.get_second(), resulting.get_first().method_1301(x, y, z)));
            cir.cancel();
        }
    }


}
