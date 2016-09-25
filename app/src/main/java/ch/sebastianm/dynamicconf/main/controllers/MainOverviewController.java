package ch.sebastianm.dynamicconf.main.controllers;

import java.util.List;

import ch.sebastianm.dynamicconf.main.activities.Main_Overview;
import ch.sebastianm.dynamicconf.main.controllers.Converter.WidgetDataToWidgetUI;
import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;
import ch.sebastianm.dynamicconf.main.models.UIModels.WidgetUI;
import ch.sebastianm.dynamicconf.main.controllers.repository.FileRepository;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class MainOverviewController {

    public MainOverviewController(Main_Overview view) {
       this.view = view;
        init();
   }

    public Main_Overview view;

    public FileRepository repo;

    public WidgetDataToWidgetUI widgetDataToWidgetUI = new WidgetDataToWidgetUI();

    private void init(){
        repo = FileRepository.getInstance(view.getApplicationContext());
    }

    public List<WidgetUI> getUIWidgets() {
        List<WidgetData> widgetDataList = repo.getWidgetData();
        return widgetDataToWidgetUI.map(widgetDataList);
    }


}
