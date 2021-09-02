package kz.chesschicken.ojw.utils.jewelryapi;

@SuppressWarnings("unused")
public enum JewelryType {

    HAT("jewelry.hat"),
    NECKLACE("jewelry.necklace"),
    BACKPACK("jewelry.backpack"), //backpack?
    RING("jewelry.ring"),
    BELT("jewelry.belt"),
    BOOTS("jewelry.boots");

    private final String translation;

    JewelryType(String t) {
        this.translation = t;
    }

    public String getTranslation() {
        return this.translation;
    }

    public static JewelryType getByID(byte b) {
        return JewelryType.values()[b];
    }
}
