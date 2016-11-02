package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class AndroidVersionTextView extends TextControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.ANDROIDVERSIONTEXV;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_textView_android_version);
    }

    @Override
    public String getContentText(Context con){
        return cutResult(Build.VERSION.RELEASE);
    }

}
