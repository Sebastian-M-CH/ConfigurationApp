package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.content.Context;
import android.os.StatFs;

import java.io.File;
import java.util.TimeZone;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class FreeStorageTextView extends TextControls {

    DynamicConfConstantes constantes = new DynamicConfConstantes();

    @Override
    public String getId(){
        return constantes.FREESTORAGETEXV;
    }

    @Override
    public String getTitel(Context con) {
        return con.getResources().getString(R.string.title_textView_free_storage);
    }

    @Override
    public String getContentText(Context con){
        File internalStorageFile= con.getFilesDir();
        long availableSizeInBytes=new StatFs(internalStorageFile.getPath()).getAvailableBytes();
        String formattedResult=android.text.format.Formatter.formatFileSize(con,availableSizeInBytes);
        return formattedResult;

    }

}