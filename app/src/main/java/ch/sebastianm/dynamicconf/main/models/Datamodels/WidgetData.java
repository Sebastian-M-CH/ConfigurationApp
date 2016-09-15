package ch.sebastianm.dynamicconf.main.models.Datamodels;

import ch.sebastianm.dynamicconf.main.models.Widget;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class WidgetData extends Widget {

    private String controlID;

    public WidgetData(String controlId, Integer x, Integer y) {
        super(x,y);
        this.controlID = controlId;
    }

    public String getControlID() {
        return controlID;
    }

    public void setControlID(String controlID) {
        this.controlID = controlID;
    }


}
