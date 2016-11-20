package ch.sebastianm.dynamicconf.main.listeners;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;

/**
 * Created by Sebastian on 04.11.2016.
 */
public class BlueToothChangeListener extends BroadcastListener {

    @Override
    public String getIntentFilterValue()
    { return BluetoothAdapter.ACTION_STATE_CHANGED;}

}
