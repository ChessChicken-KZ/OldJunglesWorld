package kz.chesschicken.ojw.utils;

import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;

public abstract class BlockAbstract extends TemplateBlockBase {
    public BlockAbstract(Identifier identifier, Material material) {
        super(identifier, material);
        register(identifier);
    }

    public abstract void register(Identifier identifier);
}
