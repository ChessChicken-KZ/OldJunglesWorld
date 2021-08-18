package kz.chesschicken.ojw.item.pokeball;

import net.minecraft.entity.EntityRegistry;
import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.minecraft.util.io.CompoundTag;
import net.modificationstation.stationapi.api.item.nbt.HasItemEntity;
import net.modificationstation.stationapi.api.item.nbt.ItemEntity;
import net.modificationstation.stationapi.api.item.nbt.ItemWithEntity;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;

import java.util.function.Function;
import java.util.function.Supplier;

public class ItemPokeball extends TemplateItemBase implements ItemWithEntity {
    public ItemPokeball(Identifier identifier) {
        super(identifier);
        this.setMaxStackSize(1);
    }

    @Override
    public Supplier<ItemEntity> getItemEntityFactory() {
        return NBTPokeBall::new;
    }

    @Override
    public Function<CompoundTag, ItemEntity> getItemEntityNBTFactory() {
        return NBTPokeBall::new;
    }

    @Override
    public TemplateItemBase setTranslationKey(ModID modID, String translationKey) {
        return super.setTranslationKey(modID, translationKey);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        if(!((NBTPokeBall) HasItemEntity.cast(item).getItemEntity()).getCatchedMob().equals(""))
        {
            NBTPokeBall nbt = ((NBTPokeBall) HasItemEntity.cast(item).getItemEntity());
            Living base = (Living) EntityRegistry.create(nbt.getCatchedMob(), level);
            base.health = nbt.getHealth();
            base.setPosition(x, y + 1, z);

            HasItemEntity.cast(item).setItemEntity(new NBTPokeBall());
            level.spawnEntity(base);
            return true;
        }
        return false;
    }

    @Override
    public void interactWithEntity(ItemInstance arg, Living arg1) {
        if(((NBTPokeBall) HasItemEntity.cast(arg).getItemEntity()).getCatchedMob().equals(""))
        {
            HasItemEntity.cast(arg).setItemEntity(new NBTPokeBall(
                    EntityRegistry.getStringId(arg1), arg1.health
            ));
            arg1.remove();
        }
        super.interactWithEntity(arg, arg1);
    }
}
