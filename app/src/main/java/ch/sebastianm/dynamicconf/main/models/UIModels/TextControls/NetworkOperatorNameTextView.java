package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.content.Context;
import android.telephony.TelephonyManager;

import java.util.HashSet;
import java.util.Set;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.listeners.AirplaneModeChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.BroadcastListener;
import ch.sebastianm.dynamicconf.main.listeners.GpsChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.NetworkOperatorChangedListener;
import ch.sebastianm.dynamicconf.main.listeners.RingModeChangeListener;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class NetworkOperatorNameTextView extends TextControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.NETWORKOPERATORTEXTV;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_textView_network_operator);
    }

    @Override
    public String getContentText(Context con){
        TelephonyManager tm = (TelephonyManager)con.getSystemService(Context.TELEPHONY_SERVICE);
        String result = tm.getNetworkOperatorName();
        return cutResult(result);
    }

    @Override
    public Set<BroadcastListener> getListeners(Context con){
        Set<BroadcastListener> bcl =  new HashSet<BroadcastListener>();
        bcl.add(new NetworkOperatorChangedListener());
        bcl.add(new AirplaneModeChangeListener());
        return bcl;
    }
}
