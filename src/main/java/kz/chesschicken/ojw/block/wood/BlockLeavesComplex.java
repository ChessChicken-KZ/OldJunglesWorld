package kz.chesschicken.ojw.block.wood;

import kz.chesschicken.ojw.init.OJWContentListener;
import kz.chesschicken.ojw.utils.structure.WorldUtils;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.BlockHardnessPerMeta;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

import java.util.Random;

@HasMetaNamedBlockItem
public class BlockLeavesComplex extends TemplateBlockBase implements BlockHardnessPerMeta {
    public BlockLeavesComplex(Identifier i) {
        super(i, Material.LEAVES);
        this.setSounds(GRASS_SOUNDS);
        this.setLightOpacity(1);
        this.setTicksRandomly(true);
        this.disableNotifyOnMetaDataChange();
        this.disableStat();
    }

    @Override
    public int getTextureForSide(int side, int meta) {
        return MetaWood.metadataCollection[meta & MetaWood.metadataCollection.length].getLeavesTexture();
    }

    @Override
    public boolean isFullOpaque() {
        return false;
    }

    @Override
    public float getHardness(int meta) {
        return MetaWood.metadataCollection[meta & MetaWood.metadataCollection.length].getHardnessAsLeaves();
    }


    @Override
    public void onBlockRemoved(Level level, int x, int y, int z) {
        if (level.method_155(x - 2, y - 2, z - 2, x + 2, y + 2, z + 2)) {
            for(int ix = -1; ix <= 1; ++ix) {
                for(int iy = -1; iy <= 1; ++iy) {
                    for(int iz = -1; iz <= 1; ++iz) {
                        if (level.getTileId(x + ix, y + iy, z + iz) == OJWContentListener.blockLeavesComplex.id) {
                            level.method_223(x + ix, y + iy, z + iz, level.getTileMeta(x + ix, y + iy, z + iz) | 8);
                        }
                    }
                }
            }
        }

    }

    int[] arrayLeaves;
    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random rand) {
        if (!level.isClient) {
            int meta = WorldUtils.getMeta(level, x, y, z);
            if ((meta & 8) != 0) {
                if (this.arrayLeaves == null) {
                    this.arrayLeaves = new int[32 * 32 * 32];
                }

                int q;
                if (level.method_155(x - 5, y - 5, z - 5, x + 5, y + 5, z + 5)) {
                    q = -4;

                    weird_loop:
                    while(true) {
                        int var13;
                        int var14;
                        int var15;
                        if (q > 4) {
                            q = 1;

                            while(true) {
                                if (q > 4) {
                                    break weird_loop;
                                }

                                for(var13 = -4; var13 <= 4; ++var13) {
                                    for(var14 = -4; var14 <= 4; ++var14) {
                                        for(var15 = -4; var15 <= 4; ++var15) {
                                            if (this.arrayLeaves[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16] == q - 1) {
                                                if (this.arrayLeaves[(var13 + 16 - 1) * 1024 + (var14 + 16) * 32 + var15 + 16] == -2) {
                                                    this.arrayLeaves[(var13 + 16 - 1) * 1024 + (var14 + 16) * 32 + var15 + 16] = q;
                                                }

                                                if (this.arrayLeaves[(var13 + 16 + 1) * 1024 + (var14 + 16) * 32+ var15 + 16] == -2) {
                                                    this.arrayLeaves[(var13 + 16 + 1) * 1024 + (var14 + 16) * 32 + var15 + 16] = q;
                                                }

                                                if (this.arrayLeaves[(var13 + 16) * 1024 + (var14 + 16 - 1) * 32 + var15 + 16] == -2) {
                                                    this.arrayLeaves[(var13 + 16) * 1024 + (var14 + 16 - 1) * 32 + var15 + 16] = q;
                                                }

                                                if (this.arrayLeaves[(var13 + 16) * 1024 + (var14 + 16 + 1) * 32 + var15 + 16] == -2) {
                                                    this.arrayLeaves[(var13 + 16) * 1024 + (var14 + 16 + 1) * 32+ var15 + 16] = q;
                                                }

                                                if (this.arrayLeaves[(var13 + 16) * 1024 + (var14 + 16) * 32 + (var15 + 16 - 1)] == -2) {
                                                    this.arrayLeaves[(var13 + 16) * 1024 + (var14 + 16) * 32 + (var15 + 16 - 1)] = q;
                                                }

                                                if (this.arrayLeaves[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16 + 1] == -2) {
                                                    this.arrayLeaves[(var13 + 16) * 1024 + (var14 + 16) * 32 + var15 + 16 + 1] = q;
                                                }
                                            }
                                        }
                                    }
                                }

                                ++q;
                            }
                        }

                        for(var13 = -4; var13 <= 4; ++var13) {
                            for(var14 = -4; var14 <= 4; ++var14) {
                                var15 = level.getTileId(x + q, y + var13, z + var14);
                                if (var15 == OJWContentListener.blockLogComplex.id) {
                                    this.arrayLeaves[(q + 16) * 1024 + (var13 + 16) * 32 + var14 + 16] = 0;
                                } else if (var15 == OJWContentListener.blockLeavesComplex.id) {
                                    this.arrayLeaves[(q + 16) * 1024 + (var13 + 16) * 32 + var14 + 16] = -2;
                                } else {
                                    this.arrayLeaves[(q + 16) * 1024 + (var13 + 16) * 32 + var14 + 16] = -1;
                                }
                            }
                        }

                        ++q;
                    }
                }

                q = this.arrayLeaves[16 * 1024 + 16 * 32 + 16];
                if (q >= 0) {
                    level.method_223(x, y, z, meta & -9);
                } else {
                    this.drop(level, x, y, z, level.getTileMeta(x, y, z));
                    level.setTile(x, y, z, 0);
                }
            }

        }
    }

    @Override
    public int getDropCount(Random rand) {
        return rand.nextInt(20) == 0 ? 1 : 0;
    }

    @Override
    public int getDropId(int meta, Random rand) {
        return super.getDropId(meta, rand);
    }
}
