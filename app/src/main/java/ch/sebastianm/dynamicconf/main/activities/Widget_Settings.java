package ch.sebastianm.dynamicconf.main.activities;

import android.os.Bundle;

import ch.sebastianm.dynamicconf.R;

public class Widget_Settings extends Page_Parent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_settings);
        setUpSpinner();
    }

    @Override
    public int getViewPos()
    {
        return 1;
    }
}
