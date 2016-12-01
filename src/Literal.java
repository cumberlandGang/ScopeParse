import java.util.ArrayList;
import java.util.Collection;

/**
 * Literals are pieces of information present within a scope that are not scopes themselves. See "Content" for a
 * breakdown of the difference between a Literal and a Scope.
 * @author Nathaniel Pisarski
 */
public class Literal<T> extends Content<T> implements Parsable<T> {

    public Collection<T> value;

    public Literal(T left, T right){ super();}

    public Literal(T left, T right, Collection<T> information) {
        this(left, right);
        value = information;

        innerElements.add(this);
    }

    public Literal<T> parseFrom(Collection<T> content, T left, T right){
        if(innerElements.size() > 0)
            innerElements = new ArrayList<Content<T>>();

        if(content.contains(left) || content.contains(right))
            System.out.println("[Warning]: " + "delimiter found in Literal content. Assuming escaped.");

        value = content;
        innerElements.add(this);

        return this;
    }
}
