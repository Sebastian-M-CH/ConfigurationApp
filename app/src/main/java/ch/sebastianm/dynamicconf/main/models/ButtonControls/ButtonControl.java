package ch.sebastianm.dynamicconf.main.models.ButtonControls;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ch.sebastianm.dynamicconf.main.models.ControlParent;

/**
 * Created by Sebastian on 12.09.2016.
 */
public class ButtonControl extends ControlParent {

    public Button prepare(Button button, Context con) {
        button.setOnClickListener(getListener(con));
        button.setText(getTitel());
        return button;
    }

    public Button getPreparedButton(Context context){
        return prepare(new Button(context), context);
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

    public View.OnClickListener getListener(final Context con) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                con.startActivity(getFlagedIntent());
            }
        };
    }

}
