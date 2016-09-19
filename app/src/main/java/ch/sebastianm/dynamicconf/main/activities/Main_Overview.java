package ch.sebastianm.dynamicconf.main.activities;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.controllers.MainPageController;
import ch.sebastianm.dynamicconf.main.models.UIModels.WidgetUI;

public class Main_Overview extends Page_Parent {

    public MainPageController mainPageController = new MainPageController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__overview);
        setUpSpinner();
        setUpContent();
    }

    int height = 200;
    int i = 0;

    public void setUpContent() {

        final TableLayout ll = (TableLayout) findViewById(R.id.contentTableLayout);
        ll.setStretchAllColumns(true);
        ll.bringToFront();

        ViewTreeObserver vto = ll.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {

                GradientDrawable gd1 = new GradientDrawable();
                gd1.setCornerRadius(0);

                gd1.setStroke(2, Color.BLACK);
                android.widget.TableRow.LayoutParams p1 = new android.widget.TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                for(; i < (ll.getHeight())/height; i++){
                    TableRow tr =  new TableRow(ll.getContext());
                    Button c1 = new Button(ll.getContext());
                    c1.setBackgroundColor(Color.WHITE);
                    c1.setMinimumHeight(height);
                    c1.setBackgroundDrawable(gd1);
                    Button c2 = new Button(ll.getContext());
                    c2.setBackgroundColor(Color.WHITE);
                    c2.setMinimumHeight(height);
                    c2.setBackgroundDrawable(gd1);
                    tr.addView(c1);
                    tr.setMinimumHeight(height);
                    tr.setLayoutParams(p1);
                    ll.addView(tr);
                }

                return true;
            }
        });

    }

    // DisplayHelper:
    private static Float scale;
    public static int dpToPixel(int dp, Context context) {
        if (scale == null)
            scale = context.getResources().getDisplayMetrics().density;
        return (int) ((float) dp * scale);
    }

    @Override
    public int getViewPos() {
        return 0;
    }


}
