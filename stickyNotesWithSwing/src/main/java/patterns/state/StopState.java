package patterns.state;

import patterns.factory.CreateStickyFactory;
import patterns.iterator.StickyIterator;
import patterns.observer.Observer;
import patterns.observer.Subject;

import javax.swing.*;
import java.util.List;

public class StopState extends Observer implements State {

    public StopState(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public StopState(){

    }

    @Override
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

        btnCloseAll.addActionListener(arg0 -> {
            try {
                System.out.println(stickyWindows.size());
                for (JInternalFrame jInternalFrame : stickyWindows) {
                    jInternalFrame.dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            update(textArea,textArea.getText()+"All stickies closed");
        });
        if (stickyWindows.size() == 0)
            context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }

    @Override
    public void update(JTextArea textField, String elem) {
        textField.setText(elem);
        textField.append("\n");
        textField.setVisible(true);
    }
}
