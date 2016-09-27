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
    public void init(){
        mainPageController = new MainOverviewController(this);
    }

    @Override
    public View getButton(Context con, int x, int y)
    {
        return mainPageController.getButton(getBaseContext(),x,y);
    }

    @Override
    public String[] possibleTitles() {
        String[] result =  new String[2];
        result[0] = getResources().getString(R.string.field_settings_title);
        result[1] = getResources().getString(R.string.main_placement_title);
        return result;
    }

    @Override
    public Intent[] possibleIntents() {
        Intent[] result =  new Intent[2];
        result[0] = new Intent(getApplicationContext(), Field_Settings.class);
        result[1] = new Intent(getApplicationContext(), Main_Placement.class);
        return result;
    }
}
