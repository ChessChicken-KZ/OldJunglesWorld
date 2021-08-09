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
    public int maxHunger();

    /**
     * Gets player's current hunger count.
     * @return value.
     */
    public int getHunger();

    /**
     * Sets player's hunger to specific value.
     * @param i value.
     */
    public void setHunger(int i);

    /**
     * Adds hunger points to player.
     * @param i value.
     */
    public void addHunger(int i);

    /**
     * Gets player's current absorption count.
     * @return value.
     */
    public int getAbsorption();

    /**
     * Sets player's absorption to specific value.
     * @param i value.
     */
    public void setAbsorption(int i);

    /**
     * Adds absorption points to player.
     * @param i value.
     */
    public void addAbsorption(int i);

    /**
     * Set poison effect (hunger) in ticks.
     * @param i Time.
     */
    public void setPoison(int i);

    /**
     * Get remained time of poison effect (hunger) int ticks.
     * @return Time.
     */
    public int getPoison();

    /**
     * Return true if the tick time of posion effect (hunger) > 0
     * @return State.
     */
    public boolean isPoisoned();

}
