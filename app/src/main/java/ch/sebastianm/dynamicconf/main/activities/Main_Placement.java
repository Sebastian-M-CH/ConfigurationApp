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

}

