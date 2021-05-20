package kz.chesschicken.ojw.level.gen.overworld;



import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;
import net.minecraft.util.maths.MathHelper;

import java.util.Random;

public class HugeTrees extends Structure {
    public boolean generate(Level world, Random random, int i, int j, int k) {
        boolean var7 = true;
        int var6 = random.nextInt(23) + 10;
        if (j >= 1 && j + var6 + 1 <= 256) {
            int var8;
            int var10;
            int var11;
            int var12;
            for(var8 = j; var8 <= j + 1 + var6; ++var8) {
                byte var9 = 2;
                if (var8 == j) {
                    var9 = 1;
                }

                if (var8 >= j + 1 + var6 - 2) {
                    var9 = 2;
                }

                for(var10 = i - var9; var10 <= i + var9 && var7; ++var10) {
                    for(var11 = k - var9; var11 <= k + var9 && var7; ++var11) {
                        if (var8 >= 0 && var8 < 256) {
                            var12 = world.getTileId(var10, var8, var11);
                            if (var12 != 0 && var12 != BlockBase.LEAVES.id && var12 != BlockBase.GRASS.id && var12 != BlockBase.DIRT.id && var12 != BlockBase.LOG.id && var12 != BlockBase.SAPLING.id) {
                                var7 = false;
                            }
                        } else {
                            var7 = false;
                        }
                    }
                }
            }

            if (!var7) {
                return false;
            } else {
                var8 = world.getTileId(i, j - 1, k);
                if ((var8 == BlockBase.GRASS.id || var8 == BlockBase.DIRT.id) && j < 256 - var6 - 1) {
                    world.setTileWithMetadata(i, j - 1, k, BlockBase.DIRT.id, 0);
                    world.setTileWithMetadata(i + 1, j - 1, k, BlockBase.DIRT.id, 0);
                    world.setTileWithMetadata(i, j - 1, k + 1, BlockBase.DIRT.id, 0);
                    world.setTileWithMetadata(i + 1, j - 1, k + 1, BlockBase.DIRT.id, 0);
                    this.growLeaves(world, i, k, j + var6, 2, random);

                    for(int var14 = j + var6 - 2 - random.nextInt(4); var14 > j + var6 / 2; var14 -= 2 + random.nextInt(4)) {
                        float var15 = random.nextFloat() * 3.1415927F * 2.0F;
                        var11 = i + (int)(0.5F + MathHelper.cos(var15) * 4.0F);
                        var12 = k + (int)(0.5F + MathHelper.sin(var15) * 4.0F);
                        this.growLeaves(world, var11, var12, var14, 0, random);

                        for(int var13 = 0; var13 < 5; ++var13) {
                            var11 = i + (int)(1.5F + MathHelper.cos(var15) * (float)var13);
                            var12 = k + (int)(1.5F + MathHelper.sin(var15) * (float)var13);
                            world.setTileWithMetadata(var11, var14 - 3 + var13 / 2, var12, BlockBase.LOG.id, 0);
                        }
                    }

                    for(var10 = 0; var10 < var6; ++var10) {
                        var11 = world.getTileId(i, j + var10, k);
                        if (var11 == 0 || var11 == BlockBase.LEAVES.id) {
                            world.setTileWithMetadata(i, j + var10, k, BlockBase.LOG.id, 0);
                        }

                        if (var10 < var6 - 1) {
                            var11 = world.getTileId(i + 1, j + var10, k);
                            if (var11 == 0 || var11 == BlockBase.LEAVES.id) {
                                world.setTileWithMetadata(i + 1, j + var10, k, BlockBase.LOG.id, 0);
                            }

                            var11 = world.getTileId(i + 1, j + var10, k + 1);
                            if (var11 == 0 || var11 == BlockBase.LEAVES.id) {
                                world.setTileWithMetadata(i + 1, j + var10, k + 1, BlockBase.LOG.id, 0);
                            }

                            var11 = world.getTileId(i, j + var10, k + 1);
                            if (var11 == 0 || var11 == BlockBase.LEAVES.id) {
                                world.setTileWithMetadata(i, j + var10, k + 1, BlockBase.LOG.id, 0);
                            }
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private void growLeaves(Level world, int par2, int i, int j, int k, Random random) {
        byte var7 = 2;

        for(int var8 = j - var7; var8 <= j; ++var8) {
            int var9 = var8 - j;
            int var10 = k + 1 - var9;

            for(int var11 = par2 - var10; var11 <= par2 + var10 + 1; ++var11) {
                int var12 = var11 - par2;

                for(int var13 = i - var10; var13 <= i + var10 + 1; ++var13) {
                    int var14 = var13 - i;
                    if ((var12 >= 0 || var14 >= 0 || var12 * var12 + var14 * var14 <= var10 * var10) && (var12 <= 0 && var14 <= 0 || var12 * var12 + var14 * var14 <= (var10 + 1) * (var10 + 1)) && (random.nextInt(4) != 0 || var12 * var12 + var14 * var14 <= (var10 - 1) * (var10 - 1))) {
                        int var15 = world.getTileId(var11, var8, var13);
                        if (var15 == 0 || var15 == BlockBase.LEAVES.id) {
                            world.setTileWithMetadata(var11, var8, var13, BlockBase.LEAVES.id, 0);
                        }
                    }
                }
            }
        }

    }
}
