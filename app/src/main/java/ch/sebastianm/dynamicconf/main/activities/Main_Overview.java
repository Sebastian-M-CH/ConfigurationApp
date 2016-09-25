package ch.sebastianm.dynamicconf.main.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.constants.Settings;
import ch.sebastianm.dynamicconf.main.controllers.MainPageController;
import ch.sebastianm.dynamicconf.main.models.UIModels.WidgetUI;

public class Main_Overview extends MainPageParent {
    public MainPageController mainPageController = new MainPageController();

    public Button getButton(Context con, int x, int y)
    {

        return new Button(con);
    }
}
