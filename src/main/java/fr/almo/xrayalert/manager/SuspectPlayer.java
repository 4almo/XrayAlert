package fr.almo.xrayalert.manager;

import fr.almo.xrayalert.listeners.MiningListener;
import org.bukkit.Location;

public class SuspectPlayer {

    private static String mSuspect;
    private static Location mLocation;
    private static int mBlocksMined;

    MiningListener ml = new MiningListener();

    public SuspectPlayer(){
        this.mSuspect = ml.getSuspect();
        this.mLocation = ml.getLocation();
        this.mBlocksMined = ml.getBlocksMined();
    }

    public String getSuspect(){
        return this.mSuspect;
    }

    public Location getLocation(){
        return mLocation;
    }

    public int getBlocksMined(){
        return mBlocksMined;
    }


}
