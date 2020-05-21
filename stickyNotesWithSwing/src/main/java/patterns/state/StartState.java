package patterns.state;

import patterns.factory.CreateStickyFactory;
import patterns.iterator.StickyIterator;
import patterns.observer.Observer;
import patterns.observer.Subject;

import javax.swing.*;
import java.util.List;

public class StartState extends Observer implements State{

    public StartState(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public StartState(){

    }

    public void doAction(JButton btnMenuSelectRectangle,
                         JButton btnMenuSelectSquare,
                         JButton btnCreateChildSquareSticky,
                         JButton btnCreateChildRectangleSticky,
                         JButton btnCloseAll,
                         Context context,
                         CreateStickyFactory stickyFactory,
                         StickyIterator stickyIterator,
                         JInternalFrame stickyWindow,
                         JDesktopPane desktopPane,
                         List<JInternalFrame> stickyWindows,
                         JTextArea textArea) {

        StickyIterator stickyIteratorChild = new StickyIterator();

        btnMenuSelectRectangle.addActionListener(e -> {
            stickyIteratorChild.setPos();
            stickyFactory
                    .getSticky("rectangle")
                    .createSticky(stickyIterator, stickyWindow, desktopPane, stickyWindows, textArea);
            stickyIterator.next();
            update(textArea,textArea.getText()+"Rectangle Sticky added");
        });

        btnMenuSelectSquare.addActionListener(e -> {
            stickyIteratorChild.setPos();
            stickyFactory
                    .getSticky("square")
                    .createSticky(stickyIterator, stickyWindow, desktopPane, stickyWindows, textArea);
            stickyIterator.next();
            update(textArea,textArea.getText()+"Square Sticky added");
        });

        btnCreateChildRectangleSticky.addActionListener(e->{
            stickyFactory
                    .getSticky("rectangle")
                    .createSticky(stickyIteratorChild, stickyWindow, desktopPane, stickyWindows, textArea);
            stickyIteratorChild.next();
            update(textArea,textArea.getText()+"Rectangle Child Sticky added");
        });

        btnCreateChildSquareSticky.addActionListener(e->{
            stickyFactory
                    .getSticky("square")
                    .createSticky(stickyIteratorChild, stickyWindow, desktopPane, stickyWindows, textArea);
            stickyIteratorChild.next();
            update(textArea,textArea.getText()+"Square Child Sticky added");
        });
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }

    @Override
    public void update(JTextArea textField, String elem) {
        textField.setText(elem);
        textField.append("\n");
        textField.setVisible(true);
    }
}