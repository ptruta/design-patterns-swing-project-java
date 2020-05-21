package patterns.prototype;

import patterns.iterator.StickyIterator;

import javax.swing.*;
import java.util.List;

public abstract class Sticky implements Cloneable{
    private String id;
    protected String type;

    public abstract void createSticky(StickyIterator stickyIterator,
                                      JInternalFrame stickyWindow,
                                      JDesktopPane desktopPane,
                                      List<JInternalFrame> stickyWindows,
                                      JTextArea textArea);

    public String getType(){
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}