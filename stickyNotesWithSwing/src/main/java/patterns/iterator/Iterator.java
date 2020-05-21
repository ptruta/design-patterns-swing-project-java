package patterns.iterator;

// We could also use Java.Util.Iterator
public interface Iterator
{
    // indicates whether there are more elements to
    // iterate over
    boolean hasNext();

    // returns the next element
    String next();

    // to return the actual string
    String getActual();

    void setPos();
}