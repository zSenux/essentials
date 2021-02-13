package de.senux.essentials.command;

import de.senux.essentials.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    private final String prefix = Essentials.getInstance().getPrefix();


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;

        if (args.length == 0) {
            player.setHealth(20.0D);
            player.sendMessage(prefix + "§aDu wurdest geheilt.");
        } else if (args.length == 1) {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer(playerName);


            if (!player.hasPermission("essentials.command.heal")) {
                player.sendMessage(prefix + "§cDu hast keine Rechte für diesen Befehl!");
                return false;
            }

            if (targetPlayer != null) {
                targetPlayer.setHealth(20.0D);
                player.sendMessage(prefix + "§aDer Spieler " + targetPlayer.getName() + " §awurde geheilt.");
            }
        }

        return false;
    }

}
