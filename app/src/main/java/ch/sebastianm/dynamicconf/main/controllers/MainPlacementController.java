package ch.sebastianm.dynamicconf.main.controllers;

import java.util.List;

import ch.sebastianm.dynamicconf.main.activities.Main_Overview;
import ch.sebastianm.dynamicconf.main.activities.Main_Placement;
import ch.sebastianm.dynamicconf.main.controllers.Converter.WidgetDataToWidgetUI;
import ch.sebastianm.dynamicconf.main.controllers.repository.FileRepository;
import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
import ch.sebastianm.dynamicconf.main.models.UIModels.WidgetUI;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class MainPlacementController {

    public MainPlacementController(Main_Placement view) {
       this.view = view;
        init();
   }


    public FileRepository repo;

    private void init(){
        repo = FileRepository.getInstance(view.getApplicationContext());
        widgetList = repo.getWidgetData();
    }

    public Main_Placement view;


    public WidgetDataToWidgetUI widgetDataToWidgetUI = new WidgetDataToWidgetUI();

    List<WidgetData> widgetList;

    public String getMatchingWidgetName(int x, int y) {
        for (WidgetData data: widgetList ) {
            if (data.getX() == x && data.getY() == y)
            { ControlParent control =  widgetDataToWidgetUI.map(data).getControl();
                if (control != null)
                    return control.getTitel();
            }
        }
        return "empty";
    }



}
