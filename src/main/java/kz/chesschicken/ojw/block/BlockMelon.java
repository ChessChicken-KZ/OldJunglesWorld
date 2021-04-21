package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OldJunglesWorldListener;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.block.BlockBase;

import java.util.Random;

public class BlockMelon extends BlockBase {
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
        return OldJunglesWorldListener.itemMelon.id;
    }

    @Override
    public int getTextureForSide(int side) {
        if(side == 0 || side == 1)
        {
            return OldJunglesWorldListener.texture_MelonTOP;
        }else return OldJunglesWorldListener.texture_MelonSIDE;
    }
}
