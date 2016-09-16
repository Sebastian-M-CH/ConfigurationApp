package ch.sebastianm.dynamicconf.main.activities;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;

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
        for (WidgetUI controlParent : mainPageController.getUIWidgets()) {
            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            row.addView(controlParent.getControl().getUIElement(getApplicationContext()));
            ll.addView(row);
        }
    }

    @Override
    public int getViewPos() {
        return 0;
    }


}
