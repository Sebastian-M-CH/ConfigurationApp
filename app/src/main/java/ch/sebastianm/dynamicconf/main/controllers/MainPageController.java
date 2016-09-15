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
public class MainPageController {

   public void MainPageController(Main_Overview view) {
       this.view = view;
   }

    public Main_Overview view;

    public FileRepository fileRepo = FileRepository.getInstance();

    public WidgetDataToWidgetUI widgetDataToWidgetUI = new WidgetDataToWidgetUI();

    public List<WidgetUI> getUIWidgets() {
        List<WidgetData> widgetDataList = fileRepo.getWidgetData();
        return widgetDataToWidgetUI.map(widgetDataList);
    }


}
