package ch.sebastianm.dynamicconf.main.models.ButtonControls;

import android.content.Intent;
import android.provider.Settings;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class GPSButtonControl extends ButtonControl {

    @Override
    public String getTitel()
    { return "GPS Settings";}

    @Override
    public Intent getIntent() {
       return new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS);
    }
}
