package ch.sebastianm.dynamicconf.main.activities;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.models.UIModels.ButtonControls.GPSButtonControl;

public class Main_Overview extends Page_Parent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__overview);
        setUpSpinner();
        setUpContent();
    }

    public void setUpContent()
    {
        TableLayout ll = (TableLayout) findViewById(R.id.contentTableLayout);
        TableRow row= new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setGravity(Gravity.RIGHT);
        row.setLayoutParams(lp);
        GPSButtonControl gps = new GPSButtonControl();
        row.addView(gps.getBusinessButton(getApplicationContext()));
        ll.addView(row);
        ll.addView(gps.getBusinessButton(getApplicationContext()),1);
    }

    @Override
    public int getViewPos() {
        return 0;
    }


}
