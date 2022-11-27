package fr.almo.xrayalert.manager;

import org.bukkit.ChatColor;

public enum Messages {

    PLAYER_HAS_NOT_PERMISSION(ChatColor.RED + "Cette commande est resérvée à l'équipe de modération."),
    PLAYER_CAN_NOT_TELEPORT_TO_HIMSELF(ChatColor.RED + "Vous ne pouvez pas vous téléporter à vous-même !"),
    PLAYER_NEED_TO_SPECIFY_A_SUSPECT(ChatColor.RED + "Erreur: " + ChatColor.WHITE + "Vous devez specifier un suspect."),
    WRONG_USAGE(ChatColor.RED + "Erreur: " + ChatColor.WHITE + "/xateleport <pseudo>" );

    private final String message;

    Messages (String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}