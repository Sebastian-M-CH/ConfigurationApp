package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.content.Context;
import android.os.Build;

import java.text.SimpleDateFormat;
import java.util.Date;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class CurrentDateTextView extends TextControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.CURRENTDATETEXV;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_textView_current_date);
    }

    @Override
    public String getContentText(Context con){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return cutResult(sdf.format(new Date()));
    }

}
