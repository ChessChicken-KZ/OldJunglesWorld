package kz.chesschicken.ojw.block;


import kz.chesschicken.ojw.utils.portalworks.OJWPlayer;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.block.Portal;

public class SkyPortal extends Portal {
    public SkyPortal(Identifier i, int j) {
        super(i, j);
    }

    @Override
    public void onEntityCollision(Level level, int x, int y, int z, EntityBase entityBase) {
        if(entityBase instanceof PlayerBase) {
            if(((OJWPlayer)entityBase).getIsPortalReady())
            {
                ((OJWPlayer)entityBase).teleport(((PlayerBase) entityBase).dimensionId == 0 ? 1 : 0, new TeleportSKY());
                ((OJWPlayer)entityBase).setPortalReady(false);
                ((OJWPlayer)entityBase).setTime1(20D);
            }else
            {
                if(((OJWPlayer)entityBase).getTime1() > 10D)
                {
                    ((OJWPlayer)entityBase).setTime1( ((OJWPlayer)entityBase).getTime1() - 0.1D );
                }else
                {
                    ((OJWPlayer)entityBase).setPortalReady(true);
                }
            }
        }
    }

    public boolean method_736(Level arg, int x, int y, int z) {
        byte var5 = 0;
        byte var6 = 0;
        if (arg.getTileId(x - 1, y, z) == BlockBase.GLOWSTONE.id || arg.getTileId(x + 1, y, z) == BlockBase.GLOWSTONE.id) {
            var5 = 1;
        }

        if (arg.getTileId(x, y, z - 1) == BlockBase.GLOWSTONE.id || arg.getTileId(x, y, z + 1) == BlockBase.GLOWSTONE.id) {
            var6 = 1;
        }

        if (var5 == var6) {
            return false;
        } else {
            if (arg.getTileId(x - var5, y, z - var6) == 0) {
                x -= var5;
                z -= var6;
            }

            int var7;
            int var8;
            for(var7 = -1; var7 <= 2; ++var7) {
                for(var8 = -1; var8 <= 3; ++var8) {
                    boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;
                    if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3) {
                        int var10 = arg.getTileId(x + var5 * var7, y + var8, z + var6 * var7);
                        if (var9) {
                            if (var10 != BlockBase.GLOWSTONE.id) {
                                return false;
                            }
                        } else if (var10 != 0 && var10 != BlockBase.STILL_WATER.id) {
                            return false;
                        }
                    }
                }
            }

            arg.stopPhysics = true;

            for(var7 = 0; var7 < 2; ++var7) {
                for(var8 = 0; var8 < 3; ++var8) {
                    arg.setTile(x + var5 * var7, y + var8, z + var6 * var7, BlockBase.GLOWSTONE.id);
                }
            }

            arg.stopPhysics = false;
            return true;
        }
    }

    public void onAdjacentBlockUpdate(Level level, int x, int y, int z, int id) {
        byte var6 = 0;
        byte var7 = 1;
        if (level.getTileId(x - 1, y, z) == this.id || level.getTileId(x + 1, y, z) == this.id) {
            var6 = 1;
            var7 = 0;
        }

        int var8;
        for(var8 = y; level.getTileId(x, var8 - 1, z) == this.id; --var8) {
        }

        if (level.getTileId(x, var8 - 1, z) != BlockBase.GLOWSTONE.id) {
            level.setTile(x, y, z, 0);
        } else {
            int var9;
            for(var9 = 1; var9 < 4 && level.getTileId(x, var8 + var9, z) == this.id; ++var9) {
            }

            if (var9 == 3 && level.getTileId(x, var8 + var9, z) == BlockBase.GLOWSTONE.id) {
                boolean var10 = level.getTileId(x - 1, y, z) == this.id || level.getTileId(x + 1, y, z) == this.id;
                boolean var11 = level.getTileId(x, y, z - 1) == this.id || level.getTileId(x, y, z + 1) == this.id;
                if (var10 && var11) {
                    level.setTile(x, y, z, 0);
                } else if ((level.getTileId(x + var6, y, z + var7) != BlockBase.GLOWSTONE.id || level.getTileId(x - var6, y, z - var7) != this.id) && (level.getTileId(x - var6, y, z - var7) != BlockBase.GLOWSTONE.id || level.getTileId(x + var6, y, z + var7) != this.id)) {
                    level.setTile(x, y, z, 0);
                }
            } else {
                level.setTile(x, y, z, 0);
            }
        }
    }


}
