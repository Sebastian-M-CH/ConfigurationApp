package ch.sebastianm.dynamicconf.main.controllers;

/**
 * Created by Sebastian on 18.09.2016.
 */

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ch.sebastianm.dynamicconf.R;
import ch.sebastianm.dynamicconf.main.activities.Main_Overview;
import ch.sebastianm.dynamicconf.main.activities.Main_Placement;
import ch.sebastianm.dynamicconf.main.activities.Widget_Settings;
import ch.sebastianm.dynamicconf.main.models.UIModels.ControlParent;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<ControlParent>> _listDataChild;
    private WidgetSettingsController controller;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<ControlParent>> listChildData, WidgetSettingsController con) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        this.controller = con;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = ((ControlParent) getChild(groupPosition, childPosition)).getTitel();
        final String id = ((ControlParent) getChild(groupPosition, childPosition)).getId();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        Button buttonChild = (Button) convertView
                .findViewById(R.id.lblListItem);

        buttonChild.setText(childText);
        buttonChild.setOnClickListener(getPlacementListener(convertView.getContext(), id));
        return convertView;
    }

    public View.OnClickListener getPlacementListener(final Context con,final String id) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                controller.save(id);
                con.startActivity(getFlagedIntent(con));
            }
        };
    }
    public Intent getFlagedIntent(Context con){
        return getIntent(con).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    public Intent getIntent(Context con) {
       return new Intent(con, Main_Placement.class);
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById( R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}