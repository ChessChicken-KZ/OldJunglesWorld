package kz.chesschicken.ojw.utils;

public class ArrayUtils {
    public static void reverse(byte[] array)
    {
        byte b;
        for (int i = 0; i < array.length / 2; i++) {
            b = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = b;
        }
    }
}
