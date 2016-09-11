package ch.sebastianm.dynamicconf.main.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import ch.sebastianm.dynamicconf.R;

public class Page_Parent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_settings);
        setUpSpinner();
    }
    Spinner navSpinner;

    public int getViewPos()
    {
        return 0;
    }

    public void setUpSpinner() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        navSpinner = (Spinner) findViewById(R.id.spinner_nav_settings);
        navSpinner.setSelection(getViewPos());
        baseValue = getViewPos();
        addListenerOnSpinnerItemSelection();
    }

    int baseValue = 0;
    public void addListenerOnSpinnerItemSelection() {
        navSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if (baseValue != pos) {
                    Intent intent = null;
                    switch (pos) {
                        case 0:
                            intent = new Intent(getApplicationContext(), Main_Overview.class);
                            break;
                        case 1:
                            intent = new Intent(getApplicationContext(), Widget_Settings.class);
                            break;
                        case 2:
                            intent = new Intent(getApplicationContext(), Field_Settings.class);
                            break;
                    }
                    baseValue = pos;
                    startActivity(intent);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                int i = 0;
            }

        });
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem settingsItem = menu.findItem(R.id.action_settings);
        settingsItem.setVisible(false);
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main__overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
