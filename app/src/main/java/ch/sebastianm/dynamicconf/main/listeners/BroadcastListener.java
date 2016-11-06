package ch.sebastianm.dynamicconf.main.listeners;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.activities.MainPageParent;
import ch.sebastianm.dynamicconf.main.activities.Main_Overview;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.UpdataClass;

/**
 * Created by Sebastian on 04.11.2016.
 */
public class BroadcastListener {
    public BroadcastReceiver getReceiver(final MainPageParent activity) {
        return new BroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                updateViews(context);
            }
        };}

    public List<UpdataClass> addedViews = new ArrayList<UpdataClass>();

    public void updateViews(Context con)
    {}

    public String getIntentFilterValue()
    { return null;}

    public IntentFilter getIntentfilter() {
        return new IntentFilter(getIntentFilterValue());
    }
}
