package src.node.composedtag;

import static org.junit.Assert.*;

import src.node.Node;
import src.node.composedtag.tags.Body;
import src.node.composedtag.tags.Div;
import src.node.composedtag.tags.Head;
import src.node.composedtag.tags.Header;
import src.node.composedtag.tags.Html;
import org.junit.Test;
import src.Type;

/**
 * Test getType, toString and prettyPrintChildren
 * of composedTag subclasses.
 */
public class ComposedTagTest {
    
    @Test
    public void testComposedTag() {
        Node e = new Html();
        assertEquals(Type.COMPOSED_TAG, e.getType());
        assertEquals("<html>"+"\n"+"</html>", e.toString(0));

    }

    @Test
    public void testChild() {
        ComposedTag e = new Html();
        ComposedTag f = new Head();
        ComposedTag g = new Body();
        ComposedTag h = new Header();
        ComposedTag i = new Div();
        h.addChildren(i);
        g.addChildren(h);
        assertEquals("<body>\n  <header>\n    <div>\n    </div>\n  </header>"
                     + "\n</body>",g.toString(0));
        assertEquals(Type.COMPOSED_TAG, e.getType());
        assertEquals("<html>\n</html>", e.toString(0));
        e.addChildren(f);
        assertEquals("<html>\n  <head>\n  </head>\n</html>", e.toString(0));
        e.addChildren(g);
        assertEquals("<html>\n  <head>\n  </head>\n  <body>\n    <header>\n"
                     + "      <div>\n      </div>\n    </header>\n  </body>"
                     + "\n</html>",e.toString(0));
    }
        
}