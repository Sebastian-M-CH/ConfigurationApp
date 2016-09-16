package ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class ButtonControl extends ControlParent {

    public Button prepareBusinessButton(Button button, Context con) {
        button.setOnClickListener(getBusinessListener(con));
        button.setText(getTitel());
        return button;
    }

    @Override
    public Button getUIElement(Context context){
        return prepareBusinessButton(new Button(context), context);
    }

    public String getTitel(){
        return "Not Implemented";
    }

    public Intent getFlagedIntent(){
         return getIntent().setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    public Intent getIntent(){
        return null;
    }

    public View.OnClickListener getBusinessListener(final Context con) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                con.startActivity(getFlagedIntent());
            }
        };
    }

    public View.OnClickListener getSettingsListener(final Intent view, final Context con) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                view.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                con.startActivity(view);
            }
        };
    }

}
