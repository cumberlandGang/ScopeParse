import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Unit Testing for the FlatParser
 */
public class FlatParserTest {

    @Test
    public void untilNextDelimiter() throws Exception {
        ArrayList<Character> original = new ArrayList<>();
        ArrayList<Character>
        for (Character c: "this is a str{ing}".toCharArray()) {
            .add(c);
        }

       Assert.assertEquals(
               "this is a str".toCharArray(),
               FlatParser.untilNextDelimiter(
                       new ArrayList<Character>("this is a str{ing}".toCharArray()),
                       '{',
                       '}'
               )
       );
    }

    @Test
    public void afterNextScope() throws Exception {

    }

    @Test
    public void withinDelim() throws Exception {

    }

}