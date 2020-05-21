package patterns.prototype;

import javax.swing.*;

public class PrototypeCache {

    public void choosePrototype(JTextArea textArea, JTextArea textArea1) {
        StickyCache.loadCache();

        Sticky clonedShape = StickyCache.getSticky("1");
        System.out.println("Sticky : " + clonedShape.getType());
        textArea.setText("Sticky : " + clonedShape.getType() + "\n");

        Sticky clonedShape2 = StickyCache.getSticky("2");
        System.out.println("Sticky : " + clonedShape2.getType());
        textArea1.setText("Sticky : " + clonedShape2.getType() + "\n");
    }
}
