package ch.sebastianm.dynamicconf.main.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.DynamicConfConstantes;

public class Field_Settings extends Page_Parent {

    SharedPreferences dynamicConfPref;
    SharedPreferences.Editor dynamicConfEditor;
    DynamicConfConstantes settingsConstant = new DynamicConfConstantes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_settings);
        dynamicConfPref = getSharedPreferences(settingsConstant.APPLICATION, Context.MODE_PRIVATE);
        setUpMainBtn();
        setUpFieldBtn();
        setUpConfigurationBtn();
        dynamicConfEditor  = dynamicConfPref.edit();
        setUpSeekBar((SeekBar) findViewById(R.id.seekBarAmountColumns), (TextView) findViewById(R.id.amountColumns), 1, dynamicConfEditor, settingsConstant.AMOUNTCOLUMNS, settingsConstant.AMOUNTCOLUMNSDEFAULT, settingsConstant.AMOUNTCOLUMNAMIN);
        setUpSeekBar((SeekBar) findViewById(R.id.seekBarRowHeight),(TextView) findViewById(R.id.heightRows),10, dynamicConfEditor, settingsConstant.ROWHEIGH, settingsConstant.ROWHEIGHTDEFAULT, settingsConstant.ROWHEIGHTMIN);

        //Fixme bis das design behoben ist
        findViewById(R.id.seekBarAmountColumns).setVisibility(View.INVISIBLE);
        findViewById(R.id.amountColumns).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView3).setVisibility(View.INVISIBLE);


        addOnklickListenerSaveButton((Button) findViewById(R.id.saveButton));
    }


    public void addOnklickListenerSaveButton(Button saveButton) {
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dynamicConfEditor.commit();
                startActivity(new Intent(getApplicationContext(), Main_Overview.class));
            }
        });
    }


    public void setUpSeekBar(SeekBar bar, final TextView view,final int stepsize, final SharedPreferences.Editor edit, final String property, final int defaultValue, final int min) {
        int value = dynamicConfPref.getInt(property, defaultValue) - min;
        bar.setProgress(value);
        view.setText(String.valueOf(value + min));
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = ((int) Math.round(progress / stepsize)) * stepsize;
                seekBar.setProgress(progress);
                view.setText(String.valueOf(progress + min));
                edit.putInt(property, progress + min);
            }
        });
    }

}
