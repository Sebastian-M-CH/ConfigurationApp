package ch.sebastianm.dynamicconf.main.controllers.repository;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.controllers.Converter.WidgetDataToPlainDataConverter;
import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;
import ch.sebastianm.dynamicconf.main.models.Widget;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class FileRepository {

    private static FileRepository _instance;

    String resourceString;
    WidgetDataToPlainDataConverter converter = new WidgetDataToPlainDataConverter();

    DynamicConfConstantes settingsConstant = new DynamicConfConstantes();

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
    Context con;

    private FileRepository(Context con) {
        dynamicConfPref = con.getSharedPreferences("DynamciConf", Context.MODE_PRIVATE);
        dynamicConfEditor  = dynamicConfPref.edit();
        this.con = con;
    }

    public void save(List<WidgetData> objects) {
        String toSave = getPlainData(objects);
        dynamicConfEditor.putString(settingsConstant.DATA, toSave);
        dynamicConfEditor.commit();
    }

    public void reduceWidgetListTo(int lastWidgetHeight){
        List<WidgetData> newList = new ArrayList<WidgetData>();
        for (WidgetData widgetData:getWidgetData()) {
            if(widgetData.getX() < lastWidgetHeight)
                newList.add(widgetData);
        }
        save(newList);
    }

    public List<WidgetData> getWidgetData() {
        resourceString = dynamicConfPref.getString(settingsConstant.DATA, "");
        List<String> widgetDataList = new ArrayList<String>();
        if(resourceString.contains("|")) {
            for (String value : resourceString.split("\\|")) {
                if (value != "")
                    widgetDataList.add(value);
            }
        }
        else if(!resourceString.equals("") && !resourceString.contains("|"))
            widgetDataList.add(resourceString);

        return converter.getWidgetFromData(widgetDataList);
    }
    public String getPlainData(List<WidgetData> objects) {
        return converter.objectToData(objects);
    }

}
