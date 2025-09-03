// Encapsulation demonstration in Java

import java.util.ArrayList;
import java.util.List;

// Class demonstrating encapsulation principles
class BankAccount {
    // Private instance variables (encapsulated data)
    private String accountNumber;
    private String holderName;
    private double balance;
    private String pin;
    private List<String> transactionHistory;
    
    // Constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account opened with initial balance: $" + initialBalance);
    }
    
    // Public getter methods (controlled access to private data)
    public String getAccountNumber() {
        // Return masked account number for security
        return accountNumber.substring(0, 4) + "****";
    }
    
    public String getHolderName() {
        return holderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Public methods that provide controlled access to private data
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String transaction = "Deposited: $" + String.format("%.2f", amount) + 
                               ". New balance: $" + String.format("%.2f", balance);
            System.out.println(transaction);
            addTransaction(transaction);
            return true;
        } else {
            System.out.println("Invalid deposit amount. Must be positive.");
            return false;
        }
    }
    
    public boolean withdraw(double amount, String inputPin) {
        if (!validatePin(inputPin)) {
            System.out.println("Invalid PIN. Transaction denied.");
            addTransaction("Failed withdrawal attempt - Invalid PIN");
            return false;
        }
        
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Must be positive.");
            return false;
        }
        
        if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: $" + String.format("%.2f", balance));
            addTransaction("Failed withdrawal attempt - Insufficient funds");
            return false;
        }
        
        balance -= amount;
        String transaction = "Withdrew: $" + String.format("%.2f", amount) + 
                           ". New balance: $" + String.format("%.2f", balance);
        System.out.println(transaction);
        addTransaction(transaction);
        return true;
    }
    
    // Private method (internal logic, not accessible from outside)
    private boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }
    
    // Private helper method
    private void addTransaction(String transaction) {
        transactionHistory.add(java.time.LocalDateTime.now() + ": " + transaction);
    }
    
    // Method to change PIN (with validation)
    public boolean changePin(String oldPin, String newPin) {
        if (!validatePin(oldPin)) {
            System.out.println("Current PIN is incorrect.");
            addTransaction("Failed PIN change attempt");
            return false;
        }
        
        if (newPin.length() < 4) {
            System.out.println("New PIN must be at least 4 digits.");
            return false;
        }
        
        pin = newPin;
        System.out.println("PIN changed successfully.");
        addTransaction("PIN changed successfully");
        return true;
    }
    
    // Method to get account summary (controlled information display)
    public void displayAccountSummary() {
        System.out.println("Account Summary:");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + String.format("%.2f", balance));
    }
    
    // Method to display transaction history (controlled access)
    public void displayTransactionHistory(String inputPin) {
        if (!validatePin(inputPin)) {
            System.out.println("Invalid PIN. Cannot display transaction history.");
            return;
        }
        
        System.out.println("Transaction History for " + holderName + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Another class demonstrating encapsulation
class Student {
    private String name;
    private int studentId;
    private List<Double> grades;
    private String email;
    private boolean isActive;
    
    public Student(String name, int studentId, String email) {
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.grades = new ArrayList<>();
        this.isActive = true;
    }
    
    // Controlled access to student information
    public String getName() {
        return name;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    public String getEmail() {
        return email;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    // Controlled method to add grades with validation
    public void addGrade(double grade) {
        if (!isActive) {
            System.out.println("Cannot add grade. Student is not active.");
            return;
        }
        
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
            System.out.println("Grade " + grade + " added for " + name);
        } else {
            System.out.println("Invalid grade. Must be between 0 and 100.");
        }
    }
    
    // Calculate and return average (derived data)
    public double getAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    // Get grade count without exposing the internal list
    public int getGradeCount() {
        return grades.size();
    }
    
    // Display grades without exposing internal structure
    public void displayGrades() {
        if (!isActive) {
            System.out.println("Student is not active.");
            return;
        }
        
        if (grades.isEmpty()) {
            System.out.println(name + " has no grades yet.");
        } else {
            System.out.print(name + "'s grades: ");
            for (int i = 0; i < grades.size(); i++) {
                System.out.print(grades.get(i));
                if (i < grades.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println("Average: " + String.format("%.2f", getAverage()));
        }
    }
    
    // Controlled method to update email
    public boolean updateEmail(String newEmail) {
        if (newEmail.contains("@") && newEmail.contains(".")) {
            email = newEmail;
            System.out.println("Email updated successfully for " + name);
            return true;
        } else {
            System.out.println("Invalid email format.");
            return false;
        }
    }
    
    // Method to deactivate student
    public void deactivateStudent() {
        isActive = false;
        System.out.println(name + " has been deactivated.");
    }
    
    // Method to reactivate student
    public void reactivateStudent() {
        isActive = true;
        System.out.println(name + " has been reactivated.");
    }
}

// Class demonstrating encapsulation with composition
class Library {
    private String name;
    private List<Book> books;
    private int maxCapacity;
    
    public Library(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.books = new ArrayList<>();
    }
    
    // Inner class to demonstrate tight encapsulation
    private static class Book {
        private String title;
        private String author;
        private String isbn;
        private boolean isAvailable;
        
        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.isAvailable = true;
        }
        
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getIsbn() { return isbn; }
        public boolean isAvailable() { return isAvailable; }
        
        public void checkOut() { isAvailable = false; }
        public void checkIn() { isAvailable = true; }
        
        @Override
        public String toString() {
            return title + " by " + author + " (ISBN: " + isbn + ") - " + 
                   (isAvailable ? "Available" : "Checked Out");
        }
    }
    
    public boolean addBook(String title, String author, String isbn) {
        if (books.size() >= maxCapacity) {
            System.out.println("Library is at maximum capacity.");
            return false;
        }
        
        books.add(new Book(title, author, isbn));
        System.out.println("Book added: " + title);
        return true;
    }
    
    public boolean checkOutBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isAvailable()) {
                    book.checkOut();
                    System.out.println("Checked out: " + book.getTitle());
                    return true;
                } else {
                    System.out.println("Book is already checked out: " + book.getTitle());
                    return false;
                }
            }
        }
        System.out.println("Book not found with ISBN: " + isbn);
        return false;
    }
    
    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isAvailable()) {
                    book.checkIn();
                    System.out.println("Returned: " + book.getTitle());
                    return true;
                } else {
                    System.out.println("Book was not checked out: " + book.getTitle());
                    return false;
                }
            }
        }
        System.out.println("Book not found with ISBN: " + isbn);
        return false;
    }
    
    public void displayAvailableBooks() {
        System.out.println("Available books in " + name + ":");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("- " + book);
            }
        }
    }
    
    public int getBookCount() {
        return books.size();
    }
    
    public int getAvailableBookCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        System.out.println("=== Encapsulation Demonstration ===");
        
        // Demonstrating encapsulation with BankAccount
        System.out.println("\n=== Bank Account Encapsulation Demo ===");
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.0, "1234");
        
        // Accessing public methods (controlled access)
        account.displayAccountSummary();
        account.deposit(500.0);
        account.withdraw(200.0, "1234");
        account.withdraw(100.0, "5678"); // Wrong PIN
        account.changePin("1234", "5678");
        account.withdraw(150.0, "5678"); // New PIN
        
        // Display transaction history
        account.displayTransactionHistory("5678");
        
        // The following would cause compilation errors because these are private:
        // System.out.println(account.balance);  // Error: balance has private access
        // account.balance = 5000;               // Error: balance has private access
        // account.validatePin("1234");          // Error: validatePin has private access
        
        System.out.println("\n=== Student Encapsulation Demo ===");
        Student student = new Student("Alice Johnson", 12345, "alice@university.edu");
        
        // Using controlled access methods
        student.addGrade(85.5);
        student.addGrade(92.0);
        student.addGrade(78.5);
        student.addGrade(105.0); // Invalid grade
        
        student.displayGrades();
        
        System.out.println("Grade count: " + student.getGradeCount());
        System.out.println("Average: " + String.format("%.2f", student.getAverage()));
        
        // Testing email update
        student.updateEmail("alice.johnson@university.edu");
        student.updateEmail("invalid-email"); // Invalid format
        
        // Testing student deactivation
        student.deactivateStudent();
        student.addGrade(88.0); // Should fail
        student.displayGrades(); // Should show inactive
        student.reactivateStudent();
        student.addGrade(88.0); // Should work now
        
        System.out.println("\n=== Library Encapsulation Demo ===");
        Library library = new Library("City Central Library", 5);
        
        // Adding books
        library.addBook("Java: The Complete Reference", "Herbert Schildt", "978-0072263855");
        library.addBook("Clean Code", "Robert C. Martin", "978-0132350884");
        library.addBook("Design Patterns", "Gang of Four", "978-0201633612");
        
        // Display available books
        library.displayAvailableBooks();
        
        // Check out books
        library.checkOutBook("978-0072263855");
        library.checkOutBook("978-0072263855"); // Already checked out
        
        // Return book
        library.returnBook("978-0072263855");
        library.returnBook("978-0072263855"); // Not checked out
        
        System.out.println("\nTotal books: " + library.getBookCount());
        System.out.println("Available books: " + library.getAvailableBookCount());
        
        System.out.println("\n=== Key Benefits of Encapsulation ===");
        System.out.println("1. Data Protection: Private fields prevent unauthorized access");
        System.out.println("2. Controlled Access: Public methods provide controlled ways to interact with data");
        System.out.println("3. Validation: Input validation ensures data integrity");
        System.out.println("4. Flexibility: Internal implementation can change without affecting external code");
        System.out.println("5. Maintainability: Code is easier to maintain and debug");
        System.out.println("6. Security: Sensitive operations can be protected with authentication");
    }
}
