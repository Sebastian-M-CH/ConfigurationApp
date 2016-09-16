package ch.sebastianm.dynamicconf.main.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import ch.sebastianm.dynamicconf.R;

public class Field_Settings extends Page_Parent {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_settings);
        setUpSpinner();
    }

    @Override
    public int getViewPos() {
        return 2;
    }
}
