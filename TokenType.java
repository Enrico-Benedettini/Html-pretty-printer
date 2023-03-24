/**
 * A program in a programming language is made up 
 * of different kinds of tokens.
 * This enumeration represents these different kinds.
 */
public enum TokenType {

    IDENTIFIER("identifier"),

    OPEN_ANGULAR("open angular"),
    CLOSE_ANGULAR("close angular"),
    SLASH("slash"),

    SPACE("space"),

    END_OF_FILE("");

    private final String name;
    

    /**
     * Initialize a TokenType.
     * @param name The human-readable name of this TokenType.
     */
    private TokenType(final String name) {
        this.name = name;
    }

}