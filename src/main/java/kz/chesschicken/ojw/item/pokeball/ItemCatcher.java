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

public class ItemCatcher extends TemplateItemBase implements ItemWithEntity {
    public ItemCatcher(Identifier identifier) {
        super(identifier);
        this.setMaxStackSize(1);
    }

    @Override
    public Supplier<ItemEntity> getItemEntityFactory() {
        return NBTCatcher::new;
    }

    @Override
    public Function<CompoundTag, ItemEntity> getItemEntityNBTFactory() {
        return NBTCatcher::new;
    }

    @Override
    public TemplateItemBase setTranslationKey(ModID modID, String translationKey) {
        return super.setTranslationKey(modID, translationKey);
    }

    @Override
    public boolean useOnTile(ItemInstance item, PlayerBase player, Level level, int x, int y, int z, int facing) {
        if(!((NBTCatcher) HasItemEntity.cast(item).getItemEntity()).getCaughtMob().equals(""))
        {
            NBTCatcher nbt = ((NBTCatcher) HasItemEntity.cast(item).getItemEntity());
            Living base = (Living) EntityRegistry.create(nbt.getCaughtMob(), level);
            base.health = nbt.getHealth();
            base.setPosition(x, y + 1, z);

            HasItemEntity.cast(item).setItemEntity(new NBTCatcher());
            level.spawnEntity(base);
            return true;
        }
        return false;
    }

    @Override
    public void interactWithEntity(ItemInstance arg, Living arg1) {
        if(((NBTCatcher) HasItemEntity.cast(arg).getItemEntity()).getCaughtMob().equals(""))
        {
            HasItemEntity.cast(arg).setItemEntity(new NBTCatcher(
                    EntityRegistry.getStringId(arg1), arg1.health
            ));
            arg1.remove();
        }
        super.interactWithEntity(arg, arg1);
    }
}
