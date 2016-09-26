package ch.sebastianm.dynamicconf.main.activities;

import android.content.Context;
import android.view.View;

import ch.sebastianm.dynamicconf.main.controllers.MainOverviewController;

public class Main_Overview extends MainPageParent {
    public MainOverviewController mainPageController;

    @Override
    public void init(){
        mainPageController = new MainOverviewController(this);
    }

    @Override
    public View getButton(Context con, int x, int y)
    {
        return mainPageController.getButton(getBaseContext(),x,y);
    }
}
