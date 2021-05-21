package kz.chesschicken.ojw.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Logger
 */
public class OJWLogger {
    public static OJWLogger INSTANCE;

    public Logger RUNTIME;
    public Logger INIT;

    public OJWLogger()
    {
        RUNTIME = LogManager.getLogger("OldJunglesWorld|RUNTIME");
        INIT = LogManager.getLogger("OldJunglesWorld|INIT");
    }

    static {
        INSTANCE = new OJWLogger();
    }
}
