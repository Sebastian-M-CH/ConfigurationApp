package ch.sebastianm.dynamicconf.main.listeners;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;

import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.UpdataClass;

/**
 * Created by Sebastian on 04.11.2016.
 */
public class RingModeChangeListener extends BroadcastListener {

    @Override
    public void updateViews(Context con){
        for (UpdataClass upClass: addedViews) {
            upClass.update(con);
        }
    }

    @Override
    public String getIntentFilterValue()
    { return AudioManager.RINGER_MODE_CHANGED_ACTION;}

    @Override
    public boolean equals(Object o) {
        return this.getClass().equals(o.getClass());
    }

    @Override
    public int hashCode() {
        return 31 * 17 + this.getClass().hashCode();
    }
}
