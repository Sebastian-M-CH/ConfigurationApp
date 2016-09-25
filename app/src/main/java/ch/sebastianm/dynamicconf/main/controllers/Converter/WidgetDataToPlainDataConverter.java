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
    public List<String> objectToData(final List<WidgetData> widgets) {
        Collections.sort(widgets, new Comparator<WidgetData>() {
            public int compare(WidgetData w1, WidgetData w2) {
                if(w1.getX() >w2.getX())
                    return 1;
                else if(w1.getX() < w2.getX())
                    return 0;
                else{
                    if(w1.getY() >w2.getY())
                        return 1;
                    else if(w1.getY() < w2.getY())
                        return 0;
                    else
                        return 1;

                }
            }
        });
        List<String> result = new ArrayList<String>();
        int last=0;
        String resultLine="";
        for (WidgetData wid:widgets ) {
            if(last!= wid.getX())
            {
                result.add(resultLine);
                resultLine = "";
            }
            if(resultLine != "")
                resultLine = resultLine + ";";
            resultLine = resultLine + wid.getControlID();
        }
        return result;
    }


    public List<WidgetData> getWidgetFromData(List<String> data)
    {
        int x = 0;
        List<WidgetData> widgets = new ArrayList<WidgetData>();
        for (String line: data) {
            int y = 0;
            String[] spli = line.split(";");
            for (String element:spli ) {
                widgets.add(new WidgetData(element, x, y));
                y++;
            }
            x++;
        }
        return widgets;

    }
}
