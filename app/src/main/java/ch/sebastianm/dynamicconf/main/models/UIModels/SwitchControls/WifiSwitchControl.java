package ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.provider.Settings;

import java.util.HashSet;
import java.util.Set;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.listeners.BroadcastListener;
import ch.sebastianm.dynamicconf.main.listeners.RingModeChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.WifiChangeListener;
import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.ButtonControl;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class WifiSwitchControl extends SwitchControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.WIFISWTID;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_switch_wifi);
    }


    @Override
    public void setBusinessLogic(Boolean bool, Context con) {
        WifiManager wifiManager = (WifiManager) con.getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(bool);
    }

    @Override
    public Boolean getState(Context con) {
        WifiManager wifiManager = (WifiManager) con.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isWifiEnabled();
    }

    @Override
    public Set<BroadcastListener> getListeners(Context con){
        Set<BroadcastListener> bcl =  new HashSet<BroadcastListener>();
        bcl.add(new WifiChangeListener());
        return bcl;
    }

}
