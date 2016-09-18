package ch.sebastianm.dynamicconf.main.controllers.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.sebastianm.dynamicconf.main.models.Datamodels.WidgetData;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class FileRepository {

    private static FileRepository _instance;

    String resourceString;
    File file;

    public synchronized static FileRepository getInstance()
    {
        if (_instance == null)
        {
            _instance = new FileRepository();
        }
        return _instance;
    }

    private FileRepository() {
        file  = new File("settings");
            int length = (int) file.length();

        byte[] bytes = new byte[length];

        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            try {
                in.read(bytes);
                resourceString  = new String(bytes);
            } finally {
                in.close();
            }
        } catch (IOException e) {
            createNewFile(file);
            resourceString = "";
        }

    }

    public void createNewFile(File file)
    {
        try {
            FileOutputStream stream = new FileOutputStream(file);
            try {
                stream.write("".getBytes());
            } finally {
                stream.close();
            }
        }
        catch(Exception e) {
        }
    }

    public List<WidgetData> getWidgetData() {
        List<WidgetData> widgetDataList = new ArrayList<WidgetData>();
        String[] widgetListSplit = resourceString.split("|");
        for (String widget: widgetListSplit ) {
            System.out.println(widget);
            String[] widgetSplit = widget.split(";");
            if(widgetSplit.length != 3)
                continue;
            WidgetData widgetData = new WidgetData(widgetSplit[0], Integer.parseInt(widgetSplit[1]), Integer.parseInt(widgetSplit[2]));
            widgetDataList.add(widgetData);
        }
        return widgetDataList;
    }

}
