package me.kevind.commands;

import me.kevind.IntegralPrompt;
import me.kevind.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PromptReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player player) {
            if (player.hasPermission("integral.admin")) {
                IntegralPrompt.getInstance().reloadConfig();
                MessageUtils.sendMessage(player, "&aSuccessfully reloaded the config!");
            } else {
                MessageUtils.sendMessage(player, "&cYou do not have permission to use this command.");
            }
        }
        return false;
    }
}
