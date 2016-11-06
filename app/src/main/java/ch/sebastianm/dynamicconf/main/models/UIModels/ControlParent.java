package ch.sebastianm.dynamicconf.main.models.UIModels;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

import ch.sebastianm.dynamicconf.main.listeners.BroadcastListener;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.UpdataClass;

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
    public Set<BroadcastListener> getListeners(Context con){
        return new HashSet<BroadcastListener>();
    }
    public UpdataClass getUpdateClass(Context con) {return null;}
}
