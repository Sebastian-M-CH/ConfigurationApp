package ch.sebastianm.dynamicconf.main.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.controllers.MainPageController;
import ch.sebastianm.dynamicconf.main.models.UIModels.WidgetUI;

public class Main_Placement extends Page_Parent {

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
        ll.setBackgroundColor(Color.BLACK);

    }

    @Override
    public int getViewPos() {
        return 0;
    }


}
