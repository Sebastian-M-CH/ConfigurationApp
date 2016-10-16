package ch.sebastianm.dynamicconf.main.models.UIModels.TextControls;

import android.content.Context;
import android.graphics.Color;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class TextControls extends ControlParent{

    DynamicConfConstantes constants = new DynamicConfConstantes();

    public TextView prepateBusinessLogic(TextView text, Context con) {
        text.setText(getContentText(con));
        text.setTextColor(Color.BLACK);
        return text;
    }

    @Override
    public TextView getUIElement(Context context){
        return prepateBusinessLogic(new TextView(context), context);
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

}
