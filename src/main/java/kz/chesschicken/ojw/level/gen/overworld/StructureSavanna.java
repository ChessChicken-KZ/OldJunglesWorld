package kz.chesschicken.ojw.level.gen.overworld;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class StructureSavanna extends Structure {
    public boolean generate(Level world, Random random, int i, int j, int k) {
        boolean flag = true;
        int l = random.nextInt(3) + 7;
        if (j >= 1 && j + l + 1 <= 128) {
            int i1;
            int j2;
            int i3;
            int k3;
            for(i1 = j; i1 <= j + 1 + l; ++i1) {
                byte byte0 = 1;
                if (i1 == j) {
                    byte0 = 0;
                }

                if (i1 >= j + 1 + l - 2) {
                    byte0 = 2;
                }

                for(j2 = i - byte0; j2 <= i + byte0 && flag; ++j2) {
                    for(i3 = k - byte0; i3 <= k + byte0 && flag; ++i3) {
                        if (i1 >= 0 && i1 < 128) {
                            k3 = world.getTileId(j2, i1, i3);
                            if (k3 != 0 && k3 != BlockBase.LEAVES.id) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                i1 = world.getTileId(i, j - 1, k);
                if ((i1 == BlockBase.GRASS.id || i1 == BlockBase.DIRT.id) && j < 128 - l - 1) {
                    world.setTile(i, j - 1, k, BlockBase.DIRT.id);

                    int k1;
                    for(k1 = j - 2 + l; k1 <= j + l; ++k1) {
                        j2 = k1 - (j + l);
                        i3 = 1 - j2 / 1;

                        for(k3 = i - i3; k3 <= i + i3; ++k3) {
                            int l3 = k3 - i;

                            for(int i4 = k - i3; i4 <= k + i3; ++i4) {
                                int j4 = i4 - k;
                                if ((Math.abs(l3) != i3 || Math.abs(j4) != i3 || random.nextInt(2) != 0 && j2 != 0) && !BlockBase.FULL_OPAQUE[world.getTileId(k3, k1, i4)]) {
                                    world.setTile(k3, k1, i4, BlockBase.LEAVES.id);
                                }
                            }
                        }
                    }

                    for(k1 = 0; k1 < l; ++k1) {
                        j2 = world.getTileId(i, j + k1, k);
                        if (j2 == 0 || j2 == BlockBase.LEAVES.id) {
                            world.setTile(i, j + k1, k, BlockBase.LOG.id);
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
}
