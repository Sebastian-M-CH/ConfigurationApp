package ch.sebastianm.dynamicconf.main.controllers.Converter;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.constants.ContentClasses;
import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
import ch.sebastianm.dynamicconf.main.models.UIModels.WidgetUI;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class WidgetDataToWidgetUI {

    public WidgetUI map(WidgetData widgetData) {
        return new WidgetUI(matchIdToControl(widgetData.getControlID()), widgetData.getX(), widgetData.getY());
    }
    public List<WidgetUI> map(List<WidgetData> widgetDataList) {
        List<WidgetUI> widgetUIList = new ArrayList<WidgetUI>();
        for (WidgetData widgetData: widgetDataList ) {
            widgetUIList.add(map(widgetData));
        }
        return widgetUIList;
    }

    ContentClasses base = ContentClasses.getInstance();

    public ControlParent matchIdToControl(String id) {
        for (ControlParent model: base.getModelList() ) {
            if(model.getId().equals(id))
                return model;
        }
        return null;
    }

}
