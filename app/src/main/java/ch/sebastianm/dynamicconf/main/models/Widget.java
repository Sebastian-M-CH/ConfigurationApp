package ch.sebastianm.dynamicconf.main.models;

/**
 * Created by Sebastian on 15.09.2016.
 */
public class Widget {
    protected int x;
    protected int y;

    public Widget(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }



}
