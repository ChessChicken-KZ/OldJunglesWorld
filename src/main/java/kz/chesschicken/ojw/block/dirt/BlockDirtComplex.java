package kz.chesschicken.ojw.block.dirt;

import kz.chesschicken.ojw.utils.metarefernce.objects.SimpleBlockWithMeta;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.common.block.HasMetaNamedBlockItem;
import net.modificationstation.stationapi.api.common.registry.Identifier;

/*

0 - FrozenDirt
1 - GlitchDirt

 */
@HasMetaNamedBlockItem
public class BlockDirtComplex extends SimpleBlockWithMeta {
    public BlockDirtComplex(Identifier identifier) {
        super(identifier, Material.DIRT, 2);
        this.setSounds(GRAVEL_SOUNDS);
    }


}
