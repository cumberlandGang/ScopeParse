import java.util.ArrayList;
import java.util.Iterator;

/**
 * Content is the model that represents either a scope, or just normal information.
 *
 * For an example, take this one-line representation of a class:
 *
 * public class myClass{int x; myClass(){doSomething();}}
 *
 * This would be represented within ScopeParse as
 * [
 * Literal<char>("public class myClass"),
 * Scope<char>(
 *   [Literal<char>("int x; myClass()"),
 *   Scope<char>(
 *     [Literal<char>("doSomething();")
 * ;
 */
public class Content<T> {

    protected ArrayList<Content<T>> innerElements;


    public Content() {
        innerElements = new ArrayList<>();
    }

    public Content(ArrayList<Content<T>> list) {
        innerElements = list;
    }


    public int getContentLength(){
        return innerElements.size();
    }

    public void add(Content<T> content) {
        innerElements.add(content);
    }

    public Iterator<Content<T>> getIterator() {
        return innerElements.iterator();
    }


}
