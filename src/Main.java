package src;

import src.htmlparser.HtmlParser;
import src.node.Node;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter data: ");
            String data = "";
            try {
                data =  reader.readLine();
                System.out.println("data: " + data);
            } catch (java.io.IOException exception) {
                System.out.println("Couldn't read input");
            }

            HtmlParser parser = new HtmlParser();
            Node code = parser.parse(data);
            String fixedCode = code.toString(0);
            System.out.println(fixedCode);
            writeCodeIntoFile(fixedCode);
        } catch (NullPointerException var7) {
            System.out.println("An error occurred.");
            var7.printStackTrace();
        }

    }

    private static void writeCodeIntoFile(String fixedCode) {
        try {
            boolean didIt = false;

            File oStream;
            do {
                if (!didIt) {
                    System.out.println("Insert a valid file name");
                } else {
                    System.out.println("Damn bro, insert a valid file name!");
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                String fileName = "";
                try {
                    fileName =  reader.readLine();
                } catch (java.io.IOException exception) {
                    System.out.println("Couldn't read input");
                }
                oStream = new File(fileName);
                didIt = true;
            } while(!oStream.createNewFile());

            System.out.println("File created: " + oStream.getName());

            try {
                FileWriter myWriter = new FileWriter(oStream.getName());
                myWriter.write(fixedCode);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException var5) {
                System.out.println("An error occurred.");
                var5.printStackTrace();
            }
        } catch (IOException var6) {
            System.out.println("An error occurred.");
            var6.printStackTrace();
        }

    }
}
