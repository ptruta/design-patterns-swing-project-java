import patterns.observer.ObserverPattern;
import patterns.prototype.PrototypeCache;
import patterns.factory.CreateStickyFactory;
import patterns.iterator.StickyIterator;
import patterns.state.Context;
import patterns.state.StartState;
import patterns.state.StopState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class StickyWindow {
    static StickyIterator stickyIterator = new StickyIterator();
    static JInternalFrame stickyWindow = new JInternalFrame();
    static JDesktopPane desktopPane;
    private JFrame frmStickiwindou;
    private CreateStickyFactory stickyFactory = new CreateStickyFactory();
    static List<JInternalFrame> stickyWindows = new ArrayList<>();
    static JTextArea textArea = new JTextArea();
    static JButton listenerButton = new JButton();
    private PrototypeCache prototypeCache = new PrototypeCache();

    public StickyWindow() {
        initialize();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            try {
                StickyWindow window = new StickyWindow();
                window.frmStickiwindou.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }

        });

    }

    private void initialize() {
        frmStickiwindou = new JFrame();
        frmStickiwindou.setTitle("Stick Notes");
        frmStickiwindou.setBounds(100, 100, 900, 1024);
        frmStickiwindou.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        desktopPane = new JDesktopPane();

        JInternalFrame intFrame = new JInternalFrame("Shape of Stickies we used", true, true, true, true);
        desktopPane.add(intFrame);
        desktopPane.setBackground(Color.gray);
        intFrame.setBounds(0, 0, 200, 200);
        listenerButton.setText("Shape of Stickies we used");
        intFrame.add(listenerButton, BorderLayout.AFTER_LAST_LINE);
        intFrame.setVisible(true);

        JTextArea jTextArea = new JTextArea();
        JTextArea jTextArea1 = new JTextArea();
        prototypeCache.choosePrototype(jTextArea, jTextArea1);
        jTextArea.setVisible(true);
        intFrame.add(jTextArea, BorderLayout.EAST);
        intFrame.add(jTextArea1, BorderLayout.WEST);

        JInternalFrame intFrame1 = new JInternalFrame("Observable", true, true, true, true);
        desktopPane.add(intFrame1);
        desktopPane.setBackground(Color.gray);
        intFrame1.setBounds(490, 400, 400, 200);
        textArea.disable();
        textArea.setDisabledTextColor(Color.BLACK);
        intFrame1.add(textArea, BorderLayout.CENTER);
        intFrame1.setVisible(true);

        frmStickiwindou.getContentPane().add(desktopPane, BorderLayout.CENTER);

        JPopupMenu popupMenuForSelection = new JPopupMenu();
        addPopup(desktopPane, popupMenuForSelection);

        JButton btnMenuSelectRectangle = new JButton("Rectangle");
        JButton btnMenuSelectSquare = new JButton("Square");
        JButton btnCreateChildRectangleSticky = new JButton("Rectangle Child");
        JButton btnCreateChildSquareSticky = new JButton("Square Child");
        JButton btnCloseAll = new JButton("Close All");

        popupMenuForSelection.add(btnMenuSelectRectangle);
        popupMenuForSelection.add(btnMenuSelectSquare);
        popupMenuForSelection.add(btnCreateChildSquareSticky);
        popupMenuForSelection.add(btnCreateChildRectangleSticky);
        popupMenuForSelection.add(btnCloseAll);

        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(btnMenuSelectRectangle,
                btnMenuSelectSquare,
                btnCreateChildSquareSticky,
                btnCreateChildRectangleSticky,
                btnCloseAll,
                context,
                stickyFactory,
                stickyIterator,
                stickyWindow,
                desktopPane,
                stickyWindows,
                textArea);

        ObserverPattern observerPattern = new ObserverPattern();
        observerPattern.observable(textArea, "Application Start");

        System.out.println(context.getState().toString());

        stickyIterator = new StickyIterator();

        StopState stopState = new StopState();
        stopState.doAction(btnMenuSelectRectangle,
                btnMenuSelectSquare,
                btnCreateChildSquareSticky,
                btnCreateChildRectangleSticky,
                btnCloseAll,
                context,
                stickyFactory,
                stickyIterator,
                stickyWindow,
                desktopPane,
                stickyWindows,
                textArea);

        System.out.println(context.getState().toString());

        desktopPane.putClientProperty("JDesktopPane.dragMode", "outline");
    }
}