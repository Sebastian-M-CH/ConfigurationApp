package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.StatFs;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class CurrentTimeZoneTextView extends TextControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.CURRENTZIMEZONETEXID;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_textView_current_time_zone);
    }

    @Override
    public String getContentText(Context con){

        Calendar mCalendar = new GregorianCalendar();
        TimeZone mTimeZone = mCalendar.getTimeZone();
        int mGMTOffset = mTimeZone.getRawOffset();
        String text = mGMTOffset >= 0  ? "+":"";
        return cutResult("GMT"+text+TimeUnit.HOURS.convert(mGMTOffset, TimeUnit.MILLISECONDS)+":00");
    }

}
