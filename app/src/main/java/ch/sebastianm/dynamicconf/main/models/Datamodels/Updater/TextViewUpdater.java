package ch.sebastianm.dynamicconf.main.models.Datamodels.Updater;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;
import ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls.SwitchControls;
import ch.sebastianm.dynamicconf.main.models.UIModels.TextControls.TextControls;

/**
 * Created by Sebastian on 05.11.2016.
 */
public class TextViewUpdater extends UpdataClass{

    public TextViewUpdater(ControlParent updateLogic, View view) {
        super(updateLogic, view);
    }

    @Override
    public void update(Context con) {
        Button viewItem = (Button) view;
        viewItem.setText(((TextControls) updateLogic).getContentText(con));
    }
}
