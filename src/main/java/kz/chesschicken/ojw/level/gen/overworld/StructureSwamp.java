package kz.chesschicken.ojw.level.gen.overworld;

import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class StructureSwamp extends Structure {
    public boolean generate(Level world, Random random, int par3, int par4, int par5) {
        int var6;
        boolean var7 = true;

        for(var6 = random.nextInt(4) + 5; world.getMaterial(par3, par4 - 1, par5) == Material.WATER; --par4) {
        }


        if (par4 >= 1 && par4 + var6 + 1 <= 128) {
            int var8;
            int var10;
            int var11;
            int var12;
            for(var8 = par4; var8 <= par4 + 1 + var6; ++var8) {
                byte var9 = 1;
                if (var8 == par4) {
                    var9 = 0;
                }

                if (var8 >= par4 + 1 + var6 - 2) {
                    var9 = 3;
                }

                for(var10 = par3 - var9; var10 <= par3 + var9 && var7; ++var10) {
                    for(var11 = par5 - var9; var11 <= par5 + var9 && var7; ++var11) {
                        if (var8 >= 0 && var8 < 128) {
                            var12 = world.getTileId(var10, var8, var11);
                            if (var12 != 0 && var12 != BlockBase.LEAVES.id) {
                                if (var12 != BlockBase.STILL_WATER.id && var12 != BlockBase.FLOWING_WATER.id) {
                                    var7 = false;
                                } else if (var8 > par4) {
                                    var7 = false;
                                }
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
                var8 = world.getTileId(par3, par4 - 1, par5);
                if ((var8 == BlockBase.GRASS.id || var8 == BlockBase.DIRT.id) && par4 < 128 - var6 - 1) {
                    world.setTile(par3, par4 - 1, par5, BlockBase.DIRT.id);

                    int var16;
                    int var13;
                    for(var16 = par4 - 3 + var6; var16 <= par4 + var6; ++var16) {
                        var10 = var16 - (par4 + var6);
                        var11 = 2 - var10 / 2;

                        for(var12 = par3 - var11; var12 <= par3 + var11; ++var12) {
                            var13 = var12 - par3;

                            for(int var14 = par5 - var11; var14 <= par5 + var11; ++var14) {
                                int var15 = var14 - par5;
                                if ((Math.abs(var13) != var11 || Math.abs(var15) != var11 || random.nextInt(2) != 0 && var10 != 0) && !BlockBase.FULL_OPAQUE[world.getTileId(var12, var16, var14)]) {
                                    world.setTile(var12, var16, var14, BlockBase.LEAVES.id);
                                }
                            }
                        }
                    }

                    for(var16 = 0; var16 < var6; ++var16) {
                        var10 = world.getTileId(par3, par4 + var16, par5);
                        if (var10 == 0 || var10 == BlockBase.LEAVES.id || var10 == BlockBase.FLOWING_WATER.id || var10 == BlockBase.STILL_WATER.id) {
                            world.setTile(par3, par4 + var16, par5, BlockBase.LOG.id);
                        }
                    }

                    for(var16 = par4 - 3 + var6; var16 <= par4 + var6; ++var16) {
                        var10 = var16 - (par4 + var6);
                        var11 = 2 - var10 / 2;

                        for(var12 = par3 - var11; var12 <= par3 + var11; ++var12) {
                            for(var13 = par5 - var11; var13 <= par5 + var11; ++var13) {
                                if (world.getTileId(var12, var16, var13) == BlockBase.LEAVES.id) {
                                    if (random.nextInt(4) == 0 && world.getTileId(var12 - 1, var16, var13) == 0) {
                                        this.generateVines(world, var12 - 1, var16, var13, 8);
                                    }

                                    if (random.nextInt(4) == 0 && world.getTileId(var12 + 1, var16, var13) == 0) {
                                        this.generateVines(world, var12 + 1, var16, var13, 2);
                                    }

                                    if (random.nextInt(4) == 0 && world.getTileId(var12, var16, var13 - 1) == 0) {
                                        this.generateVines(world, var12, var16, var13 - 1, 1);
                                    }

                                    if (random.nextInt(4) == 0 && world.getTileId(var12, var16, var13 + 1) == 0) {
                                        this.generateVines(world, var12, var16, var13 + 1, 4);
                                    }
                                }
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

    private void generateVines(Level world, int par2, int par3, int par4, int par5) {
        world.setTile(par2, par3, par4, BlockBase.LEAVES.id);
        int var6 = 4;

        while(true) {
            --par3;
            if (world.getTileId(par2, par3, par4) != 0 || var6 <= 0) {
                return;
            }

            world.setTile(par2, par3, par4, BlockBase.LEAVES.id);
            --var6;
        }
    }
}
