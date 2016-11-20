package ch.sebastianm.dynamicconf.main.listeners;

import android.content.Intent;
import android.location.LocationManager;

/**
 * Created by Sebastian on 04.11.2016.
 */
public class AirplaneModeChangeListener extends BroadcastListener {

    @Override
    public String getIntentFilterValue()
    { return Intent.ACTION_AIRPLANE_MODE_CHANGED;}

}
