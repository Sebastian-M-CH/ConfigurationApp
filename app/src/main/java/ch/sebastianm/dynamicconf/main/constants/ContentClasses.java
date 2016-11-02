package ch.sebastianm.dynamicconf.main.constants;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.AirPlaneModeButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.GPSButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.WIFIButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.BluetoothSwitchControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.WifiSwitchControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.AndroidVersionTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.BlueToothTextView;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.CurrentDateTextView;
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
        if (_instance == null)
        {
            _instance = new ContentClasses();
        }
        return _instance;
    }

    private ContentClasses() {
        contentClassList = new ArrayList<ControlParent>();
        //Buttons
        contentClassList.add(new GPSButtonControl());
        contentClassList.add(new WIFIButtonControl());
        contentClassList.add(new AirPlaneModeButtonControl());

        //Switches
        contentClassList.add(new WifiSwitchControl());
        contentClassList.add(new BluetoothSwitchControl());


        //TextViews
        contentClassList.add(new WifiNameTextView());
        contentClassList.add(new BlueToothTextView());
        contentClassList.add(new MobileNumberTextView());
        contentClassList.add(new NetworkOperatorNameTextView());
        contentClassList.add(new AndroidVersionTextView());
        contentClassList.add(new CurrentDateTextView());
        contentClassList.add(new GPSStateTextView());
    }

    public List<ControlParent> getModelList()
    {
        return contentClassList;
    }

}
