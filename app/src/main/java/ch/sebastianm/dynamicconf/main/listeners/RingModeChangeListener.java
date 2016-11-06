package ch.sebastianm.dynamicconf.main.listeners;

import android.media.AudioManager;

/**
 * Created by Sebastian on 04.11.2016.
 */
public class RingModeChangeListener extends BroadcastListener {

    @Override
    public String getIntentFilterValue()
    { return AudioManager.RINGER_MODE_CHANGED_ACTION;}

}
