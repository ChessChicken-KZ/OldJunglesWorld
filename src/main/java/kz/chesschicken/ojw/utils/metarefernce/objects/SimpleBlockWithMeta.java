package kz.chesschicken.ojw.utils.metarefernce.objects;

import kz.chesschicken.ojw.utils.metarefernce.MetaBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.common.block.*;
import net.modificationstation.stationapi.api.common.item.tool.ToolLevel;
import net.modificationstation.stationapi.api.common.registry.Identifier;
import net.modificationstation.stationapi.template.common.block.BlockBase;

import java.util.List;
import java.util.Random;

@HasMetaNamedBlockItem
public class SimpleBlockWithMeta extends BlockBase implements BlockHardnessPerMeta, BlockEffectiveOnMeta, BlockStrengthPerMeta, BlockMiningLevel {

    public final MetaBlock[] metadataCollection;

    public SimpleBlockWithMeta(Identifier identifier, Material material, int capacity) {
        super(identifier, material);
        metadataCollection = new MetaBlock[capacity];
    }

    public void addMetaBlock(MetaBlock metaBlock) {
        metaBlock.setObjectID(this.id);
        metadataCollection[metaBlock.metadata] = metaBlock;
    }

    @Override
    public float isToolEffectiveOn(int i, ItemInstance itemInstance) {
        return metadataCollection[i].getToolEffectivness(itemInstance);
    }

    @Override
    public float getHardness(int i) {
        return metadataCollection[i].getHardness();
    }

    @Override
    public float getBlockStrength(PlayerBase playerBase, int i) {
        return metadataCollection[i].getResistance(playerBase);
    }

    @Override
    public int getBlockLevel(int i, ItemInstance itemInstance) {
        return metadataCollection[i].getBlockMiningLevel(itemInstance);
    }

    @Override
    public List<Class<? extends ToolLevel>> getToolTypes(int i, ItemInstance itemInstance) {
        return metadataCollection[i].getToolTypes(itemInstance);
    }

    @Override
    public int getTextureForSide(int side, int i) {
        return metadataCollection[i].getTextureSide(side);
    }

    @Override
    protected int droppedMeta(int i) {
        return metadataCollection[i].getDropMetadata();
    }

    @Override
    public int getDropId(int i, Random rand) {
        return metadataCollection[i].getDropID(rand);
    }
}