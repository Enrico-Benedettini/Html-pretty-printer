/**
 * An image Tag Node.
 */
public class Img implements Node {

    private String src;

    /**
     * The constructor of class Img if it hasn't a src parameter.
     */
    public Img() {
        src = null;
    }
    
    /**
     * The constructor of class Img.
     * @param src a String representing the source
     */
    public Img(final String src) {
        this.src = src;
    }

    /**
     * The type getter of class Img.
     * @return the Type of an Img Node
     */
    public Type getType() {
        return Type.TAG;
    }

    @Override
    public String toString(final int levelCounter) {
        return "<img src = " + "\"" + src + "\">";
    }

    public int count() {
        return 1;
    }
}