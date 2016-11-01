package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class BlueToothTextView extends TextControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.BLUETEXVID;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_textView_bluetooth_name);
    }

    @Override
    public String getContentText(Context con){
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        String result = mBluetoothAdapter.getName();
        return cutResult(result);
    }

}
