package ch.sebastianm.dynamicconf.main.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import ch.sebastianm.dynamicconf.R;

public class Page_Parent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_settings);
        setUpMainBtn();
        setUpFieldBtn();
        setUpConfigurationBtn();
    }

    public void setUpMainBtn() {
        addOnklickListener((Button) findViewById(R.id.btnMain), new Intent(getApplicationContext(), Main_Overview.class));
    }
    public void setUpFieldBtn() {
        addOnklickListener((Button) findViewById(R.id.btnField), new Intent(getApplicationContext(), Field_Settings.class));
    }
    public void setUpConfigurationBtn() {
        addOnklickListener((Button) findViewById(R.id.btnWidget), new Intent(getApplicationContext(), Main_Placement.class));
    }

    public void addOnklickListener(Button btn, final Intent intent) {
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    public void unregisterListeners()
    {}

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
