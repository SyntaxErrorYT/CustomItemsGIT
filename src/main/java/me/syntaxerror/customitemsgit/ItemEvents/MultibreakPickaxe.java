package me.syntaxerror.customitemsgit.ItemEvents;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MultibreakPickaxe implements Listener {

    BlockFace blockface = null;

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        if(event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            blockface = event.getBlockFace();
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("§6Multibreak:")){
            if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                Block block1 = block.getRelative(BlockFace.EAST);
                Block block2 = block.getRelative(BlockFace.WEST);
                Block block3 = block.getRelative(BlockFace.NORTH);
                Block block4 = block.getRelative(BlockFace.SOUTH);
                Block block5 = block.getRelative(BlockFace.SOUTH_WEST);
                Block block6 = block.getRelative(BlockFace.SOUTH_EAST);
                Block block7 = block.getRelative(BlockFace.NORTH_WEST);
                Block block8 = block.getRelative(BlockFace.NORTH_EAST);
                blocks.add(block1);
                blocks.add(block2);
                blocks.add(block3);
                blocks.add(block4);
                blocks.add(block5);
                blocks.add(block6);
                blocks.add(block7);
                blocks.add(block8);
                for(Block b : blocks){
                    if (b.getType().equals(Material.STONE)) {
                        b.setType(Material.AIR);
                        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                            block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.STONE));
                        } else {
                            block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.COBBLESTONE));
                        }
                    }
                    else if (b.getType().equals(Material.COAL_ORE)) {
                        b.setType(Material.AIR);
                        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                            block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.COAL_ORE));
                        } else {
                            block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.COAL));
                        }
                    }
                    else if (b.getType().equals(Material.IRON_ORE)) {
                        b.setType(Material.AIR);
                        block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.IRON_ORE));
                    }
                    else if (b.getType().equals(Material.GOLD_ORE)) {
                        b.setType(Material.AIR);
                        block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.GOLD_ORE));
                    }
                }
                blocks.clear();
            }
            if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                Block block1 = block.getRelative(BlockFace.UP);
                Block block2 = block.getRelative(BlockFace.DOWN);
                Block block3 = block.getRelative(BlockFace.NORTH);
                Block block4 = block.getRelative(BlockFace.SOUTH);
                Block block5 = block1.getRelative(BlockFace.NORTH);
                Block block6 = block1.getRelative(BlockFace.SOUTH);
                Block block7 = block2.getRelative(BlockFace.NORTH);
                Block block8 = block2.getRelative(BlockFace.SOUTH);
                blocks.add(block1);
                blocks.add(block2);
                blocks.add(block3);
                blocks.add(block4);
                blocks.add(block5);
                blocks.add(block6);
                blocks.add(block7);
                blocks.add(block8);
                for(Block b : blocks){
                    if (b.getType().equals(Material.STONE)) {
                        b.setType(Material.AIR);
                        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                            block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.STONE));
                        } else {
                            block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.COBBLESTONE));
                        }
                    }
                }
                blocks.clear();
            }
            if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                Block block1 = block.getRelative(BlockFace.UP);
                Block block2 = block.getRelative(BlockFace.DOWN);
                Block block3 = block.getRelative(BlockFace.EAST);
                Block block4 = block.getRelative(BlockFace.WEST);
                Block block5 = block1.getRelative(BlockFace.EAST);
                Block block6 = block1.getRelative(BlockFace.WEST);
                Block block7 = block2.getRelative(BlockFace.EAST);
                Block block8 = block2.getRelative(BlockFace.WEST);
                blocks.add(block1);
                blocks.add(block2);
                blocks.add(block3);
                blocks.add(block4);
                blocks.add(block5);
                blocks.add(block6);
                blocks.add(block7);
                blocks.add(block8);
                for(Block b : blocks){
                    if (b.getType().equals(Material.STONE)) {
                        b.setType(Material.AIR);
                        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
                            block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.STONE));
                        } else {
                            block.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.COBBLESTONE));
                        }
                    }
                }
                blocks.clear();
            }
        }
    }
}
