package kz.chesschicken.ojw.utils;


import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;

public class JarManipulation {
    /**
     * Avoid using it.
     * @param s File path
     * @return InputStream of file.
     */
    @Deprecated
    public static InputStream accessFile(String s)
    {
        InputStream inputStream = JarManipulation.class.getResourceAsStream(s);
        if(inputStream == null) inputStream = JarManipulation.class.getClassLoader().getResourceAsStream(s);

        return  inputStream;
    }

    /**
     * Provides minecraft.jar file as {@link java.io.File}
     *
     * @exception URISyntaxException if something went wrong, this will throw out.
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
