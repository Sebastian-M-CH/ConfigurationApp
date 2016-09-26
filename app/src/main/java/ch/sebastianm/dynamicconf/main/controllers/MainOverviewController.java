package ch.sebastianm.dynamicconf.main.controllers;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import ch.sebastianm.dynamicconf.main.activities.Main_Overview;
import ch.sebastianm.dynamicconf.main.controllers.Converter.WidgetDataToWidgetUI;
import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
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

    public WidgetDataToWidgetUI widgetDataToWidgetUI = new WidgetDataToWidgetUI();

    public FileRepository repo;
    private void init(){
        repo = FileRepository.getInstance(view.getApplicationContext());
        widgetList = repo.getWidgetData();
    }

    public List<WidgetUI> getUIWidgets() {
        List<WidgetData> widgetDataList = repo.getWidgetData();
        return widgetDataToWidgetUI.map(widgetDataList);
    }

    List<WidgetData> widgetList;

    public View getButton(Context con, int x, int y) {
            widgetList = repo.getWidgetData();
            for (WidgetData data: widgetList ) {
                if (data.getX() == x && data.getY() == y)
                { ControlParent control =  widgetDataToWidgetUI.map(data).getControl();
                    if (control != null)
                        return control.getUIElement(con);
                }
            }
            return new Button(con);
        }
}
