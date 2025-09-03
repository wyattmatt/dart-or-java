// Class and Object demonstration in Java

// Define a class
class Person {
    // Instance variables (properties)
    private String name;
    private int age;
    private String email;
    
    // Constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Overloaded constructor
    public Person(String name) {
        this.name = name;
        this.age = 0;
        this.email = "";
    }
    
    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "";
    }
    
    // Methods
    public void introduce() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
    
    public void celebrate() {
        age++;
        System.out.println(name + " is now " + age + " years old! 🎉");
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Method to get formatted info
    public String getInfo() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email;
    }
    
    // toString method override
    @Override
    public String toString() {
        return getInfo();
    }
}

// Another class to demonstrate object relationships
class Student {
    private String studentId;
    private String name;
    private String major;
    private double gpa;
    
    public Student(String studentId, String name, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }
    
    public void study(String subject) {
        System.out.println(name + " is studying " + subject);
    }
    
    public void takeExam(String examName, double score) {
        System.out.println(name + " took " + examName + " and scored " + score);
        updateGPA(score);
    }
    
    private void updateGPA(double newScore) {
        // Simplified GPA calculation
        gpa = (gpa + (newScore / 25.0)) / 2; // Convert score to 4.0 scale
        System.out.println(name + "'s new GPA: " + String.format("%.2f", gpa));
    }
    
    // Getters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    
    // Setters
    public void setMajor(String major) { this.major = major; }
    
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + 
               ", Major: " + major + ", GPA: " + String.format("%.2f", gpa);
    }
}

// Main class to demonstrate usage
public class ClassAndObject {
    public static void main(String[] args) {
        System.out.println("=== Class and Object Demonstration ===");
        
        // Creating objects (instances) of the Person class
        Person person1 = new Person("Alice", 25, "alice@email.com");
        Person person2 = new Person("Bob", 30, "bob@email.com");
        Person person3 = new Person("Charlie"); // Using overloaded constructor
        Person person4 = new Person(); // Using default constructor
        
        // Using object methods
        person1.introduce();
        person2.introduce();
        person3.introduce();
        person4.introduce();
        
        // Modifying object properties using setter methods
        person1.celebrate();
        person2.setEmail("bob.smith@email.com");
        person3.setAge(22);
        person3.setEmail("charlie@email.com");
        person4.setName("Diana");
        person4.setAge(28);
        person4.setEmail("diana@email.com");
        
        // Using getter methods and displaying info
        System.out.println("\n=== Person Information ===");
        System.out.println(person1.getInfo());
        System.out.println(person2.getInfo());
        System.out.println(person3.getInfo());
        System.out.println(person4.getInfo());
        
        // Creating an array of Person objects
        Person[] people = {
            new Person("Eve", 26, "eve@email.com"),
            new Person("Frank", 35, "frank@email.com"),
            new Person("Grace", 29, "grace@email.com")
        };
        
        System.out.println("\n=== Array of People ===");
        for (Person person : people) {
            System.out.println(person.toString());
        }
        
        // Demonstrating Student class
        System.out.println("\n=== Student Class Demonstration ===");
        
        Student student1 = new Student("STU001", "John Doe", "Computer Science", 3.5);
        Student student2 = new Student("STU002", "Jane Smith", "Mathematics", 3.8);
        Student student3 = new Student("STU003", "Mike Johnson", "Physics", 3.2);
        
        // Using student methods
        student1.study("Data Structures");
        student1.takeExam("Midterm Exam", 88.5);
        
        student2.study("Calculus");
        student2.takeExam("Final Exam", 95.0);
        
        student3.study("Quantum Mechanics");
        student3.takeExam("Lab Report", 82.0);
        
        // Display student information
        System.out.println("\n=== Student Information ===");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        
        // Demonstrating object independence
        System.out.println("\n=== Object Independence ===");
        Person original = new Person("Test Person", 20, "test@email.com");
        Person copy = new Person("Test Person", 20, "test@email.com");
        
        System.out.println("Original: " + original.getInfo());
        System.out.println("Copy: " + copy.getInfo());
        
        // Modify one object
        original.setAge(25);
        original.setName("Modified Person");
        
        System.out.println("After modifying original:");
        System.out.println("Original: " + original.getInfo());
        System.out.println("Copy: " + copy.getInfo()); // Copy remains unchanged
        
        // Demonstrating multiple references to same object
        System.out.println("\n=== Object References ===");
        Person ref1 = new Person("Shared Person", 30, "shared@email.com");
        Person ref2 = ref1; // Both variables reference the same object
        
        System.out.println("ref1: " + ref1.getInfo());
        System.out.println("ref2: " + ref2.getInfo());
        
        ref1.setAge(35); // Modifying through ref1
        
        System.out.println("After modifying through ref1:");
        System.out.println("ref1: " + ref1.getInfo());
        System.out.println("ref2: " + ref2.getInfo()); // ref2 shows the same change
        
        System.out.println("\n=== Key Concepts Demonstrated ===");
        System.out.println("1. Class definition with properties and methods");
        System.out.println("2. Object creation using constructors");
        System.out.println("3. Method overloading (multiple constructors)");
        System.out.println("4. Encapsulation with private fields and public methods");
        System.out.println("5. Object independence and references");
        System.out.println("6. Arrays and collections of objects");
    }
}
