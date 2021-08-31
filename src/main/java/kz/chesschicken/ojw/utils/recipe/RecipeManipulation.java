package kz.chesschicken.ojw.utils.recipe;

import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeRegistry;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A small class created for Recipes manipulation.
 * @author ChessChicken-KZ
 */
public class RecipeManipulation {

    public List<Recipe> getAvailableRecipes(ItemInstance item)
    {
        List<Recipe> output = new ArrayList<>();

        for(Object object : RecipeRegistry.getInstance().getRecipes()) {
            if(((Recipe) object).getOutput() == item)
                output.add((Recipe) object);
        }

        return output;
    }

    public void removeAllRecipes(ItemInstance item)
    {
        for(Object object : RecipeRegistry.getInstance().getRecipes()) {
            if(((Recipe) object).getOutput() == item)
                RecipeRegistry.getInstance().getRecipes().remove(object);
        }
    }

    public void overwriteAllRecipes(ItemInstance currentItem, boolean shaped, Object... objects)
    {
        removeAllRecipes(currentItem);
        if(shaped)
            CraftingRegistry.addShapedRecipe(currentItem, objects);
        else
            CraftingRegistry.addShapelessRecipe(currentItem, objects);
    }


    public void removeSpecificRecipe(Recipe recipe)
    {
        RecipeRegistry.getInstance().getRecipes().remove(recipe);
    }

    public ShapedRecipe generateShapedRecipe(ItemInstance output, Object... objects) {
        StringBuilder stringBuilder = new StringBuilder();
        int a = 0;
        int b = 0;
        int c = 0;
        if (objects[a] instanceof String[]) {
            String[] var11 = (String[]) objects[a++];

            for (String var9 : var11) {
                ++c;
                b = var9.length();
                stringBuilder.append(var9);
            }
        } else {
            while(objects[a] instanceof String) {
                String var7 = (String)objects[a++];
                ++c;
                b = var7.length();
                stringBuilder.append(var7);
            }
        }

        HashMap<Character, ItemInstance> map1;
        for(map1 = new HashMap<>(); a < objects.length; a += 2) {
            Character var13 = (Character)objects[a];
            ItemInstance var15 = null;
            if (objects[a + 1] instanceof ItemBase) {
                var15 = new ItemInstance((ItemBase)objects[a + 1]);
            } else if (objects[a + 1] instanceof BlockBase) {
                var15 = new ItemInstance((BlockBase)objects[a + 1], 1, -1);
            } else if (objects[a + 1] instanceof ItemInstance) {
                var15 = (ItemInstance)objects[a + 1];
            }

            map1.put(var13, var15);
        }

        ItemInstance[] var14 = new ItemInstance[b * c];

        for(int var16 = 0; var16 < b * c; ++var16) {
            char var10 = stringBuilder.charAt(var16);
            if (map1.containsKey(var10)) {
                var14[var16] = map1.get(var10).copy();
            } else {
                var14[var16] = null;
            }
        }

        return new ShapedRecipe(b, c, var14, output);
    }

    public ShapelessRecipe generateShapelessRecipe(ItemInstance output, Object... objects) {
        ArrayList<ItemInstance> var3 = new ArrayList<>();
        for (Object obj : objects) {
            if (obj instanceof ItemInstance) {
                var3.add(((ItemInstance) obj).copy());
            } else if (obj instanceof ItemBase) {
                var3.add(new ItemInstance((ItemBase) obj));
            } else if (obj instanceof BlockBase) {
                var3.add(new ItemInstance((BlockBase) obj));
            }
        }

        return new ShapelessRecipe(output, var3);
    }

    private RecipeManipulation() { }
    private static RecipeManipulation INSTANCE;

    /**
     * Instance of the class. Use this one.
     * @return INSTANCE
     */
    public static RecipeManipulation getInstance()
    {
        if(INSTANCE == null)
            INSTANCE = new RecipeManipulation();
        return INSTANCE;
    }
}
