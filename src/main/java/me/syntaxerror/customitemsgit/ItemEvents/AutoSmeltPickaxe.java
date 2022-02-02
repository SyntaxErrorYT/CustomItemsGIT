package me.syntaxerror.customitemsgit.ItemEvents;

import me.syntaxerror.customitemsgit.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;

public class AutoSmeltPickaxe implements Listener {

    @EventHandler
    public void onBreak(BlockDropItemEvent event){
        if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() != null &&
                event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains(ItemManager.AutoSmeltPickaxe.getItemMeta().getLore().get(0))){

            Iterator<Recipe> recipes = Bukkit.recipeIterator();

            while(recipes.hasNext()){

                Recipe recipe = recipes.next();

                if(recipe instanceof FurnaceRecipe){

                    FurnaceRecipe furnacerecipe = (FurnaceRecipe) recipe;

                    for(int i = 0; i < event.getItems().size(); i++){

                        ItemStack drop = event.getItems().get(i).getItemStack();

                        if(furnacerecipe.getInputChoice().test(drop)){
                            ItemStack newdrop = furnacerecipe.getResult();
                            newdrop.setAmount(drop.getAmount());
                            event.getItems().remove(event.getItems().get(i));
                            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation().add(0.5, 0.5, 0.5), newdrop);
                        }
                    }
                }
            }
        }
    }
}
