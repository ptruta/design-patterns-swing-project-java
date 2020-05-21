package patterns.prototype;

import patterns.StickyRectangle;
import patterns.StickySquare;

import java.util.Hashtable;

public class StickyCache {

        private static Hashtable<String, Sticky> stickyMap = new Hashtable<String, Sticky>();

        public static Sticky getSticky(String stickyId) {
            Sticky cachedSticky = stickyMap.get(stickyId);
            return (Sticky) cachedSticky.clone();
        }

        public static void loadCache() {
            StickyRectangle stickyRectangle = new StickyRectangle();
            stickyRectangle.setId("1");
            stickyMap.put(stickyRectangle.getId(),stickyRectangle);

            StickySquare stickySquare = new StickySquare();
            stickySquare.setId("2");
            stickyMap.put(stickySquare.getId(),stickySquare);
        }
}
