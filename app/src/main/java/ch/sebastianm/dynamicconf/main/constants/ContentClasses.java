package ch.sebastianm.dynamicconf.main.constants;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.AirPlaneModeButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.BatterySavingButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.DataRoamingButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.GPSButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.WIFIButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.BluetoothSwitchControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.RingModeSilence;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.RingModeVibration;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.WifiSwitchControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.AndroidVersionTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.BlueToothTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.CurrentDateTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.CurrentTimeZoneTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.FreeStorageTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.GPSStateTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.MobileNumberTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.NetworkOperatorNameTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.WifiNameTextView;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class ContentClasses {

    private static ContentClasses _instance;

    List<ControlParent> contentClassList;

    public synchronized static ContentClasses getInstance()
    {
        //FIXME Mehr Objecte aber das doppelte Parentproblem ist weg
        _instance = new ContentClasses();
        return _instance;
    }

    private ContentClasses() {
        contentClassList = new ArrayList<ControlParent>();
        //Buttons
        contentClassList.add(new GPSButtonControl());
        contentClassList.add(new WIFIButtonControl());
        contentClassList.add(new AirPlaneModeButtonControl());
        contentClassList.add(new DataRoamingButtonControl());
        contentClassList.add(new BatterySavingButtonControl());

        //Switches
        contentClassList.add(new WifiSwitchControl());
        contentClassList.add(new BluetoothSwitchControl());
        contentClassList.add(new RingModeSilence());
        contentClassList.add(new RingModeVibration());


        //TextViews
        contentClassList.add(new WifiNameTextView());
        contentClassList.add(new BlueToothTextView());
        contentClassList.add(new MobileNumberTextView());
        contentClassList.add(new NetworkOperatorNameTextView());
        contentClassList.add(new AndroidVersionTextView());
        contentClassList.add(new CurrentDateTextView());
        contentClassList.add(new GPSStateTextView());
        contentClassList.add(new CurrentTimeZoneTextView());
        contentClassList.add(new FreeStorageTextView());
    }

    public List<ControlParent> getModelList()
    {
        return contentClassList;
    }

}
