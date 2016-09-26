package ch.sebastianm.dynamicconf.main.controllers.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;

/**
 * Created by Sebastian on 21.09.2016.
 */
public class WidgetDataToPlainDataConverter {
    public String objectToData(final List<WidgetData> widgets) {
        String result = "";
        for (WidgetData wid:widgets ) {
            if(result != "")
                result = result + "|";
            result = result + wid.getControlID() + ";" + wid.getX() + ";" + wid.getY();
        }
        return result;
    }


    public List<WidgetData> getWidgetFromData(List<String> data) {
        List<WidgetData> widgets = new ArrayList<WidgetData>();
        for (String line: data) {
                String[] splitted = line.split(";");
            if(splitted.length != 3)
                continue;
            widgets.add(new WidgetData(splitted[0], Integer.valueOf(splitted[1]), Integer.valueOf(splitted[2])));
        }
        return widgets;

    }
}
