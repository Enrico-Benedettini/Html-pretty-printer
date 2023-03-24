import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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