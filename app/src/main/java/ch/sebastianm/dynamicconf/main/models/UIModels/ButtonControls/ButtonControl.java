package ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class ButtonControl extends ControlParent{

    DynamicConfConstantes constants = new DynamicConfConstantes();

    public Button prepareBusinessButton(Button button, Context con) {
        button.setOnClickListener(getBusinessListener(con));
        button.setText(getTitel(con));
        button.setTextColor(Color.BLACK);
        return button;
    }
    private Button view;

    private Button getView(Context con) {
        if(view == null)
            view = new Button(con);
        return view;
    }
    @Override
    public Button getUIElement(Context context){
        try{return prepareBusinessButton(getView(context), context);}
        catch (Exception exce)
        {
            Button button = new Button(context);
            button.setText(context.getResources().getString(R.string.fail));
            button.setEnabled(false);
            return button;
        }
    }

    @Override
    public String getTitel(Context con){
        return con.getResources().getString(R.string.title_buttons);
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

    @Override
    public String getGroup() { return constants.BUTTONGROUPID;}

}
