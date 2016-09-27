package ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class GPSButtonControl extends ButtonControl {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.GPSBTNID;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_buttons_gps);
    }

    @Override
    public Intent getIntent() {
       return new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    }
}
