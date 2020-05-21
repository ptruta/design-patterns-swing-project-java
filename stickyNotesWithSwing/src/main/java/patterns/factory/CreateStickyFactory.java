package patterns.factory;


import patterns.prototype.Sticky;
import patterns.StickyRectangle;
import patterns.StickySquare;

public class CreateStickyFactory {

    public Sticky getSticky(String planType) {
        if (planType == null) {
            return null;
        }
        if (planType.equals("rectangle")) {
            return new StickyRectangle();
        } else if (planType.equals("square")) {
            return new StickySquare();
        }
        return null;
    }
}