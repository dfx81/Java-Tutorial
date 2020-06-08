# FileReader

## Documentation

### Implementation

The program is quite simple as all it does it reading
from a file and print its contents. How does it works?

File class from java.io.File is a basic representation
of a basic plaintext file. It provides various methods
related to files such as creating new file, deleting
file, checking if it exists, checking read/write
permission, etc. However, it's just that, a
representation of a file. Therefore, we need something
else to read the File object.  
  
Now let us do a recap about Scanner. Usually, people
uses the Scanner class to do a basic user input.
However that's not the only thing a Scanner capable of
doing. When we check the official documentation of
the Scanner class, we can see there's more than one
constructor. Other than the usual:
  
```JAVA
    // System.in is a type of InputStream class
    Scanner(InputStream source);
```  
  
...we can also find this constructor:
  
```JAVA
    Scanner(File source);
```
  
Therefore, we can simply use a Scanner to read a file
by simply calling the appropriate constructor:
  
```JAVA
    final String FILE_NAME = "Data.txt";
    File file = new File(FILE_NAME);
    Scanner in = new Scanner(File file);
```
  
To read the contents of the File, simply use the various
Scanner methods like usual. Note that because you as the
programmer are usually the one responsible for the file
being read, it is important to make sure you used
correct Scanner method to read correct data. You don't
want to use a Scanner.nextInt() if the next item in the
text file is not an Integer.  

If you read the contents of the provided Data.txt file,
you'll realize that most of the contents are all over the
place. Some of them are indented, some are not, etc.
This is not a problem for the methods such as the ones
below:
  
```JAVA
    Scanner.next();
    Scanner.nextInt();
    Scanner.nextDouble();
    Scanner.nextBoolean();
```
  
These methods will simply skip any unnecessary whitespace
and find the next content to be read. They just find the
next available content and read it. If the type doesn't
match, then they'll throw an InputMismatchException
(except Scanner.next() since it reads anything as a String).

These does not apply for the Scanner.nextLine() method.
When we call this method, it will read a single line from
the file, regardless whether there's content or not, and
proceed to the next line.

These means we can use this method to skip lines in the
files. However, this also means it does not skip any
unnecessary whitespaces.

Note however, Scanner.nextLine() proceeds to the next line
in the file after it finishes while the other methods did
not do so. That means if you call Scanner.nextLine() after
any of the methods above, it will read a trailing newline
before moving to next line. To avoid this, simply call
Scanner.nextLine() to read the newline before calling it
again to read the actual content:
  
```JAVA
    double cgpa = in.nextDouble();
    in.nextLine();
    String hobby = in.nextLine();
```

## Reference

1. [File Documentation](https://docs.oracle.com/javase/7/docs/api/java/io/File.html)
2. [Scanner Documentation](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html)
