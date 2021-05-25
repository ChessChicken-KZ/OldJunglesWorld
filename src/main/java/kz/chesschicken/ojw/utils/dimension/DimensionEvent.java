package kz.chesschicken.ojw.utils.dimension;

import lombok.SneakyThrows;
import net.minecraft.level.dimension.Dimension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.rmi.UnexpectedException;
import java.util.HashMap;

/*
 * Daiver, smotri kakoi primitive code lvl 80.
 */
public class DimensionEvent {
    private final Logger DIMAPI_LOGGER = LogManager.getLogger("OldJunglesWorld|DIMENSION-API");
    private final HashMap<Integer, Dimension> dimensionMap = new HashMap<>();


    @SneakyThrows
    public void register(int i, Dimension s)
    {
        if(dimensionMap.containsKey(i))
            throw new UnexpectedException("Dimension with id " + i + " is already registered!");

        dimensionMap.put(i, s);
        DIMAPI_LOGGER.info("Successfully registered dimension " + i + " ! " + s.toString());
    }


    public Dimension getDimension(int i)
    {
        System.out.println("returning " + dimensionMap.get(i).toString());
        return dimensionMap.get(i);
    }








    public static DimensionEvent INSTANCE;
    static {
        INSTANCE = new DimensionEvent();
    }

}
