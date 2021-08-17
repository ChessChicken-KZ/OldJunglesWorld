package kz.chesschicken.ojw.utils.playerhunger;

/**
 * This interface allows to get hunger/absorption info and manipulate them.
 * As you can see, this mod adds hunger mechanic.
 */
public interface IPlayerHunger {

    /**
     * Returns max possible value of hunger/absorption.
     * @return value.
     */
    int maxHunger();

    /**
     * Gets player's current hunger count.
     * @return value.
     */
    int getHunger();

    /**
     * Sets player's hunger to specific value.
     * @param i value.
     */
    void setHunger(int i);

    /**
     * Adds hunger points to player.
     * @param i value.
     */
    void addHunger(int i);

    /**
     * Gets player's current absorption count.
     * @return value.
     */
    int getAbsorption();

    /**
     * Sets player's absorption to specific value.
     * @param i value.
     */
    void setAbsorption(int i);

    /**
     * Adds absorption points to player.
     * @param i value.
     */
    void addAbsorption(int i);

    /**
     * Set poison effect (hunger) in ticks.
     * @param i Time.
     */
    void setPoison(int i);

    /**
     * Get remained time of poison effect (hunger) int ticks.
     * @return Time.
     */
    int getPoison();

    /**
     * Return true if the tick time of posion effect (hunger) > 0
     * @return State.
     */
    boolean isPoisoned();

}
