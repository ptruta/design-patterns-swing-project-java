package patterns;

import patterns.iterator.StickyIterator;
import patterns.prototype.Sticky;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.util.List;

public class StickySquare extends Sticky {

    public StickySquare(){
        type = "Sticky";
    }

    @Override
    public void createSticky(StickyIterator stickyIterator,
                             JInternalFrame stickyWindow,
                             JDesktopPane desktopPane,
                             List<JInternalFrame> stickyWindows,
                             JTextArea textArea) {

        int a = 30;
        int b = 30;
        stickyWindow = new JInternalFrame("Sticky (" + stickyIterator.getActual() + ")");
        stickyWindow.setVisible(true);
        stickyWindow.setResizable(true);
        stickyWindow.setBounds(300, 75, 200, 200);
        stickyWindow.setMaximizable(true);
        stickyWindow.setClosable(true);
        stickyWindow.setLocation(50, 60); //setLocation(xPosition * openFrameCount, yPosition * openFrameCount);
        desktopPane.add(stickyWindow);

        JScrollPane scrollPane = new JScrollPane();
        stickyWindow.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JEditorPane editorPane = new JEditorPane();
        scrollPane.setViewportView(editorPane);
        stickyWindow.setVisible(true);

        JButton btnListener = new JButton();
        btnListener.setText("Stick it to Board");
        stickyWindow.getContentPane().add(btnListener, BorderLayout.SOUTH);

        btnListener.addActionListener(e->{
            textArea.setText(textArea.getText() + "Sticky Note - " + editorPane.getText() + "\n");
        });

        try {
            stickyWindow.setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }

        stickyWindows.add(stickyWindow);
    }

}
