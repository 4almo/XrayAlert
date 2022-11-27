package fr.almo.xrayalert.listeners;

import fr.almo.xrayalert.manager.SuspectPlayer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MiningListener implements Listener {

    private static String mSuspect;
    private static Location mLocation;
    private static int mBlocksMined;

    @EventHandler
    public void onMining(BlockBreakEvent e){

        String suspect = e.getPlayer().getName();
        this.mSuspect = suspect;

        Location location = e.getPlayer().getLocation();
        this.mLocation = location;

        int blocksMined = 0;
        this.mBlocksMined = blocksMined;

        SuspectPlayer sp = new SuspectPlayer();

        if(e.getBlock().getType() == Material.DIAMOND_ORE){
            blocksMined ++;

            if(blocksMined == 5){

            }

                for (Player online : Bukkit.getOnlinePlayers()) {
                    TextComponent teleportButton = new TextComponent("[" + ChatColor.BOLD + "TELEPORTATION" + ChatColor.RESET + "]");
                    teleportButton.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Cliquez-ici pour vous téléporter à ce joueur.").create()));
                    teleportButton.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/xateleport " + suspect));

                    TextComponent altTeleportButton = new TextComponent(ChatColor.RED + suspect +" vient de miner un diamant. ");
                    online.spigot().sendMessage(altTeleportButton, teleportButton);
                }

        }

    }

    public String getSuspect(){
        return this.mSuspect;
    }

    public Location getLocation(){
        return this.mLocation;
    }

    public int getBlocksMined(){
        return this.mBlocksMined;
    }

}
