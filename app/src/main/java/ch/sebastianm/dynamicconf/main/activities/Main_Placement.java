package ch.sebastianm.dynamicconf.main.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.controllers.MainPlacementController;

public class Main_Placement extends MainPageParent {
    public MainPlacementController mainPageController;

    @Override
    public void setActivity()
    { setContentView(R.layout.activity_main__placement);}


    @Override
    public void init(){
        mainPageController = new MainPlacementController(this);
    }

    @Override
    public View getButton(Context con, int x, int y) {
        Button btn = new Button(con);
        btn.setText(mainPageController.getMatchingWidgetName(x, y));
        btn.setOnClickListener(getClickListener(x, y));
        btn.setBackgroundColor(Color.WHITE);
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
    public void markSpecialIcons(GradientDrawable gd, View view){
        if(view instanceof Button && ((Button)view).getText().equals(view.getResources().getString(R.string.title_empty_field)))
         gd.setColor(ContextCompat.getColor(view.getContext(), R.color.selectedColor));
    }

}

