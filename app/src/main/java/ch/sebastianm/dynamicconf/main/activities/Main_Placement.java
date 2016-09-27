package ch.sebastianm.dynamicconf.main.activities;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.controllers.MainPlacementController;

public class Main_Placement extends MainPageParent {
    public MainPlacementController mainPageController;

    @Override
    public void init(){
        mainPageController = new MainPlacementController(this);
    }

    @Override
    public View getButton(Context con, int x, int y) {
        Button btn = new Button(con);
        btn.setText(mainPageController.getMatchingWidgetName(x, y));
        btn.setOnClickListener(getClickListener(x,y));
        return btn;
    }

    public View.OnClickListener getClickListener(final int x , final int y) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Widget_Settings.class);
                intent.putExtra("x", x);
                intent.putExtra("y", y);
                v.getContext().startActivity(intent);
            }
        };
    }

    @Override
    public String[] possibleTitles() {
        String[] result =  new String[2];
        result[0] = getResources().getString(R.string.main_overview_title);
        result[1] = getResources().getString(R.string.field_settings_title);
        return result;
    }

    @Override
    public Intent[] possibleIntents() {
        Intent[] result =  new Intent[2];
        result[0] = new Intent(getApplicationContext(), Main_Overview.class);
        result[1] = new Intent(getApplicationContext(), Field_Settings.class);
        return result;
    }
}

