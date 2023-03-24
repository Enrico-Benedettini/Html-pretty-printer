/**
 * A token is a contiguous sequence of characters in a html-like text.
 */
public final class Token {

    private final TokenType type;
    private final String text;

    
    /**
     * Create a new Token.
     * @param type the kind of token
     * @param text the contents (characters) making up the token
     */
    public Token(final TokenType type, final String text) {
        this.type = type;
        this.text = text;
    }

    /**
     * Get the type of this token.
     * @return the kind of token this is
     */
    public TokenType getType() {
        return type;
    }

    /**
     * Get the text making up this token.
     * @return the contents of this token
     */
    public String getText() {
        return text;
    }

}