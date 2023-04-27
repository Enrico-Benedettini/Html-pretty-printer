package src.node.composedtag;

import src.node.Node;
import src.Type;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An HTML Tag Node.
 * @author Enrico Benedettini and Alessandro Cravioglio
 */
public class ComposedTag implements Node {

    /* 
     contains children, they all are the html-like text
     that should be moved to the left of the tag. 
    */

    private ArrayList<Node> children;

    /**
     * the constructor of the tag class.
     */
    public ComposedTag() {
        children = new ArrayList<Node>();
    
    }

    /**
     * check the type of the tag.
     * @return the type of the tag
     */
    public Type getType() {
        return Type.COMPOSED_TAG;
    }

    /**
     * Add a new ComposedTag child to this Tag.
     * @param child the ComposedTag child to be added
     */
    public void addChildren(final Node child) {
        children.add(child);
    }
    
    /**
     * Transpose to string the tag and his childs as in html txt.
     * @param levelCounter checks the level of indentation of the tag
     * @return a string containing the opening tag, the childrens and
     *         the closing tag
     */
    @Override
    public String toString(final int levelCounter) {

        String tabCounterString = "";

        for (int i = 0; i < levelCounter; i++) {
            tabCounterString += "  ";
        }
        return "<" + this.toString() + ">" + "\n" + prettyPrintChildren(levelCounter) 
                + tabCounterString + "</" + this.toString() + ">";    
    }

    /**
     * Checks the level of indentation of the children and transpose them
     * to string as correct html source code with the right level of indentation.
     * @param levelCounter the level of indentation of the current tag
     * @return a string containing the correctly inentated html source code
     */
    private String prettyPrintChildren(final int levelCounter) {

        String result = "";
        String tabCounterString = "  ";
        
        if (levelCounter >= 1) {
            for (int i = 0; i < levelCounter; i++) {
                tabCounterString += "  ";
            }
        }

        /*for (final Node n : children) {
            result += tabCounterString + n.toString(levelCounter + 1) + "\n";
        }*/
        /*for (int i = 0; i < children.size(); i++) {
            result += tabCounterString + children.get(i).toString(levelCounter + 1) + "\n";
        }*/
        Iterator<Node> it = children.iterator();
        while (it.hasNext()) {
            final Node children = it.next();
            result += tabCounterString + children.toString(levelCounter + 1) + "\n";
        }
        return result;
    }
    
    public int count() {
        return countLevels(1);
    }
    
    private int countLevels(final int levelCounter) {
        int maximum = levelCounter;
        for (Node n : children) {
            final int count = countLevels(levelCounter + 1);
            if (count > maximum) {
                maximum = count;
            }
        }
        return maximum;
    }
}
