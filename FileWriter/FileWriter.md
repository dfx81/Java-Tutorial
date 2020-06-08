# FileWriter.java

## Documentation

### Implementation

The FileWriter class is a simple program to write data into
file. It's recommended if you've basic knowledge regarding
File class by reading my tutorial on reading a File.  

In order to write to a file, we need to import a new class
called a PrintWriter. PrintWriter main use is to write
data over an OutputStream. It can also write to a File, so
that's why we're using the PrintWriter.  

First thing we need to do is to create a File object.
Here, we try to write into a file called Edit.txt. Something
different from the FileReader program is that we checked and
created an empty file if the file did not exist. Usually, we
do it by using a try catch block, but since we decided to
use throws, we need to do it this way.  

Then, we simply create a new PrintWriter object with the File
object as an argument. I intentionally named the created
PrintWriter object as out. There's a reason I'll explain later.  

From this point we can start writing data into the file. It's
actually really easy and the method names will be familiar.
Here's some example code:
  
```JAVA
    // Remember that the PrintWriter was named out
    out.print("Name: ");
    out.println(" Danial Fitri");
    out.printf("Age: %d", 20);
    out.print("Fav Num: " + 81 + "\n");
```
  
That's really similar to the code you'll write when you want
to print something into the console. All you need is to
simply add System before each out and you'll do just that.  

Next, I'll explain the PrintWriter.flush() method just before
the end. The PrintWriter did not write everything immediately
after you call the print methods. Instead, it saves the data
into a buffer. When it runs out of space on the buffer, or
when you called the PrintWriter.close(), then it'll write into
the file in one go. It's more efficient this way, but if
you're writing into something like a file over the internet,
where a single connection loss means wasted work, you can use
the flush() method to tell the PrintWriter to write the data
immediately.

Finally, the PrintWriter.close() just tells it that we no longer
have anything to write. It write all data from its buffer into
the file in one go and saves the file.

## References

1. [PrintWriter Documentation](https://docs.oracle.com/javase/7/docs/api/java/io/PrintWriter.html)
2. [File Documentation](https://docs.oracle.com/javase/7/docs/api/java/io/File.html)
