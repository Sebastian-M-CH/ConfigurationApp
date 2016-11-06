package ch.sebastianm.dynamicconf.main.listeners;

import android.media.AudioManager;
import android.net.wifi.WifiManager;

/**
 * Created by Sebastian on 04.11.2016.
 */
public class WifiChangeListener extends BroadcastListener {

    @Override
    public String getIntentFilterValue()
    { return WifiManager.WIFI_STATE_CHANGED_ACTION;}

}
