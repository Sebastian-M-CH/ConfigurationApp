package ch.sebastianm.dynamicconf.main.models.UIModels;

import android.content.Context;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class ControlParent {
    public String id;

    public String getId() {
        return id;
    }
    public View getUIElement(Context con) { return null;}
    public String getGroup() { return "";}
    public String getTitel(Context con){
        return "";
    }
}
