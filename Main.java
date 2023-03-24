import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStream;
import java.util.Scanner;

/**
 * Main class to make the program work.
 */
public class Main
{

    /**
     * The Main method.
     * @param args the args
     */
    public static void main(final String[] args)
    {
        try {
            final File iStream = new File(args[0]);
            final Scanner myReader = new Scanner(iStream);
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
        
            final HtmlParser parser = new HtmlParser();
            final Node code = parser.parse(data);
            final String fixedCode = code.toString(0);
            System.out.println(fixedCode);
            
            writeCodeIntoFile(fixedCode);
        } catch (FileNotFoundException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }
        
    }
    
    /**
     * Method to write into a file the code.
     * @param fixedCode the fixedCode String to write into the file
     */
    private static void writeCodeIntoFile(final String fixedCode) {
        try {
            File oStream;
            boolean didIt = false;
            do {
                if (!didIt) {
                    System.out.println("Insert a valid file name");
                } else {
                    System.out.println("Damn bro, insert a valid file name!");
                }
                final Scanner reader = new Scanner(System.in);
                final String fileName = reader.nextLine();
                oStream = new File(fileName);
                didIt = true;
            } while (!oStream.createNewFile());
            
            System.out.println("File created: " + oStream.getName());
            
            try {
                final FileWriter myWriter = new FileWriter(oStream.getName());
                myWriter.write(fixedCode);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException exception) {
                System.out.println("An error occurred.");
                exception.printStackTrace();
            }
        } catch (IOException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }
    }
}
