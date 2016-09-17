package ch.sebastianm.dynamicconf.main.constants;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.GPSButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

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
        contentClassList.add(new GPSButtonControl());
    }

    public List<ControlParent> getModelList()
    {
        return contentClassList;
    }

}
