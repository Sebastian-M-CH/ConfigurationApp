package ch.sebastianm.dynamicconf.main.listeners;

import android.location.LocationManager;
import android.net.wifi.WifiManager;

/**
 * Created by Sebastian on 04.11.2016.
 */
public class GpsChangeListener extends BroadcastListener {

    @Override
    public String getIntentFilterValue()
    { return LocationManager.PROVIDERS_CHANGED_ACTION;}

}
