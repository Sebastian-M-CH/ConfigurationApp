package ch.sebastianm.dynamicconf.main.activities;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.controllers.MainOverviewController;
import ch.sebastianm.dynamicconf.main.listeners.AirplaneModeChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.BlueToothChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.BroadcastListener;
import ch.sebastianm.dynamicconf.main.listeners.GpsChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.NetworkOperatorChangedListener;
import ch.sebastianm.dynamicconf.main.listeners.RingModeChangeListener;
import ch.sebastianm.dynamicconf.main.listeners.WifiChangeListener;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.UpdataClass;

public class Main_Overview extends MainPageParent {
    public MainOverviewController mainPageController;

    private RingModeChangeListener rmCL = new RingModeChangeListener();
    private WifiChangeListener wCL = new WifiChangeListener();
    private GpsChangeListener gpsCL = new GpsChangeListener();
    private BlueToothChangeListener btCL = new BlueToothChangeListener();
    private NetworkOperatorChangedListener nwoCL = new NetworkOperatorChangedListener();
    private AirplaneModeChangeListener apmCL = new AirplaneModeChangeListener();
    private Set<BroadcastListener> listeners = new HashSet<BroadcastListener>();

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
        for (BroadcastListener bcL: listeners) {
            registerViews(getBaseContext(),bcL,x,y);
        }
        return view;
    }

    public void registerViews(Context con, BroadcastListener bcL, int x, int y){
        if (mainPageController.getListener(getBaseContext(),x,y).contains(bcL))
            bcL.addedViews.add(mainPageController.getControl(x,y).getUpdateClass(con));
    }

    @Override
    public void prepareListener() {
        listeners.add(rmCL);
        listeners.add(wCL);
        listeners.add(gpsCL);
        //FixMe bluetooth switch springt in diesem fall
        //listeners.add(btCL);
        listeners.add(nwoCL);
        listeners.add(apmCL);

        for (BroadcastListener bcListener: listeners) {
            bcListener.addedViews.clear();
            registerReceiver(bcListener.getReceiver(this), bcListener.getIntentfilter());
        }
    }

    @Override
    public void unregisterListeners()
    { for (BroadcastListener bcListener: listeners) {
        bcListener.addedViews.clear();
        unregisterReceiver(bcListener.getReceiver(this));
    }

    }

}
