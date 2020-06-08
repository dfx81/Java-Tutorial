/* FileWriter.java
 * ---------------
 * Author  : dfx
 * Version : 1.0
 * ---------------
 * A simple program that write data
 * into file
 */

// Imports
import java.io.PrintWriter;
import java.io.File;

// Start of class
class FileWriter {
    // Start of main method (we don't want to handle exception so just
    // use throws
    public static void main(String[] args) throws Exception {
        // Create a file object with the name Edit.txt
        // If the file did not exist, we create an empty file
        // with the same name.
        final String FILE_NAME = "Edit.txt";
        File file = new File(FILE_NAME);
        if (!file.exists()) file.createNewFile();

        // Create a PrintWriter that writes into the created file as
        // target.
        PrintWriter out = new PrintWriter(file);

        // Now we can start writing into the file. How do you that?
        // One look below and you might know how to do that.
        // It should be really familiar to you.
        out.println("Danial Fitri");
        out.print("\t" + 20);
        out.print("\tM\n");
        out.print(true + "\t");
        out.println(3.79);
        out.println("Coding, Reading Novels, Drawing, & Listening to Music\n");
        out.println("Panic! at The Disco, Fall Out Boys, 米津玄師, DECO*27, ヨルシカ, & ヒトリエ");

        // Unnecessary but it's good to learn now. PrintWriter.flush() is used to
        // write to the file IMMEDIATELY. Good if you're writing over the
        // internet or something where it's easy for data to be lost.
        out.flush();

        // Stop writing and save the file.
        out.close();
    }
}
