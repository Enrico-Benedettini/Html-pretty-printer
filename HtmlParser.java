/**
 * The Html parser class.
 * @author Enrico Benedettini and Alessandro Cravioglio
 */
public class HtmlParser implements Parser {
    
    private LexicalAnalyzer lexer;
    
    /**
     * Parse a program in the Html language.
     * @param sourceCode The source code of the program in the Html language
     * @return an AST of the program
     */
    public ComposedTag parse(final String sourceCode) {
        this.lexer = new LexicalAnalyzer(sourceCode);
        // fetch first token
        lexer.fetchNextToken();
        // now parse the Code
        return parseComposedTag();
    }

    /**
     * Parse the Img Tag.
     * @return the img Node
     */
    private Img parseImg() {
        // TODO: understand how to parse attributes
        return new Img();
    }

    /**
     * Parse the content of a Tag, the content is
     * the children of a Tag without children.
     * @return a Content Node
     */
    private Content parseContent() {
        String content = "";
        while (lexer.getCurrentToken().getType() != TokenType.OPEN_ANGULAR) {
            content += lexer.getCurrentToken().getText();
            lexer.fetchNextToken();
        }
        return new Content(content);
    }

    /**
     * The ComposedTag parser. Every new Node that's being parsed can
     * be either a composedTag or other Nodes.
     * Here the ComposedTags are parsed and created.
     * The resulting ComposedTag is a simple html Node, with all the 
     * children that depends from that.
     * @return a ComposedTag representing the contained code
     */
    private ComposedTag parseComposedTag() {
        final ComposedTag code = processFirstPart();
        lexer.fetchNextToken();
        // this should add all the children Nodes
        // How to do with Nodes that aren't children of code?
        int next = checkNext();
        while (next != 1) {
            if (next == 0) {
                if (lexer.getCurrentToken().getText().equals("img")) {
                    code.addChildren(parseImg());
                    lexer.fetchNextToken();
                    lexer.fetchNextToken();
                } else {
                    final ComposedTag tag = parseComposedTag();
                    if (tag != null) {
                        code.addChildren(tag);
                    } else {
                        return null;
                    }
                }
            } else {
                code.addChildren(parseContent());
            }
            next = checkNext();
        }
        lexer.fetchNextToken();
        final String myName = code.toString();
        if (!myName.equals(lexer.getCurrentToken().getText())) {
            System.out.println("Tag " + myName + " not closed, given "
                + lexer.getCurrentToken().getText());
            lexer.fetchNextToken();
            lexer.fetchNextToken();
            return null;
        }
        lexer.fetchNextToken();
        lexer.fetchNextToken();
        
        return code;
    }
    
    /**
     * Method to process the first part of the Composed Tag.
     * @return the processed tag produced by the first half of a
     *         ComposedTag
     */
    public ComposedTag processFirstPart() {
        ComposedTag code = null;
        while (lexer.getCurrentToken().getType() != TokenType.CLOSE_ANGULAR) {
            final TokenType tokenType = lexer.getCurrentToken().getType();
            if (tokenType == TokenType.OPEN_ANGULAR) {
                lexer.fetchNextToken();
            } else {
                final String myName = lexer.getCurrentToken().getText();
                if ("html".equals(myName)) {
                    code = new Html();
                } else if ("head".equals(myName)) {
                    code = new Head();
                } else if ("div".equals(myName)) {
                    code = new Div();
                } else if ("body".equals(myName)) {
                    code = new Body();
                } else if ("header".equals(myName)) {
                    code = new Header();
                } else {
                    code = new P();
                }
                lexer.fetchNextToken();
            }
        }
        return code;
    }
    
    /**
     * Method to know the type of the next node.
     * @return one of 0,1,2 for Open tag, closed tag and content
     */
    private int checkNext() {
        if (lexer.getCurrentToken().getType() == TokenType.OPEN_ANGULAR) {
            lexer.fetchNextToken();
            if (lexer.getCurrentToken().getType() == TokenType.SLASH) {
                return 1;
            } else {
                return 0;
            }
        }
        return 2;
    }
}
