package kz.chesschicken.ojw.level.gen;

import net.minecraft.block.BlockBase;
import net.minecraft.level.Level;
import net.minecraft.level.structure.Structure;

import java.util.Random;

public class TreeTaiga4 extends Structure {
    public boolean generate(Level world, Random random, int i, int j, int k) {
        int l = random.nextInt(15) + 20;
        int i1 = 4 + random.nextInt(3);
        int k1 = 3 + random.nextInt(1);
        int j1 = l - i1;
        boolean flag = true;
        if (j >= 1 && j + l + 1 <= 128) {
            int l1;
            int i3;
            int k3;
            int k2;
            for(l1 = j; l1 <= j + 1 + l && flag; ++l1) {

                if (l1 - j < i1) {
                    k2 = 0;
                } else {
                    k2 = k1;
                }

                for(i3 = i - k2; i3 <= i + k2 && flag; ++i3) {
                    for(int j3 = k - k2; j3 <= k + k2 && flag; ++j3) {
                        if (l1 >= 0 && l1 < 128) {
                            k3 = world.getTileId(i3, l1, j3);
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
                l1 = world.getTileId(i, j - 1, k);
                if ((l1 == BlockBase.GRASS.id || l1 == BlockBase.DIRT.id) && j < 128 - l - 1) {
                    world.setTile(i, j - 1, k, BlockBase.DIRT.id);
                    k2 = random.nextInt(2);
                    i3 = 1;
                    boolean flag1 = false;

                    int j4;
                    int l4;
                    for(k3 = 0; k3 <= j1; ++k3) {
                        j4 = j + l - k3;

                        for(l4 = i - k2; l4 <= i + k2; ++l4) {
                            int j5 = l4 - i;

                            for(int k5 = k - k2; k5 <= k + k2; ++k5) {
                                int l5 = k5 - k;
                                if ((Math.abs(j5) != k2 || Math.abs(l5) != k2 || k2 <= 0) && !BlockBase.FULL_OPAQUE[world.getTileId(l4, j4, k5)]) {
                                    world.setTileWithMetadata(l4, j4, k5, BlockBase.LEAVES.id, 1);
                                }
                            }
                        }

                        if (k2 >= i3) {
                            k2 = flag1 ? 1 : 0;
                            flag1 = true;
                            ++i3;
                            if (i3 > k1) {
                                i3 = k1;
                            }
                        } else {
                            ++k2;
                        }
                    }

                    k3 = random.nextInt(3);

                    for(j4 = 0; j4 < l - k3; ++j4) {
                        l4 = world.getTileId(i, j + j4, k);
                        if (l4 == 0 || l4 == BlockBase.LEAVES.id) {
                            world.setTileWithMetadata(i, j + j4, k, BlockBase.LOG.id, 1);
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
