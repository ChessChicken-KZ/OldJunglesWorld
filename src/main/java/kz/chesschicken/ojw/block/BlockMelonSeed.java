package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWContentListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.block.Plant;

import java.util.Random;

/**
 * Melon Plant
 */
public class BlockMelonSeed extends Plant {
    private final int melonID;
    public BlockMelonSeed(Identifier identifier, int melonID) {
        super(identifier, 0);
        this.melonID = melonID;
        this.setTicksRandomly(true);
        this.setHardness(0.0F);
        this.setSounds(GRASS_SOUNDS);
        this.disableStat();
        this.disableNotifyOnMetaDataChange();

        float var3 = 0.125F;
        this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);

    }

    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return super.canPlaceAt(level, x, y, z) && level.getTileId(x, y - 1, z) == BlockBase.FARMLAND.id;
    }


    public int getDropId(int meta, Random rand) {
        return meta == 7 ? OJWContentListener.itemMelonSeeds.id : 0;
    }


    @Override
    public int getTextureForSide(int side, int meta) {
        switch (meta)
        {
            case 2: return OJWContentListener.texture_MelonTile[1];
            case 3: return OJWContentListener.texture_MelonTile[2];
            case 4: return OJWContentListener.texture_MelonTile[3];
            case 5: return OJWContentListener.texture_MelonTile[4];
            case 6: return OJWContentListener.texture_MelonTile[5];
            case 7: return OJWContentListener.texture_MelonTile[6];

            default: return OJWContentListener.texture_MelonTile[0];
        }
    }

    @Override
    public int getDropCount(Random rand) {
        return rand.nextInt(2) + 1;
    }

    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
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
                level.setTileMeta(x, y, z, var6);
                if(rand.nextInt(2) == 0)
                {
                    level.setTileMeta(x,y,z,0);
                    level.setTile(x,y,z, melonID);
                }
            }
        }

    }

    public void growCropInstantly(Level arg, int x, int y, int z) {
        arg.setTileMeta(x, y, z, 7);

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

    public void beforeDestroyedByExplosion(Level level, int x, int y, int z, int meta, float dropChance) {
        super.beforeDestroyedByExplosion(level, x, y, z, meta, dropChance);
        if (!level.isClient) {
            for(int var7 = 0; var7 < 3; ++var7) {
                if (level.rand.nextInt(15) <= meta) {
                    float var8 = 0.7F;
                    float var9 = level.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    float var10 = level.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    float var11 = level.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    Item var12 = new Item(level, (double)((float)x + var9), (double)((float)y + var10), (double)((float)z + var11), new ItemInstance(OJWContentListener.itemMelonSeeds));
                    var12.pickupDelay = 10;
                    level.spawnEntity(var12);
                }
            }

        }
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }
}
