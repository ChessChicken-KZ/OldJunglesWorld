package kz.chesschicken.ojw.utils.dimension;

import lombok.SneakyThrows;
import net.minecraft.level.dimension.Dimension;
import net.minecraft.level.dimension.Nether;
import net.minecraft.level.dimension.Overworld;
import net.minecraft.level.dimension.Skylands;
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
        DIMAPI_LOGGER.debug("Successfully registered dimension " + i + " ! " + s.toString());
    }

    @SneakyThrows
    public void overrideDimension(int i, Dimension s) {

        if (!dimensionMap.containsKey(i) || dimensionMap.get(i) == null)
            throw new UnexpectedException("Dimension with id " + i + " does not exist! Use register(ILnet.minecraft.level.dimension.Dimension;)V for it.");

        dimensionMap.replace(i, s);
        DIMAPI_LOGGER.debug("Successfully did override dimension " + i + " ! " + s.toString());
    }


    public Dimension getDimension(int i)
    {
        DIMAPI_LOGGER.debug("returning " + dimensionMap.get(i).toString());
        return dimensionMap.get(i);
    }

    public int getDimensionSize()
    {
        return dimensionMap.size();
    }








    public static DimensionEvent INSTANCE;
    static {
        INSTANCE = new DimensionEvent();
        DimensionEvent.INSTANCE.register(-1, new Nether());
        DimensionEvent.INSTANCE.register(0, new Overworld());
        DimensionEvent.INSTANCE.register(1, new Skylands());
    }

}
