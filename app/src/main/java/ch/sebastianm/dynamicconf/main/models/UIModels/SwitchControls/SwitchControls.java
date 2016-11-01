package ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class SwitchControls extends ControlParent{

    DynamicConfConstantes constants = new DynamicConfConstantes();

    public Switch prepateBusinessLogic(Switch switchControl, Context con) {
        switchControl.setOnCheckedChangeListener(getBusinessListener(con));
        switchControl.setChecked(getState(con));
        switchControl.setText(getTitel(con));
        switchControl.setTextColor(Color.BLACK);

        final float scale = con.getResources().getDisplayMetrics().density;
        switchControl.setPadding(switchControl.getPaddingLeft() + (int) (10.0f * scale + 0.5f),
                switchControl.getPaddingTop(),
                switchControl.getPaddingRight(),
                switchControl.getPaddingBottom());

        return switchControl;
    }

    @Override
    public Switch getUIElement(Context context){
        return prepateBusinessLogic(new Switch(context), context);
    }

    @Override
    public String getTitel(Context con){
        return con.getResources().getString(R.string.title_switches);
    }

    public CompoundButton.OnCheckedChangeListener getBusinessListener(final Context con) {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setBusinessLogic(isChecked, con);
            }
        };
    }

    public Boolean getState(Context con) {
        return false;
    }

    public void setBusinessLogic(Boolean bool, Context con) {}

    @Override
    public String getGroup() { return constants.SWITCHGROUPID;}

}
