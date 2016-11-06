package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.SwitchUpdater;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.TextViewUpdater;
import ch.sebastianm.dynamicconf.main.models.Datamodels.Updater.UpdataClass;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class TextControls extends ControlParent{

    DynamicConfConstantes constants = new DynamicConfConstantes();

    public Button prepateBusinessLogic(Button text, Context con) {
        text.setText(getContentText(con));
        text.setTextColor(Color.BLACK);
        return text;
    }
    private Button view;

    private Button getView(Context con) {
        if(view == null)
            view = new Button(con);
        return view;
    }
    @Override
    public Button getUIElement(Context context){
        return prepateBusinessLogic(getView(context), context);
    }

    @Override
    public String getTitel(Context con){
        return con.getResources().getString(R.string.title_textViews);
    }

    public String getContentText(final Context con) {
        return "";
    }

    @Override
    public String getGroup() { return constants.TEXTVIEWGROUPID;}

    @Override
    public UpdataClass getUpdateClass(Context con) {return new TextViewUpdater(this, getUIElement(con));}

    public String cutResult(String result) {
        if(result == null)
            return "";
        if(result.length() >= 20)
            return result.substring(0,17)+ "...";
        else
            return result;
    }

}
