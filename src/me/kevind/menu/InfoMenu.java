package me.kevind.menu;

import me.kevind.utils.ItemList;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InfoMenu {
    private final Inventory inv;

    public InfoMenu() {
        inv = Bukkit.createInventory(null, 9, "Suggestive Content Warning");
        inv.setItem(4, ItemList.INFO);
        inv.setItem(0, ItemList.DENY);
        inv.setItem(8, ItemList.ACCEPT);
    }

    public Inventory getInv() {
        return inv;
    }

}
