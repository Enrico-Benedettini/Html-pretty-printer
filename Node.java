/**
 * An abstract syntax tree (AST) node.
 */
public interface Node {

    /**
     * Get the type of values produced by this node.
     * @return the type of this node
     */
    public abstract Type getType();

    /**
     * Decompile this node into a string.
     * Note that the resulting string may have
     * extra parentheses.
     * @param levelCounter the level of indentation of this Node
     * @return a String representation of this AST
     */
    public abstract String toString(final int levelCounter);
    
    public abstract int count();
}