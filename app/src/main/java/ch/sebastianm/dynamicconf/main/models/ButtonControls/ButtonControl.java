package ch.sebastianm.dynamicconf.main.models.ButtonControls;

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

    public Button prepare(Button button)
    {
        button.setOnClickListener(getListener());
        return button;
    }

    public String getTitel(){
        return "Not Implemented";
    }

    public Intent getIntent(){
        return null;
    }

    public View.OnClickListener getListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(getIntent());
            }
        };
    }

}
