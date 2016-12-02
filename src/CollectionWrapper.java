import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collector;

/**
 * Because, for some reason, Strings and Arrays are both not subclasses of Collection<E>, neither the FlatParser nor the
 * Scope classes are able to accept an Array. This is troublesome for arrays themselves,
 * but it is also troublesome for Strings. If Strings were Collections, this would be
 * a solved problem. If Arrays were Collections, we could simply use String.toCharArray().
 *
 * We, however, live in an imperfect world. At least when we write Java. (I'm about to go off. Anger rising.
 * C# solved this problem in 200, the fuck, 3. IEnumerable is TRULY the base class of everything that can be
 * used in a for loop in the language. We can overload the indexing operator. It's like... C# is this perfect
 * life. It's like I was an orphan that got adopted by this great family who had to move out of the country,
 * and now I live with the crack addict. Java is the crack addict in this case).
 */
public class CollectionWrapper<T> implements Collection<T> {

    public class StringWrapper
        public static CollectionWrapper<Character> GetStringWrapper(String string){
            return new CollectionWrapper<Character>(string.toCharArray());
        }
    }

    private ArrayList<T> innerCollection;

    public CollectionWrapper(T[] array)
    {

    }

    @Override
    public int size() {
        return innerCollection.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        // An 11 on Moh's scale
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
