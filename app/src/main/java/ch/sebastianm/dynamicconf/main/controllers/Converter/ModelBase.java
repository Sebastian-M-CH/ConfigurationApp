package ch.sebastianm.dynamicconf.main.controllers.Converter;

import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.GPSButtonControl;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class ModelBase {

    private static ModelBase _instance;

    List<ControlParent> modelList;

    public synchronized static ModelBase getInstance()
    {
        if (_instance == null)
        {
            _instance = new ModelBase();
        }
        return _instance;
    }

    private ModelBase() {
        modelList = new ArrayList<ControlParent>();
        modelList.add(new GPSButtonControl());
    }

    public List<ControlParent> getModelList()
    {
        return  modelList;
    }

}
