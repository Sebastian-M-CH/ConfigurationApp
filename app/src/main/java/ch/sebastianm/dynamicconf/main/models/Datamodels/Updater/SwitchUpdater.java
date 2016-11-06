package ch.sebastianm.dynamicconf.main.models.Datamodels.Updater;

import android.content.Context;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.SwitchControls;

/**
 * Created by Sebastian on 05.11.2016.
 */
public class SwitchUpdater extends UpdataClass{

    public SwitchUpdater(ControlParent updateLogic, View view) {
        super(updateLogic, view);
    }

    @Override
    public void update(Context con) {
        Switch viewItem = (Switch) view;
        viewItem.setChecked(((SwitchControls)updateLogic).getState(con));
    }
}
