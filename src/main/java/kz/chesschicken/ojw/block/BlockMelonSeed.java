package kz.chesschicken.ojw.block;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.init.OJWTextureListener;
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

        this.setBoundingBox(0.375F, 0.0F, 0.375F, 0.625F, 0.25F, 0.625F);
    }

    public boolean canPlaceAt(Level level, int x, int y, int z) {
        return super.canPlaceAt(level, x, y, z) && level.getTileId(x, y - 1, z) == BlockBase.FARMLAND.id;
    }

    public int getDropId(int meta, Random rand) {
        return meta == 7 ? OJWContentListener.itemMelonSeeds.id : 0;
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        if(meta > 1 && meta < 8)
            return OJWTextureListener.textureMelonCrop[meta - 1];
        else
            return OJWTextureListener.textureMelonCrop[0];
    }

    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public int getDropCount(Random rand) {
        return rand.nextInt(2) + 1;
    }

    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        if (level.placeTile(x, y + 1, z) >= 9) {
            int var6 = level.getTileMeta(x, y, z);
            if (var6 < 7) {
                float var7 = this.growingStage(level, x, y, z);
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

    public void growIt(Level arg, int x, int y, int z) {
        arg.setTileMeta(x, y, z, 7);
    }

    public float growingStage(Level arg, int x, int y, int z) {
        float sending = 1.0F;
        int mZ = arg.getTileId(x, y, z - 1);
        int pZ = arg.getTileId(x, y, z + 1);
        int mX = arg.getTileId(x - 1, y, z);
        int pX = arg.getTileId(x + 1, y, z);
        int mXZ = arg.getTileId(x - 1, y, z - 1);
        int pXmZ = arg.getTileId(x + 1, y, z - 1);
        int pXZ = arg.getTileId(x + 1, y, z + 1);
        int mXpZ = arg.getTileId(x - 1, y, z + 1);
        boolean eqX = mX == this.id || pX == this.id;
        boolean eqZ = mZ == this.id || pZ == this.id;
        boolean eqAny = mXZ == this.id || pXmZ == this.id || pXZ == this.id || mXpZ == this.id;

        for(int varX = x - 1; varX <= x + 1; ++varX) {
            for(int varZ = z - 1; varZ <= z + 1; ++varZ) {
                int farmBlock = arg.getTileId(varX, y - 1, varZ);
                float var1 = 0.0F;
                if (farmBlock == BlockBase.FARMLAND.id) {
                    var1 = 1.0F;
                    if (arg.getTileMeta(varX, y - 1, varZ) > 0) {
                        var1 = 3.0F;
                    }
                }

                if (varX != x || varZ != z) {
                    var1 /= 4.0F;
                }

                sending += var1;
            }
        }

        if (eqAny || eqX && eqZ) {
            sending /= 2.0F;
        }

        return sending;
    }

    public void beforeDestroyedByExplosion(Level level, int x, int y, int z, int meta, float dropChance) {
        super.beforeDestroyedByExplosion(level, x, y, z, meta, dropChance);
        if (!level.isClient) {
            for(int i = 0; i < 3; ++i) {
                if (level.rand.nextInt(15) <= meta) {
                    float posX = level.rand.nextFloat() * 0.7F + 0.3F * 0.5F;
                    float posY = level.rand.nextFloat() * 0.7F + 0.3F * 0.5F;
                    float posZ = level.rand.nextFloat() * 0.7F + 0.3F * 0.5F;
                    Item entityItem = new Item(level, (float)x + posX, (float)y + posY, (float)z + posZ, new ItemInstance(OJWContentListener.itemMelonSeeds));
                    entityItem.pickupDelay = 10;
                    level.spawnEntity(entityItem);
                }
            }

        }
    }
}
