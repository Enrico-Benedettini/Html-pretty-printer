import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IdentifierTokenFactoryTest {
    
       
    @Test
    public void testFoundLength1() {
        IdentifierTokenFactory f = new IdentifierTokenFactory();
        f.setText("<html>");
        boolean found = f.find(1);
        assertTrue(found);
        assertEquals("html", f.getTokenText());
        assertEquals(TokenType.IDENTIFIER, f.getToken().getType());
    }
    
    @Test
    public void testFoundLength3() {
        IdentifierTokenFactory f = new IdentifierTokenFactory();
        f.setText("body");
        boolean found = f.find(0);
        assertTrue(found);
        assertEquals(4, f.getTokenLength());
        assertEquals(0, f.getTokenStartPosition());
        assertEquals("body", f.getTokenText());
        assertEquals(TokenType.IDENTIFIER, f.getToken().getType());
    }
    
    @Test
    public void testNoMatchNotFound() {
        IdentifierTokenFactory f = new IdentifierTokenFactory();
        f.setText("123=456");
        boolean found = f.find(4);
        assertFalse(found);
    }

}
