package ch.sebastianm.dynamicconf.main.controllers.repository;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.constants.Settings;
import ch.sebastianm.dynamicconf.main.controllers.Converter.WidgetDataToPlainDataConverter;
import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class FileRepository {

    private static FileRepository _instance;

    String resourceString;
    WidgetDataToPlainDataConverter converter = new WidgetDataToPlainDataConverter();

    Settings settingsConstant = new Settings();

    SharedPreferences dynamicConfPref;
    SharedPreferences.Editor dynamicConfEditor;

    public synchronized static FileRepository getInstance(Context con)
    {
        if (_instance == null)
        {
            _instance = new FileRepository(con);
        }
        return _instance;
    }

    private FileRepository(Context con) {
        dynamicConfPref = con.getSharedPreferences("DynamciConf", Context.MODE_PRIVATE);
        dynamicConfEditor  = dynamicConfPref.edit();
        resourceString = dynamicConfPref.getString(settingsConstant.DATA, "");
    }

    public void save(List<WidgetData> objects) {
        String toSave = getPlainData(objects);
        dynamicConfEditor.putString(settingsConstant.DATA, toSave);
        dynamicConfEditor.commit();
    }

    public List<WidgetData> getWidgetData() {
        List<String> widgetDataList = new ArrayList<String>();
        for (String value:resourceString.split("|")) {
            widgetDataList.add(value);
        }
        return converter.getWidgetFromData(widgetDataList);
    }
    public String getPlainData(List<WidgetData> objects) {
        String result = "";
        for (String row: converter.objectToData(objects)) {
            if(result.equals(""))
                result = row;
            else
                result = result + "|" + row;
        }
        return result;
    }

}
