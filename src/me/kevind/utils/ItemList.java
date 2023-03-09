package me.kevind.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemList {
    public static final ItemStack INFO = new ItemMaker(Material.BOOK).name("Suggestive content warning!").lore("Click me to go to website!").build();
    public static final ItemStack ACCEPT = new ItemMaker(Material.GREEN_WOOL).name("&aAccept!").build();
    public static final ItemStack DENY = new ItemMaker(Material.RED_WOOL).name("&cDeny").build();
}
