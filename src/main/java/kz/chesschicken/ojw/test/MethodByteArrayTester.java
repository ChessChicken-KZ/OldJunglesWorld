package kz.chesschicken.ojw.test;

import java.util.function.Consumer;
import java.util.function.Function;

import static kz.chesschicken.ojw.utils.MethodArrayByte.*;

public class MethodByteArrayTester {

    public static void main(String[] a) {
        CLEAN();
        SET(-127, (Function<Integer, Boolean>) integer -> integer > 0);
        SET(0, (Consumer<String>) s -> {
            for(int i = 0; i < s.length(); i++) {
                System.out.println(s.charAt(i) + " " + s.charAt(s.length() - 1));
            }
        });

        MOVE(0, 56);

        INVOKE(56, "HELLO");
    }
}
