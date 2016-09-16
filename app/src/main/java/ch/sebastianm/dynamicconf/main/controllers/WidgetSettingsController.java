package ch.sebastianm.dynamicconf.main.controllers;

import java.util.List;

import ch.sebastianm.dynamicconf.main.activities.Widget_Settings;
import ch.sebastianm.dynamicconf.main.controllers.Converter.ModelBase;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
import ch.sebastianm.dynamicconf.main.models.UIModels.WidgetUI;

/**
 * Created by Sebastian on 16.09.2016.
 */
public class WidgetSettingsController {

    public void MainPageController(Widget_Settings view) {
        this.view = view;
    }

    public Widget_Settings view;

    ModelBase modelBase = ModelBase.getInstance();

    public List<ControlParent> getUIElements() {
        return modelBase.getModelList();
    }

}
