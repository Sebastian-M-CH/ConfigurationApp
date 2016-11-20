package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.util.HashSet;
import java.util.Set;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.listeners.AirplaneModeChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.BroadcastListener;
import ch.sebastianm.dynamicconf.main.listeners.RingModeChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.WifiChangeListener;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.SwitchControls;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class WifiNameTextView extends TextControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.WIFITEXVID;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_textView_wifi_name);
    }

    @Override
    public String getContentText(Context con){
        WifiManager wifiMgr = (WifiManager) con.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
        String result = wifiInfo.getSSID().substring(1,wifiInfo.getSSID().length()-1);
        return cutResult(result);
    }

    @Override
    public Set<BroadcastListener> getListeners(Context con){
        Set<BroadcastListener> bcl =  new HashSet<BroadcastListener>();
        bcl.add(new WifiChangeListener());
        bcl.add(new AirplaneModeChangeListener());
        return bcl;
    }
}
