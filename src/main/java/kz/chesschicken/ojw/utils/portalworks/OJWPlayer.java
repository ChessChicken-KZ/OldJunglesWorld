package kz.chesschicken.ojw.utils.portalworks;

/**
 * Basically this is must-have interface if you want to work with OldJungleWorld's features, like teleport() or etc.
 */
public interface OJWPlayer {


    public void teleport(int id, net.minecraft.class_467 t);

    public boolean getIsPortalReady();

    public void setPortalReady(boolean b);

    public double getTime1();

    public void setTime1(double i);

}
