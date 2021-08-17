package kz.chesschicken.ojw.block.grass;

import kz.chesschicken.ojw.utils.metarefernce.objects.SimpleBlockWithMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.common.registry.Identifier;

@HasMetaNamedBlockItem
public class BlockGrassComplex extends SimpleBlockWithMeta {
    public BlockGrassComplex(Identifier identifier) {
        super(identifier, Material.ORGANIC, 2);
        this.setSounds(GRASS_SOUNDS);
    }


}
