package ch.sebastianm.dynamicconf.main.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.controllers.MainOverviewController;
import ch.sebastianm.dynamicconf.main.listeners.BroadcastListener;
import ch.sebastianm.dynamicconf.main.listeners.RingModeChangeListener;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.UpdataClass;

public class Main_Overview extends MainPageParent {
    public MainOverviewController mainPageController;

    private RingModeChangeListener rmCL = new RingModeChangeListener();

    @Override
    public void setActivity()
    { setContentView(R.layout.activity_main__overview);}

    @Override
    public void init(){
        mainPageController = new MainOverviewController(this);
    }

    @Override
    public View getButton(Context con, int x, int y) {
        View view = mainPageController.getButton(getBaseContext(),x,y);
        if (mainPageController.getListener(getBaseContext(),x,y).contains(rmCL))
            rmCL.addedViews.add(mainPageController.getControl(x,y).getUpdateClass(con));
        return view;
    }

    @Override
    public void prepareListener() {
        rmCL.addedViews.clear();
        registerReceiver(rmCL.getReceiver(this),rmCL.getIntentfilter());
    }

}
