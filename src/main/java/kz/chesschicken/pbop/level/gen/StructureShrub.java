package kz.chesschicken.pbop.level.gen;


import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class StructureShrub extends Structure {
    public boolean generate(Level world, Random par2Random, int par3, int par4, int par5) {
        int var15;
        for(boolean var7 = false; ((var15 = world.getTileId(par3, par4, par5)) == 0 || var15 == BlockBase.LEAVES.id) && par4 > 0; --par4) {
        }

        int var7ss = world.getTileId(par3, par4, par5);
        if (var7ss == BlockBase.DIRT.id || var7ss == BlockBase.GRASS.id) {
            ++par4;
            world.setTileWithMetadata(par3, par4, par5, BlockBase.LOG.id, 0);

            for(int var8 = par4; var8 <= par4 + 2; ++var8) {
                int var9 = var8 - par4;
                int var10 = 2 - var9;

                for(int var11 = par3 - var10; var11 <= par3 + var10; ++var11) {
                    int var12 = var11 - par3;

                    for(int var13 = par5 - var10; var13 <= par5 + var10; ++var13) {
                        int var14 = var13 - par5;
                        if ((Math.abs(var12) != var10 || Math.abs(var14) != var10 || par2Random.nextInt(2) != 0) && !BlockBase.FULL_OPAQUE[world.getTileId(var11, var8, var13)]) {
                            world.setTileWithMetadata(var11, var8, var13, BlockBase.LEAVES.id, 0);
                        }
                    }
                }
            }
        }

        return true;
    }
}
