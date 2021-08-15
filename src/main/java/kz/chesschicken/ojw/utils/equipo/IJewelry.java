package kz.chesschicken.ojw.utils.equipo;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;

/**
 * REWRITE THIS.
 * This class allows you to make your item wearable as jewelry and can give effects.
 *
 * The places where player can wear jewelry:
 * {@link JewelryType#HAT} stands for item that should be worn on player's head.
 * {@link JewelryType#NECKLACE } stands for item that should be worn on player's necklace.
 * {@link JewelryType#BACKPACK } stands for item that should be worn on player's back.
 * {@link JewelryType#RING } stands for item that should be worn on player's hand.
 * {@link JewelryType#BELT } stands for item that should be worn on player's side, where usually belt is worn.
 * {@link JewelryType#BOOTS } stands for item that should be worn on player's legs.
 */
public interface IJewelry {

    @SuppressWarnings("unused")
    public static enum JewelryType
    {
        HAT("jewelry.hat"),
        NECKLACE("jewelry.necklace"),
        BACKPACK("jewelry.backpack"), //backpack?
        RING("jewelry.ring"),
        BELT("jewelry.belt"),
        BOOTS("jewelry.boots");

        private final String translation;
        JewelryType(String t)
        {
            this.translation = t;
        }

        public String getTranslation()
        {
            return this.translation;
        }
    }

    /**
     * Use this method to identify the type of your jewelry item, so game could understand is it for necklace, or for legs.
     * @return the jewelry type for item.
     */
    public JewelryType getJewelryType();

    /**
     * Use this method to make some tick events, create some effects for your jewelry when it's worm.
     * @param player Player.
     * @param jewelry ItemInstance of jewelry.
     */
    public default void tickJewelry(Level world, PlayerBase player, ItemInstance jewelry) { }


}
