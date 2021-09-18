package kz.chesschicken.ojw.utils.extendedblocks;

public interface CustomBoundingBoxPerMeta {

    /**
     * 0 - minX
     * 1 - minY
     * 2 - minZ
     * 3 - maxX
     * 4 - maxY
     * 5 - maxZ
     * @param meta Meta.
     * @return Float array for bounding boxes.
     */
    float[] getBoundingBoxes(int meta);
}
