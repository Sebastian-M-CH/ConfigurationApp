package ch.sebastianm.dynamicconf.main.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;
import ch.sebastianm.dynamicconf.main.controllers.MainPlacementController;
import ch.sebastianm.dynamicconf.main.controllers.repository.FileRepository;

public class MainPageParent extends Page_Parent {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivity();
        prepareListener();
        setUpContent();
        setUpMainBtn();
        setUpFieldBtn();
        setUpConfigurationBtn();
        settingsConstants = new DynamicConfConstantes();
        dynamicConfPref = getSharedPreferences(settingsConstants.APPLICATION, Context.MODE_PRIVATE);
        height = dynamicConfPref.getInt(settingsConstants.ROWHEIGH, settingsConstants.ROWHEIGHTDEFAULT);
        columns = dynamicConfPref.getInt(settingsConstants.AMOUNTCOLUMNS, settingsConstants.AMOUNTCOLUMNSDEFAULT);
        setUpContent();
        init();
    }

    public void prepareListener()
    {}

    public void setActivity()
    { setContentView(R.layout.activity_main__overview);}

    public void init(){ }

    DynamicConfConstantes settingsConstants;
    SharedPreferences dynamicConfPref;
    int height;
    int columns;
    int i = 0;

    public void setUpContent() {

        final TableLayout ll = (TableLayout) findViewById(R.id.contentTableLayout);
        ll.removeAllViews();

        ll.setStretchAllColumns(true);
        ll.bringToFront();

        ViewTreeObserver vto = ll.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                for (; i < (ll.getHeight()) / height; i++) {
                    TableRow tr = new TableRow(ll.getContext());
                    for (int columnCounter = 0; columnCounter < columns; columnCounter++) {
                        GradientDrawable gd1 = new GradientDrawable();
                        gd1.setCornerRadius(0);
                        gd1.setStroke(2, Color.BLACK);

                        View btn = getButton(ll.getContext(), i, columnCounter);
                        btn.setMinimumHeight(height);
                        btn.setMinimumWidth(ll.getWidth() / (columns));
                        markSpecialIcons(gd1, btn);
                        btn.setBackgroundDrawable(gd1);
                        tr.addView(btn);
                    }
                    tr.setMinimumHeight(height);
                    tr.setElevation(5);
                    ll.addView(tr);
                }
                cleanSelectedWidgets(i);
                return true;
            }
        });


    }

    public void cleanSelectedWidgets(int lastWidget){
        FileRepository.getInstance(getBaseContext()).reduceWidgetListTo(lastWidget);
    }

    public void markSpecialIcons(GradientDrawable gd, View view){}

    public View getButton(Context con, int x, int y)
    {
        return new Button(con);
    }
}