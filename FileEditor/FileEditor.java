import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

// Simple Person class
class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// The main bulk of the program is here
class FileEditor {
    // Get the file and declare a Person arraylist.
    // For the file path (.) means "here" while
    // (..) means the upper directory or parent
    // directory.
    File file = new File("./Records.txt");
    ArrayList <Person> record;
    Scanner in;
    
    // Main program code
    void program() throws Exception {
        System.out.println("This is a list of Person (name + age):");
        
        // Load the file, read the content and
        // fill the arraylist with Person object
        load();
        
        // Display the content of arraylist
        display();
        
        System.out.println("Modifying record (type /add, /edit, /delete, or /exit):");
        
        in = new Scanner(System.in);
        
        boolean edit = true;
        String next = "";
        
        // Repeat the process until "/exit" typed
        while (edit) {
            next = in.nextLine();
            
            // Call appropriate method
            switch (next) {
                case "/exit": edit = false;
                              break;
                case "/add": add();
                             break;
                case "/edit": edit();
                              break;
                case "/delete": remove();
                                break;
                default: break;
            }
            
            // Display result of each changes
            display();
        }
        
        // Write the contents back into file
        write();
        
        in.close();
    }
    
    // Used to load data and create Person objects from file
    void load() throws Exception {
        in = new Scanner(file);
        
        record = new ArrayList<Person>(0);
        
        while (in.hasNext()) {
            String name = in.nextLine();
            int age = in.nextInt();
            in.nextLine();
            
            record.add(new Person(name, age));
        }
        
        in.close();
    }
    
    // Used to write back Person objects into the text file
    void write() throws Exception {
        FileWriter out = new FileWriter(file);
        
        String text = "";
        
        for (int i = 0; i != record.size(); i++) {
            text += record.get(i).name + "\n";
            text += record.get(i).age + "\n";
        }
        
        out.write(text);
        out.close();
    }
    
    // Add new Person to arraylist
    void add() {
        System.out.print("Enter name of the Person to add: ");
        String name = in.nextLine();
        System.out.print("Enter age of the Person to add: ");
        int age = in.nextInt();
        in.nextLine();
        
        record.add(new Person(name, age));
    }
    
    // Edit existing Person in arraylist
    void edit() {
        System.out.print("Enter index of the Person to edit: ");
        int id = in.nextInt();
        in.nextLine();
        
        System.out.print("Enter new name of the Person (" + record.get(id).name + "): ");
        String newName = in.nextLine();
        System.out.print("Enter new age of the Person (" + record.get(id).age + "): ");
        int newAge = in.nextInt();
        in.nextLine();
        
        record.get(id).name = newName;
        record.get(id).age = newAge;
    }
    
    // Remove existing Person from arraylist
    void remove() {
        System.out.print("Enter index of the Person to delete: ");
        int id = in.nextInt();
        in.nextLine();
        
        record.remove(id);
    }
    
    // Display content of arraylist
    void display() {
        for (int i = 0; i != record.size(); i++) {
            System.out.println(i + ": Name - " + record.get(i).name + " | Age - " + record.get(i).age);
        }
    }
    
    // Main method
    public static void main(String[] args) throws Exception {
        new FileEditor().program();
    }
}
