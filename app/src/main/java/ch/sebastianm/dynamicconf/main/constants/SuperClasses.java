package ch.sebastianm.dynamicconf.main.constants;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.ButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.GPSButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.SwitchControls;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.TextControls;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class SuperClasses {

    private static SuperClasses _instance;

    List<ControlParent> superclassList;

    public synchronized static SuperClasses getInstance()
    {
        if (_instance == null)
        {
            _instance = new SuperClasses();
        }
        return _instance;
    }

    private SuperClasses() {
        superclassList = new ArrayList<ControlParent>();
        superclassList.add(new ButtonControl());
        superclassList.add(new SwitchControls());
        superclassList.add(new TextControls());
    }

    public List<ControlParent> getModelList()
    {
        return  superclassList;
    }

}
