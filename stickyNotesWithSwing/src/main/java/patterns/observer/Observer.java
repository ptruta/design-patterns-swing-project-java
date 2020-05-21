package patterns.observer;

import javax.swing.*;

public abstract class Observer {
    protected Subject subject;
    public abstract void update(JTextArea textArea, String Elem);
}
