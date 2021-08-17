package kz.chesschicken.ojw.utils;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.block.BlockBase;

public abstract class BlockAbstract extends BlockBase {
    public BlockAbstract(Identifier identifier, Material material) {
        super(identifier, material);
        register(identifier);
    }

    public abstract void register(Identifier identifier);
}
