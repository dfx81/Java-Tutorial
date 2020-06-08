/* FileReader.java
 * ---------------
 * Author  : Danial Fitri (dfx81)
 * Version : 1.0
 * ---------------
 * Read a simple plaintext file
 */

// Imports
import java.util.Scanner;
import java.io.File;

// Start of class
class FileReader {
    // Main method
    public static void main(String[] args) throws Exception {
        // File operations can be considered as a risky or
        // dangerous operation. This is because there can
        // be several ways the operation can produce errors.
        // The most common error that can be encountered is
        // when the file we want to read doesn't exist.

        // We can either handle the exception or just throw
        // the exception using the throws keyword and ignore
        // it for now. In this case, we simply throws the
        // Exception.

        // Create a String that will store the name of the
        // file we want to read (Data.txt in this case).
        // Then, we create a File object that refers to our
        // file with the name stored in the String we created
        // before.
        // Finally, we passed the created File object as an
        // InputStream for our Scanner.
        final String FILE_NAME = "Data.txt";
        File file = new File(FILE_NAME);
        Scanner in = new Scanner(file);

        // From here, we can read from the file using the Scanner
        // similar to how we read input from user using the
        // System.in InputStream.
        System.out.println("Name    : " + in.nextLine());
        System.out.println("Age     : " + in.nextInt());
        System.out.println("Gender  : " + in.next());
        System.out.println("Single  : " + in.nextBoolean());
        System.out.println("CGPA    : " + in.nextDouble());
        System.out.println("---------------");
        in.nextLine(); // Take note of this extra read
        System.out.println("Hobby   : " + in.nextLine());
        in.nextLine(); // Take note of this one too
        System.out.println("F.Artist: " + in.nextLine());

        // Stop reading the file
        in.close();
    }
}

