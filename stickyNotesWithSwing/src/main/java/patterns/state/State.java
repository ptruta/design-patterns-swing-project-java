package patterns.state;

import patterns.factory.CreateStickyFactory;
import patterns.iterator.StickyIterator;

import javax.swing.*;
import java.util.List;

public interface State {
    void doAction(JButton btnMenuSelectRectangle,
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
                  JTextArea textArea);
}