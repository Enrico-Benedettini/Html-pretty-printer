/**
 * A Content Node, the content of a Composed 
 * Tag.
*/ 
public class Content implements Node {
    
    private final String content;

    /**
     * Create a new Variable.
     * @param content the name of the Variable
    */     
    public Content(final String content) {
        super();
        this.content = content;
    }

    @Override
    public Type getType() {
        return Type.TAG;
    }

    @Override
    public String toString(final int levelCounter) {
        return content;
    }
}
