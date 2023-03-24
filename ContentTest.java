import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class ContentTest.
 */
public class ContentTest
{
    
    @Test
    public void testContent() {
        final Content c = new Content("this paragraph is a paragraph");
        assertEquals(Type.TAG, c.getType());
        assertEquals("this paragraph is a paragraph", c.toString(0));
    }
}
