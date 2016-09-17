package ch.sebastianm.dynamicconf.main.controllers;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.activities.Widget_Settings;
import ch.sebastianm.dynamicconf.main.constants.ContentClasses;
import ch.sebastianm.dynamicconf.main.constants.SuperClasses;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

/**
 * Created by Sebastian on 16.09.2016.
 */
public class WidgetSettingsController {

    public void MainPageController(Widget_Settings view) {
        this.view = view;
    }

    public Widget_Settings view;
    public SuperClasses superClasses = SuperClasses.getInstance();

    ContentClasses contentClasses = ContentClasses.getInstance();

    public List<ControlParent> getUIElementsByType(ControlParent controllparent) {
        return filter(contentClasses.getModelList(), controllparent);
    }

    public static List<ControlParent> filter(List<ControlParent> resourceList, ControlParent typeCheck) {
        List<ControlParent> result = new ArrayList<ControlParent>();
        for (ControlParent element: resourceList) {
            if (element.getGroup().equals(typeCheck.getGroup())) {
                result.add(element);
            }
        }
        return result;
    }
    public List<ControlParent> getSuperclasses() {
        return superClasses.getModelList();
    }



}
