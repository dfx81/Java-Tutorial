# HandleException.java

## Documentation

### Implementation

The program is simply the edited version of the FileReader.java.
Instead of simply throwing the Exception that occurs, we handled
them using try catch block instead.

First of all note that there's additional imports added, which
are java.util.InputMismatchException and java.io.FileNotFoundException.
Don't worry if you don't know the full package name. When any of the
exception occurs, the JVM will tell the full package name to you,
granted if you catched them like this first:
  
```JAVA
    try {
        // Code
    } catch (Exception err) {
        // Print out the error
        System.out.println(err);
        // Print out the full call stack when the error occurs
        err.printStackTrace();
    }
```
  
This is one of the way to do a catch block. Doing this will catch
any type of Exception being thrown during the program. If you
have any doubts what Exception will be thrown, write the catch block
like this.
Printing the error will give you some info on how to handle the
exception such as what kind of Exception and its package name.
Then, you can rewrite the catch block to reflect the new info:
  
```JAVA
    // Assume java.io.InputMismatchException have been imported
    catch (InputMismatchException err) {
        // Code
    }
```
  
This is how you catch a specific Exception. This is useful since
we write try catch block to handle any errors that occurs to fix them
and possibly prevent the program from crashing. Therefore, it's
logical that you want to handle some Exception differently.
For example, you might want to handle any divide by zero error by
allowing the user to input again.

Another hint I can give is the package the Exception belongs to usually
are similar to what caused it in the first place. For example,
FileNotFoundException occurs if a File does not exist, so the full
package name would be:
  
```JAVA
    // Cause
    import java.io.File;
    import java.util.Scanner;
    // Exception
    import java.io.FileNotFoundException;
    import java.util.InputMismatchException;
```
  
If there's multiple specific Exception to be handled, you can add
additional catch blocks as seen in the program source code.

The finally block is a special block that executes when any catch
blocks have finished executed. You can see its usage in the program
provided.

Last but not least, you can use the throw keyword (NOT throws) to
throw an Exception yourself. You can even customize the error
message:
  
```JAVA
    throw new FileNotFoundException("Error Message");
```
  
NOTE: The error message can be seen if you print the call stack or
if you did not handle the exception by using throws.

## Reference

1. [Exception Documentation](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
