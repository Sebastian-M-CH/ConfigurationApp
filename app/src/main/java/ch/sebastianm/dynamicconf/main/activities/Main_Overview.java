package ch.sebastianm.dynamicconf.main.activities;

import android.content.Context;
import android.widget.Button;

import ch.sebastianm.dynamicconf.main.controllers.MainOverviewController;

public class Main_Overview extends MainPageParent {
    public MainOverviewController mainPageController;

    @Override
    public void init(){
        mainPageController = new MainOverviewController(this);
    }

    @Override
    public Button getButton(Context con, int x, int y)
    {
        return new Button(con);
    }
}
