package ch.sebastianm.dynamicconf.main.activities;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import java.util.List;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.controllers.WidgetSettingsController;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

public class Widget_Settings extends Page_Parent {


    WidgetSettingsController widgetSettingsController = new WidgetSettingsController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_settings);
        setUpSpinner();


    }

    public void createContent() {
        List<ControlParent> superclasses = widgetSettingsController.getSuperclasses();
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        for (ControlParent superclass :superclasses ) {
            ExpandableListView exListView = new ExpandableListView(this);
            exListView.setFilterText(superclass.getId());
            ll.addView(exListView);
        }

    }



    @Override
    public int getViewPos()
    {
        return 1;
    }
}
