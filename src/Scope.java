import java.util.ArrayList;
import java.util.Collection;

/**
 * A Scope is a tree of scopes, which is gained when parsing information. It contains any information about the curent
 * level of information being parsed, as well as any internal scopes.
 * @author Nathaniel Pisarski
 */
public class Scope<T> extends Content<T> implements Parsable<T> {

    public Scope()
    {
        innerElements = new ArrayList<Content<T>>();
    }

    /**
     * Scope.parseFrom will read the content, in search of the delimiters. From this, it will attempt to build the model
     * from both the content and the scope, using recursive-descent.
     * @param content The content, which may contain many nested structures, and content after the scope
     * @param left The left delimiter in this case
     * @param right The right delimiter in this case
     */
    public Content<T> parseFrom(Collection<T> content, T left, T right) {
        /*
        Ideally, this function is going to be getting information that looks something like this:

        obj1{obj2}moreinfo

        So, the strategy for parsing something like this is to make a data structure with the representation:

        [Literal("obj1"), Scope([Literal("obj2")]), Content("moreinfo")]

        So we parse everything up to a delimiter, parse everything within the delimiters, and then everything after it
         */

        // Get all current information
        Literal<T> literal = new Literal<T>(
                left,
                right,
                FlatParser.untilNextDelimiter(content, left));


        // We are at the end of the statement to parse, just return the literal
        if(literal.value.size() == content.size())
            return literal;
        else {
            Scope<T> scopedElement = new Scope();
            Scope<T> rest = new Scope();


            // If there is more content other than the literal, we have to parse the inner elements and outer elements
            return new Content<>(
                    Util.concatenate(
                            Util.wrap(literal),

                            Util.wrap(scopedElement.parseFrom(
                                            FlatParser.withinDelim(content, left, right).get(0),
                                            left, right)),

                            Util.wrap(rest.parseFrom(
                                    FlatParser.afterNextScope(content, left, right),
                                    left, right))
                    )
            );

        }
    }
}
