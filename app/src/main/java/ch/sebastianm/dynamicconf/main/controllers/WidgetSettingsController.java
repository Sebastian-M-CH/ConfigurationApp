package ch.sebastianm.dynamicconf.main.controllers;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ch.sebastianm.dynamicconf.main.activities.Widget_Settings;
import ch.sebastianm.dynamicconf.main.constants.ContentClasses;
import ch.sebastianm.dynamicconf.main.constants.SuperClasses;
import ch.sebastianm.dynamicconf.main.controllers.repository.FileRepository;
import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
import ch.sebastianm.dynamicconf.main.models.Widget;

/**
 * Created by Sebastian on 16.09.2016.
 */
public class WidgetSettingsController {

    public WidgetSettingsController(Widget_Settings view, int x, int y) {
        this.x = x;
        this.y = y;
        this.view = view;
        init();
    }

    public FileRepository repo;

    private void init(){
        repo = FileRepository.getInstance(view.getApplicationContext());
        widgetList = repo.getWidgetData();
    }

    public List<WidgetData> widgetList;
    private int x;
    private int y;

    public Widget_Settings view;

    SuperClasses superClasses = SuperClasses.getInstance();

    ContentClasses contentClasses = ContentClasses.getInstance();

    public List<ControlParent> getUIElementsByType(ControlParent controllparent) {
        return sortListview(filter(contentClasses.getModelList(), controllparent));
    }
    private List<ControlParent> sortListview(List<ControlParent> list) {
        Collections.sort(list,new Comparator<ControlParent>() {
            public int compare(ControlParent cp1, ControlParent cp2) {
                return cp1.getTitel(view.getBaseContext()).compareToIgnoreCase(cp2.getTitel(view.getBaseContext()));
            }
        });
        return list;
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

    public void save(String id) {
        widgetList.removeAll(getWidgetDataByPosition(x,y,widgetList));
        widgetList.add(new WidgetData(id,x,y));
        repo.save(widgetList);
    }

    public List<WidgetData> getWidgetDataByPosition(int x, int y, List<WidgetData> base) {
        List<WidgetData> result = new ArrayList<WidgetData>();
        for (WidgetData widget:base ) {
            if (widget.getY() == y && widget.getX() == x)
                result.add(widget);
        }
        return  result;


    }

    public List<ControlParent> getSuperclasses() {
        return superClasses.getModelList();
    }



}
