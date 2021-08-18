package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.init.OJWTextureListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

/**
 * Melon block.
 */
public class BlockMelon extends TemplateBlockBase {
    public BlockMelon(Identifier id) {
        super(id, Material.ORGANIC);
        this.setHardness(0.8F);
        this.setSounds(WOOL_SOUNDS);
    }

    @Override
    public int getDropCount(Random rand) {
        return rand.nextInt(6) + 2;
    }

    @Override
    public int getDropId(int meta, Random rand) {
        return OJWContentListener.itemMelon.id;
    }

    @Override
    public int getTextureForSide(int side) {
        if(side == 0 || side == 1)
            return OJWTextureListener.textureMelonTop;
        else
            return OJWTextureListener.textureMelonSide;
    }
}
