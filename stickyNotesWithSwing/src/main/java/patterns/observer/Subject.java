package patterns.observer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(JTextArea textArea, String elem) {
        //this.state = state;
        notifyAllObservers(textArea, elem);
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(JTextArea textArea, String elem){
        for (Observer observer : observers) {
            observer.update(textArea, elem);
        }
    }
}