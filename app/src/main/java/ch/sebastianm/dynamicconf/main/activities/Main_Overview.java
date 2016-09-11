package ch.sebastianm.dynamicconf.main.activities;

import android.os.Bundle;

import ch.sebastianm.dynamicconf.R;

public class Main_Overview extends Page_Parent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__overview);
        setUpSpinner();
    }

    @Override
    public int getViewPos()
    {
        return 0;
    }


}
