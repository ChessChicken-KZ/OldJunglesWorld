package kz.chesschicken.ojw.utils;


import java.io.File;
import java.net.URISyntaxException;

public class JarManipulation {

    /**
     * Provides minecraft.jar file as {@link java.io.File}
     * @return minecraft.jar
     */
    public static File getJar()
    {
        try {
            return new File(JarManipulation.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

}
