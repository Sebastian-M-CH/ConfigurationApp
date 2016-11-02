package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class GPSStateTextView extends TextControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.GPSSTATETEXV;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_textView_gps_state);
    }

    @Override
    public String getContentText(Context con){
        String result = con.getResources().getString(R.string.title_textView_gps_state_text);
        final LocationManager manager = (LocationManager)con.getSystemService(Context.LOCATION_SERVICE);

        if (manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            result = result + " " + con.getResources().getString(R.string.activ);
        }
        else
        {
            result = result + " " +con.getResources().getString(R.string.inactiv);
        }
        return result;
    }

}
