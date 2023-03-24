import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class ImgTest.
 */
public class ImgTest
{
    @Test
    public void imgTest()
    {
        final Img img = new Img();
        assertEquals("<img src = \"null\">", img.toString(0));
    }

    @Test
    public void getTypeTest()
    {
        final Img img = new Img("ciao.jpg");
        assertEquals(Type.TAG, img.getType());
        assertEquals("<img src = \"ciao.jpg\">", img.toString(0));
    }
}
