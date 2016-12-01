import java.util.ArrayList;
import java.util.Collection;

/**
 * The FlatParser is the base of the ScopeParse library. It provides the functions required to parse various text into
 * scopes. This includes a flat analysis of a stream of information, which can provide the base collections where
 * the actual models are built from.
 * @author Nathaniel Pisarski
 */
public class FlatParser {

    /**
     * Analyzes a list, and returns the part of the collection which occurs before the delimiter, not including it.
     * @param information The total information from the list
     * @param delim The delimiter. In the context of parsing, this is usually the left delimiter.
     * @param <T> The type of the collection
     * @return Only the part of the collection before the delimiter.
     */
    public static  <T> Collection<T> untilNextDelimiter(Collection<T> information, T delim) {
        ArrayList<T> collected = new ArrayList<T>();

        for(T item : information) {
            if(item.equals(delim))
                break;

            collected.add(item);
        }

        return collected;
    }

    /**
     * This will return the information on the same level as this after the next scope
     * @param information The total information in the list.
     * @param left The left delimiter
     * @param right The right delimiter
     * @param <T> The type of the list
     * @return All of the content (regardless of whether or not it's scoped) after the next full scope.
     */
    public static <T> Collection<T> afterNextScope(Collection<T> information, T left, T right)
    {
        ArrayList<T> collection = new ArrayList<T>();
        short delimiterCount = 0;

        boolean collecting = false;

        for(T item : information) {

            // If we're collecting, we want the rest of the list.
            if(collecting) {
                collection.add(item);
                continue;
            }

            if(item.equals(left))
                delimiterCount++;

            // See: Comment over similar conditional in `withinDelim`
            if(item.equals(right) && delimiterCount > 0)
                if(delimiterCount-- == 0)
                    collecting = true;
        }

        return collection;
    }

    /**
     * Analyze the information in the collection. This will return all of the information inside one level
     * of the delimiter. For instance, in the nested structure
     *
     * this{is{a{structure}}},
     *
     * would give back is{a{structure}} when called with ('{', '}') being the left and right delimiters.
     * @param information The total information from the list
     * @param left The left delimiter in the list
     * @param right The right delimiter in the list
     * @param <T> The type of the list
     * @return The information inside of the delimiters
     */
    public static <T> ArrayList<ArrayList<T>> withinDelim(Collection<T> information, T left, T right) {

        // How many delimiters deep are we?
        short delimCount = 0;

        // What is in this current scope?
        ArrayList<T> collectionPass = new ArrayList<T>();

        // What are the scopes in the information?
        ArrayList<ArrayList<T>> collection = new ArrayList<>();

        for(T item : information) {

            if(item.equals(left))
                delimCount++;

            /*
            * A couple notes about this conditional. The delim count should never go below 0 (although it can exceed
            * as high as the short limit), since "thing{yo}} thing{yo}" should process as "yoyo", no matter how improper
            * the form is. Additionally, this is not dependant on it NOT being the left delimiter, even though it's the
            * check for the right one. In a situation where the left and right delimiter are the same, this entire
            * function will simply do nothing, but still run.
             */
            if(item.equals(right) && delimCount > 0)

                // If the delim count was counting before, but it's 0 now, push what we have to the collection.
                if(delimCount-- == 0) {
                    collection.add(collectionPass);
                    collectionPass = new ArrayList<>();
                }

            if(delimCount > 0)
                collectionPass.add(item);
        }

        return collection;
    }
}
