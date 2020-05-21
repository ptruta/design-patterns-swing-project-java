package patterns.observer;

import patterns.state.StartState;
import patterns.state.StopState;

import javax.swing.*;

public class ObserverPattern {

    public void observable(JTextArea textArea, String elem) {
        Subject subject = new Subject();

        StartState startState = new StartState(subject);
        StopState stopState = new StopState(subject);

        startState.update(textArea, elem);
        stopState.update(textArea, elem);
    }
}
