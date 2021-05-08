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
            if(blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)){
                Block block1 = block.getRelative(BlockFace.EAST);
                Block block2 = block.getRelative(BlockFace.WEST);
                Block block3 = block.getRelative(BlockFace.NORTH);
                Block block4 = block.getRelative(BlockFace.SOUTH);
                Block block5 = block.getRelative(BlockFace.SOUTH_WEST);
                Block block6 = block.getRelative(BlockFace.SOUTH_EAST);
                Block block7 = block.getRelative(BlockFace.NORTH_WEST);
                Block block8 = block.getRelative(BlockFace.NORTH_EAST);
                if(block1.getType().equals(Material.STONE)){
                    block1.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block2.getType().equals(Material.STONE)) {
                    block2.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block3.getType().equals(Material.STONE)) {
                    block3.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block4.getType().equals(Material.STONE)) {
                    block4.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block5.getType().equals(Material.STONE)) {
                    block5.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block6.getType().equals(Material.STONE)) {
                    block6.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block7.getType().equals(Material.STONE)) {
                    block7.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block8.getType().equals(Material.STONE)) {
                    block8.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
            }
            if(blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)){
                Block block1 = block.getRelative(BlockFace.UP);
                Block block2 = block.getRelative(BlockFace.DOWN);
                Block block3 = block.getRelative(BlockFace.NORTH);
                Block block4 = block.getRelative(BlockFace.SOUTH);
                Block block5 = block1.getRelative(BlockFace.NORTH);
                Block block6 = block1.getRelative(BlockFace.SOUTH);
                Block block7 = block2.getRelative(BlockFace.NORTH);
                Block block8 = block2.getRelative(BlockFace.SOUTH);
                if(block1.getType().equals(Material.STONE)){
                    block1.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block2.getType().equals(Material.STONE)) {
                    block2.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block3.getType().equals(Material.STONE)) {
                    block3.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block4.getType().equals(Material.STONE)) {
                    block4.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block5.getType().equals(Material.STONE)) {
                    block5.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block6.getType().equals(Material.STONE)) {
                    block6.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block7.getType().equals(Material.STONE)) {
                    block7.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block8.getType().equals(Material.STONE)) {
                    block8.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
            }
            if(blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)){
                Block block1 = block.getRelative(BlockFace.UP);
                Block block2 = block.getRelative(BlockFace.DOWN);
                Block block3 = block.getRelative(BlockFace.EAST);
                Block block4 = block.getRelative(BlockFace.WEST);
                Block block5 = block1.getRelative(BlockFace.EAST);
                Block block6 = block1.getRelative(BlockFace.WEST);
                Block block7 = block2.getRelative(BlockFace.EAST);
                Block block8 = block2.getRelative(BlockFace.WEST);
                if(block1.getType().equals(Material.STONE)){
                    block1.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block1.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block2.getType().equals(Material.STONE)) {
                    block2.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block2.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block3.getType().equals(Material.STONE)) {
                    block3.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block3.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block4.getType().equals(Material.STONE)) {
                    block4.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block4.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block5.getType().equals(Material.STONE)) {
                    block5.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block5.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block6.getType().equals(Material.STONE)) {
                    block6.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block6.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block7.getType().equals(Material.STONE)) {
                    block7.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block7.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
                if (block8.getType().equals(Material.STONE)) {
                    block8.setType(Material.AIR);
                    if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.STONE));
                    }
                    else{
                        block.getWorld().dropItemNaturally(block8.getLocation(), new ItemStack(Material.COBBLESTONE));
                    }
                }
            }
        }
    }
}
