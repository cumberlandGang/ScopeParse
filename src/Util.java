import java.util.ArrayList;
import java.util.Collection;

/**
 * ScopeParse has no external dependencies outside of the Java Standard Library,
 * and a few one-off functions. These functions will wind up in the Util class.
 * @author Nathaniel Pisarski <nathanpisarski@gmail.com>
 */
public class Util {

    /**
     * Wraps an item in an ArrayList. This is useful for recursive functions that need to return
     * a single value from a tail-recursive function
     * @param toWrap The item to wrap
     * @param <T> The type of the item
     * @return The item, as the sole element of an arraylist
     */
    public static <T> ArrayList<T> wrap(T toWrap) {
        ArrayList<T> wrapper = new ArrayList<>(1);
        wrapper.add(toWrap);

        return wrapper;
    }

    /**
     * Concatenate two collections together into one ArrayList object
     * @param list1 The first part of the list
     * @param list2 The second part of the list
     * @param <T> The type of the list
     * @return The list, with list1 being in the beginning of the list, and list2 at the end.
     */
    public static <T> ArrayList<T> concatenate(Collection<T> list1, Collection<T> list2) {
        ArrayList<T> temp = new ArrayList<T>();

        temp.addAll(list1);
        temp.addAll(list2);

        return temp;
    }

    // For some reason, variadic arguments were not resolving the identifier properly here, so I need to overload.
    // Will investigate. TODO
    public static <T> ArrayList<T> concatenate(Collection<T> list1, Collection<T> list2, Collection<T> list3) {
        ArrayList<T> temp = new ArrayList<T>();

        temp.addAll(list1);
        temp.addAll(list2);
        temp.addAll(list3);

        return temp;
    }

    public static <T> gen
}
