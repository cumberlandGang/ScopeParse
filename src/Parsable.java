import java.util.Collection;

/**
 * Parsable objects are able to turn a collection into their model, using information about what is being parsed.
 */
public interface Parsable<T> {
     public Content parseFrom(Collection<T> content, T left, T right);
}
