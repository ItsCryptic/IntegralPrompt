package me.kevind.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.kevind.IntegralPrompt;
import me.kevind.utils.ColorUtils;
import me.kevind.utils.ItemList;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player player) {
            if (e.getClickedInventory() == null) {
                return;
            }
            if (e.getCurrentItem() == null) {
                e.setCancelled(true);
                return;
            }
            if (e.getClickedInventory().equals(IntegralPrompt.getInfomenu().getInv())) {
                ByteArrayDataOutput out = ByteStreams.newDataOutput();
                out.writeUTF("Connect");
                if (e.getCurrentItem().isSimilar(ItemList.ACCEPT)) {
                    out.writeUTF(Objects.requireNonNull(IntegralPrompt.getInstance().getConfig().getString("server")));
                    player.closeInventory();
                }
                if (e.getCurrentItem().isSimilar(ItemList.DENY)) {
                    player.kickPlayer(ColorUtils.color("&cYou must accept this warning in order to continue."));
                }
                if (e.getCurrentItem().isSimilar(ItemList.INFO)) {
                    TextComponent message = new TextComponent("Click here to open the link!");
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, IntegralPrompt.getInstance().getConfig().getString("infolink")));
                    player.spigot().sendMessage(message);

                }
                e.setCancelled(true);
                player.sendPluginMessage(IntegralPrompt.getInstance(), "BungeeCord", out.toByteArray());
            }
        }
    }
}
