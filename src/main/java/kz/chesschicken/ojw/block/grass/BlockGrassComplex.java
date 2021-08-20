package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.utils.metarefernce.objects.BlockSimpleMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockGrassComplex extends BlockSimpleMeta {
    public BlockGrassComplex(Identifier identifier) {
        super(identifier, Material.ORGANIC, 3);
        this.setSounds(GRASS_SOUNDS);
    }
}
