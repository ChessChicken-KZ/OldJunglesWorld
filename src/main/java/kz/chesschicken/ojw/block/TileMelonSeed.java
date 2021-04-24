package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OldJunglesWorldListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.block.Crops;

import java.util.Random;

public class TileMelonSeed extends Crops {
    private final int melonID;
    public TileMelonSeed(Identifier identifier, int melonID) {
        super(identifier, 0);
        this.melonID = melonID;
        float var3 = 0.125F;
        this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);

    }

    public int getDropId(int meta, Random rand) {
        return meta == 7 ? OldJunglesWorldListener.itemMelonSeeds.id : -1;
    }


    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta)
        {
            case 2: return OldJunglesWorldListener.texture_MelonTile[1];
            case 3: return OldJunglesWorldListener.texture_MelonTile[2];
            case 4: return OldJunglesWorldListener.texture_MelonTile[3];
            case 5: return OldJunglesWorldListener.texture_MelonTile[4];
            case 6: return OldJunglesWorldListener.texture_MelonTile[5];
            case 7: return OldJunglesWorldListener.texture_MelonTile[6];

            default: return OldJunglesWorldListener.texture_MelonTile[0];
        }
    }

    @Override
    public int getDropCount(Random rand) {
        return rand.nextInt(2) + 1;
    }

    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        super.onScheduledTick(level, x, y, z, rand);
        if (level.placeTile(x, y + 1, z) >= 9) {
            int var6 = level.getTileMeta(x, y, z);
            if (var6 < 7) {
                float var7 = this.growCropStage(level, x, y, z);
                if (rand.nextInt((int)(100.0F / var7)) == 0) {
                    ++var6;
                    level.setTileMeta(x, y, z, var6);
                }
            }else if(var6 == 7)
            {
                if(rand.nextInt(100) == 0)
                {
                    level.setTileMeta(x,y,z,0);
                    level.setTile(x,y,z, melonID);
                }
            }
        }

    }

    private float growCropStage(Level arg, int x, int y, int z) {
        float var5 = 1.0F;
        int var6 = arg.getTileId(x, y, z - 1);
        int var7 = arg.getTileId(x, y, z + 1);
        int var8 = arg.getTileId(x - 1, y, z);
        int var9 = arg.getTileId(x + 1, y, z);
        int var10 = arg.getTileId(x - 1, y, z - 1);
        int var11 = arg.getTileId(x + 1, y, z - 1);
        int var12 = arg.getTileId(x + 1, y, z + 1);
        int var13 = arg.getTileId(x - 1, y, z + 1);
        boolean var14 = var8 == this.id || var9 == this.id;
        boolean var15 = var6 == this.id || var7 == this.id;
        boolean var16 = var10 == this.id || var11 == this.id || var12 == this.id || var13 == this.id;

        for(int var17 = x - 1; var17 <= x + 1; ++var17) {
            for(int var18 = z - 1; var18 <= z + 1; ++var18) {
                int var19 = arg.getTileId(var17, y - 1, var18);
                float var20 = 0.0F;
                if (var19 == BlockBase.FARMLAND.id) {
                    var20 = 1.0F;
                    if (arg.getTileMeta(var17, y - 1, var18) > 0) {
                        var20 = 3.0F;
                    }
                }

                if (var17 != x || var18 != z) {
                    var20 /= 4.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15) {
            var5 /= 2.0F;
        }

        return var5;
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }
}
