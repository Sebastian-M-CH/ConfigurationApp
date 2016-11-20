package ch.sebastianm.dynamicconf.main.listeners;

import android.bluetooth.BluetoothAdapter;
import android.net.ConnectivityManager;

/**
 * Created by Sebastian on 04.11.2016.
 */
public class NetworkOperatorChangedListener extends BroadcastListener {

    @Override
    public String getIntentFilterValue()
    { return ConnectivityManager.CONNECTIVITY_ACTION;}

}
