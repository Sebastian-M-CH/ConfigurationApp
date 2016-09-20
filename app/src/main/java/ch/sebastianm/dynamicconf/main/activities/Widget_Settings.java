package ch.sebastianm.dynamicconf.main.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.controllers.ExpandableListAdapter;
import ch.sebastianm.dynamicconf.main.controllers.WidgetSettingsController;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

public class Widget_Settings extends Page_Parent {

    WidgetSettingsController widgetSettingsController = new WidgetSettingsController();

    ExpandableListAdapter listAdapter;
    List<String> listDataHeader;
    HashMap<String, List<ControlParent>> listDataChild;

    String placement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_settings);
        setUpNavButton();
        Bundle extras = getIntent().getExtras();
        placement = extras.getString("placement");
        widgetSettingsController.getPlacement(Integer.valueOf(placement.split(";")[0]),Integer.valueOf(placement.split(";")[1]));
        createContent();

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<ControlParent>>();

        int index = 0;
        for (ControlParent pare: widgetSettingsController.getSuperclasses()) {
            listDataHeader.add(pare.getTitel());
            listDataChild.put(listDataHeader.get(index), widgetSettingsController.getUIElementsByType(pare));
            index++;
        }
    }

    public void createContent() {
        List<ControlParent> superclasses = widgetSettingsController.getSuperclasses();
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        for (ControlParent superclass :superclasses ) {
            ExpandableListView exListView = new ExpandableListView(this);
            exListView.setTag(superclass.getTitel());
            exListView.setAdapter(listAdapter);
            ll.addView(exListView);
        }

    }

}
