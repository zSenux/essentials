package de.senux.essentials.command;

import de.senux.essentials.Essentials;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    private final String prefix = Essentials.getInstance().getPrefix();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {

            Player player = (Player)commandSender;
            if (!player.hasPermission("essentials.command.gamemode")) {
                player.sendMessage(prefix + "§cDu hast keine Rechte für diesen Befehl!");
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("0")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(prefix + "Du bist nun im Gamemode Survival");
                }
                if (args[0].equalsIgnoreCase("1")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(prefix + "Du bist nun im Gamemode Creative");
                }
                if (args[0].equalsIgnoreCase("2")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(prefix + "Du bist nun im Gamemode Adventure");
                }
                if (args[0].equalsIgnoreCase("3")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(prefix + "Du bist nun im Gamemode Spectator");
                }




            } else {
                player.sendMessage(prefix + "/" + command);
            }

        }
        return false;
    }
}
