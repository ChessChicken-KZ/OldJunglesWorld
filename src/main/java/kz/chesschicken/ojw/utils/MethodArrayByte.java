package kz.chesschicken.ojw.utils;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodArrayByte {
    public static Object[] OBJECTS = new Object[256];

    public static void CLEAN() {
        Arrays.fill(OBJECTS, null);
    }

    public static void SET(byte b, Object f) {
        OBJECTS[b + 127] = f;
    }

    public static Object GET(byte b) {
        if(OBJECTS[b + 127] != null)
            return OBJECTS[b + 127];
        return "NULL";
    }

    public static void DEL(byte b) {
        OBJECTS[b + 127] = null;
    }

    public static void MOVE(byte b, byte b1) {
        if(OBJECTS[b + 127] != null) {
            OBJECTS[b1 + 127] = OBJECTS[b + 127];
            OBJECTS[b + 127] = null;
        }
    }

    @SuppressWarnings("all")
    public static Object INVOKE(byte b, Object... objects) {
        if(OBJECTS[b + 127] != null) {
            Object o = OBJECTS[b + 127];

            if(o instanceof Consumer) {
                ((Consumer) OBJECTS[b + 127]).accept(objects[0]);
                return true;
            }

            if(o instanceof Function)
                return ((Function) OBJECTS[b + 127]).apply(objects[0]);

            if(o instanceof BiFunction)
                return ((BiFunction) OBJECTS[b + 127]).apply(objects[0], objects[1]);
        }

        return false;
    }



    public static void MOVE(int i, int i1) {
        MOVE((byte) i, (byte) i1);
    }

    public static void SET(int b, Object f) {
        SET((byte) b, f);
    }

    public static Object INVOKE(int i, Object... objects) {
        return INVOKE((byte) i, objects);
    }


    public static byte fromBool(boolean b) {
        return b ? (byte) 1 : (byte) 0;
    }
}
