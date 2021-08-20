package kz.chesschicken.ojw.block.firstcollection;

import kz.chesschicken.ojw.utils.metarefernce.objects.BlockExtendedMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.registry.Identifier;

/**
 * Uses for generic blocks with {@link Material#STONE} material.
 */
@HasMetaNamedBlockItem
public class BlockBlockComplex extends BlockExtendedMeta {
    public BlockBlockComplex(Identifier identifier) {
        super(identifier, Material.STONE, 2);
    }

}
