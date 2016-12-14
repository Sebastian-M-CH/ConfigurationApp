package ch.sebastianm.dynamicconf.main.models.UIModels.SwitchControls;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.SwitchUpdater;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.UpdataClass;
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
        switchControl.setTextSize(15);
        switchControl.setTextColor(Color.BLACK);
        switchControl.setPaintFlags(Paint.FAKE_BOLD_TEXT_FLAG);
        switchControl.setLeft(20);

        final float scale = con.getResources().getDisplayMetrics().density;

        switchControl.setPadding(
                (int) (30.0f * scale + 0.5f),
                switchControl.getPaddingTop(),
                (int) (30.0f * scale + 0.5f) ,
                switchControl.getPaddingBottom());

        return switchControl;
    }

    private Switch view;

    private Switch getView(Context con) {
        if(view == null)
            view = new Switch(con);
        return view;
    }

    @Override
    public Switch getUIElement(Context context){
        try{return prepateBusinessLogic(getView(context), context);}
        catch (Exception exce)
        {
            Switch switchFailur = new Switch(context);
            switchFailur.setText(context.getResources().getString(R.string.fail));
            switchFailur.setEnabled(false);
            return switchFailur;
        }
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

    @Override
    public UpdataClass getUpdateClass(Context con) {return new SwitchUpdater(this, getUIElement(con));}

}
