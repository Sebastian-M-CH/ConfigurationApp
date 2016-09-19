package ch.sebastianm.dynamicconf.main.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewTreeObserver;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

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

    public void setUpContent() {
        TableLayout ll = (TableLayout) findViewById(R.id.contentTableLayout);
        ll.setStretchAllColumns(true);
        ll.bringToFront();

        android.widget.TableRow.LayoutParams pFirst = new android.widget.TableRow.LayoutParams();
        pFirst.rightMargin = dpToPixel(1, this.getApplicationContext()); // right-margin = 10dp
        pFirst.topMargin = dpToPixel(2, this.getApplicationContext()); // right-margin = 10dp
        pFirst.leftMargin = dpToPixel(2, this.getApplicationContext()); // right-margin = 10dp

        android.widget.TableRow.LayoutParams pSecond = new android.widget.TableRow.LayoutParams();
        pSecond.rightMargin = dpToPixel(2, this.getApplicationContext()); // right-margin = 10dp
        pSecond.topMargin = dpToPixel(2, this.getApplicationContext()); // right-margin = 10dp
        pSecond.leftMargin = dpToPixel(1, this.getApplicationContext()); // right-margin = 10dp

        Display display = getWindowManager().getDefaultDisplay();
        Toast.makeText(getApplicationContext(),
                String.valueOf(display.getHeight()),
                Toast.LENGTH_LONG).show();
        int height = 100;
        ll.setBackgroundColor(Color.BLACK);
        android.widget.TableRow.LayoutParams p1 = new android.widget.TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        for(int i = 0; i < (display.getHeight()-600)/height; i++){
            TableRow tr =  new TableRow(this);
            TextView c1 = new TextView(this);
            c1.setBackgroundColor(Color.WHITE);
            c1.setLayoutParams(pFirst);
            c1.setMinimumHeight(height);
            TextView c2 = new TextView(this);
            c2.setBackgroundColor(Color.WHITE);
            c2.setLayoutParams(pSecond);
            c2.setMinimumHeight(height);
            tr.addView(c1);
            tr.addView(c2);
            tr.setMinimumHeight(height);
            tr.setLayoutParams(p1);
            ll.addView(tr);
        }
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
