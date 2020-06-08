/* HandleException.java
 * ---------------
 * Author  : Danial Fitri (dfx81)
 * Version : 1.0
 * ---------------
 * Modified FileReader program with
 * exception handling added
 */

// Imports
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

// Start of class
class HandleException {
    // Main method
    public static void main(String[] args) {
        // We can handle any error by either throwing
        // the exception away (using throws Exception at the
        // class declaration) or by catching the exception.

        // In order to catch an Exception, we use a try catch
        // block. We write the problematic codes inside the
        // try block. Any errors or Exception produced will
        // cause the catch block to be excecuted.

        // The Exception we want to catch can either be
        // specific : catch (InputMismatchException err)
        // or general: catch (Exception err)

        // Catching specific Exception will ensure that the block
        // only executes if the specific Exception occurs. You
        // must also import the Exception (unless it was from the
        // java.lang package).

        // Catch block that catch a general Exception basically
        // catch any Exception that occurs. It did not
        // require an import since it was part of java.lang package.
        try {
            final String FILE_NAME = "Data.txt";
            File file = new File(FILE_NAME);

            if (!file.exists()) throw new FileNotFoundException(FILE_NAME + " cannot be found");

            Scanner in = new Scanner(file);

            System.out.println("Name    : " + in.nextLine());
            System.out.println("Age     : " + in.nextInt());
            System.out.println("Gender  : " + in.next());
            System.out.println("Single  : " + in.nextBoolean());
            System.out.println("CGPA    : " + in.nextDouble());
            System.out.println("---------------");
            in.nextLine();
            System.out.println("Hobby   : " + in.nextLine());
            in.nextLine();
            System.out.println("F.Artist: " + in.nextLine());

            in.close();
        } catch (FileNotFoundException err) {
            // We specifically catch only the FileNotFoundException.
            // In this block, we tell the user that the file does
            // not exist. Then we print out the details about the
            // error to help us during debugging.
            System.out.println("The file probably did not exist");
            err.printStackTrace();
        } catch (InputMismatchException err) {
            // You are not limited to only one catch block. You can
            // chain these catch blocks if you have multiple Exceptions
            // to be handled.
            System.out.println("Wrong type of data read from file");
            System.out.println("File contents might have been tampered");
            err.printStackTrace();
        } finally {
            // The finally block is a special block that will execute
            // once after catch block was executed. Use this block if
            // you want something to occur after handling the Exceptions
            // in the catch blocks.

            // Take note that when we do a try catch block, we
            // can handle any errors that occur in the program during
            // runtime. Thus, the program will continue to run since
            // we handled the error.
            // Therefore, if we want the program to ends if an error
            // occurs, we must do so manually. System.exit(int exitCode)
            // will exit the program. We must pass an int that signify
            // the exit code of the program. Usually, we pass 0 as no
            // error or exiting normally, and any int other than 0 as
            // abnormal exit.
            System.exit(-1);
        }
    }
}

