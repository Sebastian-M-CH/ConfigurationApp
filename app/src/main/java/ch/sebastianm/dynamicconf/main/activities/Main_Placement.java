package ch.sebastianm.dynamicconf.main.activities;

import android.content.Context;
import android.widget.Button;

import java.util.List;

import ch.sebastianm.dynamicconf.main.controllers.MainOverviewController;
import ch.sebastianm.dynamicconf.main.controllers.MainPlacementController;
import ch.sebastianm.dynamicconf.main.controllers.repository.FileRepository;
import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;

public class Main_Placement extends MainPageParent {
    public MainPlacementController mainPageController;

    @Override
    public void init(){
        mainPageController = new MainPlacementController(this);
    }

    @Override
    public Button getButton(Context con, int x, int y)
    {
        Button btn = new Button(con);
        btn.setText(mainPageController.getMatchingWidgetName(x, y));
        btn.setOnClickListener(null);
        return btn;
    }
}
