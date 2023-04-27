package src.htmlparser;

import static org.junit.Assert.*;

import src.htmlparser.parser.Parser;
import src.node.Node;
import src.node.composedtag.ComposedTag;
import src.node.composedtag.tags.Body;
import src.node.composedtag.tags.Div;
import src.node.composedtag.tags.Header;
import src.node.composedtag.tags.Html;
import src.node.composedtag.tags.P;
import src.node.Content;
import src.node.Img;
import org.junit.Test;

/**
 * Test parseCode.
 */
public class HtmlParserTest {
    
    @Test
    public void parseCodeNotEmptyTest() {
        // setup
        final Parser parser = new HtmlParser();
        // test input
        final String sourceCode = "<html></html>";
        // code under test
        final ComposedTag actualRoot = parser.parse(sourceCode);
        // expected tree
        final ComposedTag expectedRoot = new Html();
        // assertion
        assertEquals(expectedRoot.toString(0), actualRoot.toString(0));
        System.out.println(actualRoot.toString(0) + "\n");
    }

    @Test
    public void parsePTest() {
        // setup
        final Parser parser = new HtmlParser();
        // test input
        final String sourceCode = "<html><img>hi this is a c</html>";
        // code under test
        final ComposedTag actualRoot = parser.parse(sourceCode);
        // expected tree
        final ComposedTag expectedRoot = new Html();
        final Img expectedChildren1 = new Img();
        final Content expectedChildren2 = new Content("hi this is a c");
        expectedRoot.addChildren(expectedChildren1);
        expectedRoot.addChildren(expectedChildren2);
        // assertion
        assertEquals(expectedRoot.toString(0), actualRoot.toString(0));
        System.out.println(actualRoot.toString(0) + "\n");
    }

    @Test
    public void parseHtmlCompositeTest() {
        // setup
        final Parser parser = new HtmlParser();
        // test input
        final String sourceCode = "<html><body><div><header><p></p></header></div></body></html>";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final ComposedTag expectedRoot = new Html();
        // expected root
        final ComposedTag expectedChildren = new Body();
        final ComposedTag expectedSecondChildren = new Div();
        final ComposedTag expectedThirdChildren = new Header();
        final ComposedTag expectedThirdChildren1 = new P();
        expectedRoot.addChildren(expectedChildren);
        expectedChildren.addChildren(expectedSecondChildren);
        expectedSecondChildren.addChildren(expectedThirdChildren);
        expectedThirdChildren.addChildren(expectedThirdChildren1);
        // assertion
        assertEquals(expectedRoot.toString(0), actualRoot.toString(0));
        System.out.println(actualRoot.toString(0) + "\n");
    }

    @Test
    public void parseCheckError() {
        final Parser parser = new HtmlParser();
        final String sourceCodeError = "<html><head><body></head></html>";
        final Node actualRoot = parser.parse(sourceCodeError);
        assertEquals(null, actualRoot);
    }
}
