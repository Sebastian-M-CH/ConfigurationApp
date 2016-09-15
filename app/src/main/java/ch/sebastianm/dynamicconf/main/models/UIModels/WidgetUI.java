package ch.sebastianm.dynamicconf.main.models.UIModels;

import ch.sebastianm.dynamicconf.main.models.Widget;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class WidgetUI extends Widget{

    private ControlParent control;

    public WidgetUI(ControlParent control, int x, int y) {
        super(x,y);
        this.control = control;
    }

    public ControlParent getControl() {
        return control;
    }

    public void setControl(ControlParent control) {
        this.control = control;
    }
}
