package me.syntaxerror.customitemsgit;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemManager {

    public static ItemStack GrapplingHook;
    public static ItemStack TeleportSword;
    public static ItemStack TheGiftingFish;
    public static ItemStack ExplosiveBow;
    public static ItemStack InfiniteWaterBucket;
    public static ItemStack InfiniteLavaBucket;
    public static ItemStack MachineGunBow;
    public static ItemStack MultibreakPickaxe;
    public static ItemStack MidasPickaxe;
    public static ItemStack Boomerang;
    public static ItemStack HomingBow;
    public static ItemStack RocketLauncher;
    public static ItemStack ThrowingAxe;
    public static ItemStack UndeadSword;
    public static ItemStack ThrowableTNT;
    public static ItemStack LightningAxe;

    public static void init() {
        createGrapplingHook();
        createTeleportSword();
        createTheGiftingFish();
        createExplosiveBow();
        createInfiniteWaterBucket();
        createInfiniteLavaBucket();
        createMachineGunBow();
        createMultibreakPickaxe();
        createMidasPickaxe();
        createBoomerang();
        createHomingBow();
        createRocketLauncher();
        createThrowingAxe();
        createUndeadSword();
        createThrowableTNT();
        createLightningAxe();
    }

    private static void createGrapplingHook() {
        ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Grappling Hook");
        List<String> lore = new ArrayList();
        lore.add("§9RARE");
        lore.add("§7Travel in style with this tool...");
        lore.add("Item has a 5 second cooldown.");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        GrapplingHook = item;
    }
    private static void createTeleportSword(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Teleport Sword");
        List<String> lore = new ArrayList();
        lore.add("§5EPIC");
        lore.add("§7This sword has teleport powers.");
        lore.add("§6Item Ability (Right Click):");
        lore.add("§fTeleport 8 blocks ahead");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage",
                25.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed",
                0.05, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
        item.setItemMeta(meta);
        TeleportSword = item;
    }
    private static void createTheGiftingFish(){
        ItemStack item = new ItemStack(Material.PUFFERFISH, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cThe Gifting Fish");
        List<String> lore = new ArrayList<>();
        lore.add("§cSPECIAL");
        lore.add("§7Right click for an item!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        TheGiftingFish = item;
    }
    private static void createExplosiveBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Explosive Bow");
        List<String> lore = new ArrayList<>();
        lore.add("§5EPIC");
        lore.add("§7Creates an explosive...");
        meta.setLore(lore);
        item.setItemMeta(meta);
        ExplosiveBow = item;
    }
    private static void createInfiniteWaterBucket(){
        ItemStack item = new ItemStack(Material.WATER_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Infinite Water Bucket");
        List<String> lore = new ArrayList<>();
        lore.add("§5EPIC");
        lore.add("§7Infinite flow of water...");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        InfiniteWaterBucket = item;
    }
    private static void createInfiniteLavaBucket(){
        ItemStack item = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Infinite Lava Bucket");
        List<String> lore = new ArrayList<>();
        lore.add("§5EPIC");
        lore.add("§7Infinite flow of lava...");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 3, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        InfiniteLavaBucket = item;
    }
    private static void createMachineGunBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Machine Gun Bow");
        List<String> lore = new ArrayList<>();
        lore.add("§9RARE");
        lore.add("§6Left Click:");
        lore.add("§7Shoots 5 arrows a second for 5 seconds");
        meta.setLore(lore);
        item.setItemMeta(meta);
        MachineGunBow = item;
    }
    private static void createMultibreakPickaxe(){
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Multibreak Pickaxe");
        List<String> lore = new ArrayList<>();
        lore.add("§6LEGENDARY");
        lore.add("§6Multibreak:");
        lore.add("§7Breaks stone in a 3x3 area");
        meta.setLore(lore);
        item.setItemMeta(meta);
        MultibreakPickaxe = item;
    }
    private static void createMidasPickaxe(){
        ItemStack item = new ItemStack(Material.GOLDEN_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Midas Pickaxe");
        List<String> lore = new ArrayList<>();
        lore.add("§6LEGENDARY");
        lore.add("§6Golden Touch:");
        lore.add("§7Every drop will turn to gold.");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        MidasPickaxe = item;
    }
    private static void createBoomerang(){
        ItemStack item = new ItemStack(Material.BONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Boomerang");
        List<String> lore = new ArrayList<>();
        lore.add("§6LEGENDARY");
        lore.add("§6Boomerang Powers:");
        lore.add("§7Shoots out a boomerang");
        lore.add("§7that deals damage.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Boomerang = item;
    }
    private static void createHomingBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Homing Bow");
        List<String> lore = new ArrayList<>();
        lore.add("§6LEGENDARY");
        lore.add("§6Homing Arrows:");
        lore.add("§7All arrows shot from this bow");
        lore.add("§7will turn to the target within 5 blocks.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        HomingBow = item;
    }
    private static void createRocketLauncher(){
        ItemStack item = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Rocket Launcher");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+70");
        lore.add("");
        lore.add("§6Item Ability: Ricochet Rocket §eRIGHT CLICK");
        lore.add("§7Fires a rocket that explodes for");
        lore.add("§c0 §7damage and when ricocheting");
        lore.add("§7off the ground creates explosions for");
        lore.add("§7half the damage.");
        lore.add("");
        meta.setLore(lore);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 70.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        RocketLauncher = item;
    }
    private static void createThrowingAxe(){
        ItemStack item = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Throwing Axe");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+70");
        lore.add("");
        lore.add("§6Item Ability: Throw §eRIGHT CLICK");
        lore.add("§7Throw your axe and deal");
        lore.add("§c1,000 §7damage.");
        meta.setLore(lore);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 70.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(meta);
        ThrowingAxe = item;
    }
    private static void createUndeadSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Undead Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+70");
        lore.add("");
        lore.add("§6Item Ability: Damage Multiplier");
        lore.add("§7Damage dealt to some mobs will be multiplied.");
        lore.add("§7Zombies: ");
        lore.add("§7Skeletons: ");
        lore.add("");
        meta.setLore(lore);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 70.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        UndeadSword = item;
    }
    private static void createThrowableTNT(){
        ItemStack item = new ItemStack(Material.TNT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Throwable TNT");
        List<String> lore = new ArrayList<>();
        lore.add("§6Item Ability: Throwable TNT");
        lore.add("§7Throws TNT......");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        ThrowableTNT = item;
    }
    private static void createLightningAxe(){
        ItemStack item = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Lightning Axe");
        List<String> lore = new ArrayList<>();
        lore.add("§7Strike your opponent with");
        lore.add("§7lightning everytime you hit them,");
        lore.add("§7dealing §c1000 §7damage.");
        lore.add("");
        lore.add("§6Item Ability: Stormbreaker");
        lore.add("§7When right clicked, strike all");
        lore.add("§7mobs around you in a 12 block radius");
        lore.add("§7dealing §c1000 §7damage.");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        LightningAxe = item;
    }
}
