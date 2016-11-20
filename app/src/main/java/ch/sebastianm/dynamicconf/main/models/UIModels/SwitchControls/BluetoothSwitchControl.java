package ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;

import java.util.HashSet;
import java.util.Set;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.listeners.AirplaneModeChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.BlueToothChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.BroadcastListener;
import ch.sebastianm.dynamicconf.main.listeners.RingModeChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.WifiChangeListener;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class BluetoothSwitchControl extends SwitchControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.BLUETOOTHSWTID;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_switch_bluetooth);
    }
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    @Override
    public void setBusinessLogic(Boolean bool, Context con) {
        if (mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.disable();
        }
        else
            mBluetoothAdapter.enable();
    }

    @Override
    public Boolean getState(Context con) {
        return mBluetoothAdapter.isEnabled();
    }

    @Override
    public Set<BroadcastListener> getListeners(Context con){
        Set<BroadcastListener> bcl =  new HashSet<BroadcastListener>();
        bcl.add(new BlueToothChangeListener());
        bcl.add(new AirplaneModeChangeListener());
        return bcl;
    }

}
