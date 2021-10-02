package parser;


import com.altshuler.JnetWorksTestTask.parser.PageParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PageParserTest {
    PageParser pageParser = new PageParser();

    @Test
    public void parseToReducedForm() {
        String test1 = "1,2,3,.....";
        assertNull(pageParser.parseToReducedForm(test1));
        String test2 = "1,2,3";
        assertEquals("1-3", pageParser.parseToReducedForm(test2));
        String test3 = "1";
        assertEquals("1", pageParser.parseToReducedForm(test3));
        String test4 = "1,4,5,6,7,8,11";
        assertEquals("1,4-8,11", pageParser.parseToReducedForm(test4));
        String test5 = "3,4,6";
        assertEquals("3-4,6", pageParser.parseToReducedForm(test5));
        String test6 = "2,5,6,7,8";
        assertEquals("2,5-8", pageParser.parseToReducedForm(test6));
        String test7 = "5,2,7,6,10,9,8";
        assertEquals("2,5-10", pageParser.parseToReducedForm(test7));
        String test8 = "1,7,8,14,16";
        assertEquals("1,7-8,14,16", pageParser.parseToReducedForm(test8));
        String test9 = "00";
        assertNull(pageParser.parseToReducedForm(test9));
        String test10 = "9,14,15,16,13,8,7";
        assertEquals("7-9,13-16", pageParser.parseToReducedForm(test10));
    }

}
