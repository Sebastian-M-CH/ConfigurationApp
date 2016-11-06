package ch.sebastianm.dynamicconf.main.models.Datamodels.Updater;

import android.content.Context;
import android.view.View;

import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

/**
 * Created by Sebastian on 05.11.2016.
 */
public class UpdataClass {

    public UpdataClass(ControlParent updateLogic, View view) {
        this.updateLogic = updateLogic;
        this.view = view;
    }

    private UpdataClass() {}

    public ControlParent updateLogic;
    public View view;

    public void update(Context con) {}

}
