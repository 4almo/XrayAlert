package fr.almo.xrayalert.commands;

import fr.almo.xrayalert.listeners.MiningListener;
import fr.almo.xrayalert.manager.Messages;
import fr.almo.xrayalert.manager.SuspectPlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {

    SuspectPlayer sp = new SuspectPlayer();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(sender instanceof Player){

            if(p.hasPermission("xa.teleport")){

                if(args.length == 0){
                    p.sendMessage(Messages.PLAYER_NEED_TO_SPECIFY_A_SUSPECT.getMessage());
                } else if(args.length == 1){
                    if(args[0].equalsIgnoreCase(sp.getSuspect())){

                        if(p.getName() != sp.getSuspect()){
                            p.sendMessage(ChatColor.ITALIC + "Vous avez été téléporté à " + ChatColor.RESET + "" + ChatColor.RED + args[0] + ChatColor.WHITE + ".");
                            p.teleport(sp.getLocation());
                        } else {
                            p.sendMessage(Messages.PLAYER_CAN_NOT_TELEPORT_TO_HIMSELF.getMessage());
                        }
                    }
                } else if(args.length > 1){
                    p.sendMessage(Messages.WRONG_USAGE.getMessage());
                }



            } else {
                p.sendMessage(Messages.PLAYER_HAS_NOT_PERMISSION.getMessage());
            }

        } else {
            System.out.println("Player's command !");
        }

        return true;
    }
}
