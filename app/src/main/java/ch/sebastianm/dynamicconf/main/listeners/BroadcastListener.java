package ch.sebastianm.dynamicconf.main.listeners;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.activities.MainPageParent;
import ch.sebastianm.dynamicconf.main.activities.Main_Overview;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.UpdataClass;

/**
 * Created by Sebastian on 04.11.2016.
 */
public class BroadcastListener {
    private BroadcastReceiver broadcastReceiver;

    public BroadcastReceiver getReceiver(final MainPageParent activity) {
        if(broadcastReceiver == null)
        broadcastReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                updateViews(context);
            }
        };
    return broadcastReceiver;
    }

    public List<UpdataClass> addedViews = new ArrayList<UpdataClass>();

    public void updateViews(Context con){
        for (UpdataClass upClass: addedViews) {
            upClass.update(con);
        }
    }

    public String getIntentFilterValue()
    { return null;}

    public IntentFilter getIntentfilter() {
        return new IntentFilter(getIntentFilterValue());
    }

    public boolean equals(Object o) {
        return this.getClass().equals(o.getClass());
    }

    public int hashCode() {
        return 31 * 17 + this.getClass().hashCode();
    }

}
