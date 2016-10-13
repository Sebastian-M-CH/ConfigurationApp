package ch.sebastianm.dynamicconf.main.activities;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.lang.reflect.Field;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.controllers.MainOverviewController;

public class Main_Overview extends MainPageParent {
    public MainOverviewController mainPageController;

    @Override
    public void setActivity()
    { setContentView(R.layout.activity_main__overview);}

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
