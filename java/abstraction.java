package java;

// Abstraction demonstration in Java

// Abstract class demonstrating abstraction
abstract class Vehicle {
    protected String brand;
    protected String model;
    
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    // Abstract methods - must be implemented by concrete classes
    public abstract void startEngine();
    public abstract void stopEngine();
    public abstract void accelerate();
    public abstract void brake();
    
    // Concrete method that can be used by all vehicles
    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " " + model);
    }
    
    // Abstract method for getting vehicle type
    public abstract String getVehicleType();
    
    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
}

// Concrete implementation of abstract Vehicle class
class Car extends Vehicle {
    private int numberOfDoors;
    private String transmission;
    
    public Car(String brand, String model, int numberOfDoors, String transmission) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
        this.transmission = transmission;
    }
    
    @Override
    public void startEngine() {
        System.out.println(brand + " " + model + ": Turning key, engine starts with a gentle hum");
    }
    
    @Override
    public void stopEngine() {
        System.out.println(brand + " " + model + ": Engine stopped, key removed");
    }
    
    @Override
    public void accelerate() {
        System.out.println(brand + " " + model + ": Pressing gas pedal, car accelerates smoothly");
    }
    
    @Override
    public void brake() {
        System.out.println(brand + " " + model + ": Applying brakes, car slows down safely");
    }
    
    @Override
    public String getVehicleType() {
        return "Car";
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + getVehicleType());
        System.out.println("Doors: " + numberOfDoors + ", Transmission: " + transmission);
    }
    
    public int getNumberOfDoors() { return numberOfDoors; }
    public String getTransmission() { return transmission; }
}

class Motorcycle extends Vehicle {
    private int engineSize;
    private boolean hasABS;
    
    public Motorcycle(String brand, String model, int engineSize, boolean hasABS) {
        super(brand, model);
        this.engineSize = engineSize;
        this.hasABS = hasABS;
    }
    
    @Override
    public void startEngine() {
        System.out.println(brand + " " + model + ": Kick start or button press, engine roars to life");
    }
    
    @Override
    public void stopEngine() {
        System.out.println(brand + " " + model + ": Engine stopped, motorcycle is quiet");
    }
    
    @Override
    public void accelerate() {
        System.out.println(brand + " " + model + ": Twisting throttle, motorcycle accelerates rapidly");
    }
    
    @Override
    public void brake() {
        System.out.println(brand + " " + model + ": Using hand and foot brakes, motorcycle slows down");
    }
    
    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + getVehicleType());
        System.out.println("Engine: " + engineSize + "cc, ABS: " + (hasABS ? "Yes" : "No"));
    }
    
    public int getEngineSize() { return engineSize; }
    public boolean hasABS() { return hasABS; }
}

// Another abstraction example - Payment System
abstract class PaymentProcessor {
    protected double amount;
    protected String currency;
    
    public PaymentProcessor(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    // Abstract methods for payment processing
    public abstract boolean validatePayment();
    public abstract boolean processPayment();
    public abstract void sendConfirmation();
    
    // Concrete method with common logic
    public boolean executePayment() {
        System.out.println("\n--- Starting payment process ---");
        System.out.println("Amount: " + amount + " " + currency);
        
        if (!validatePayment()) {
            System.out.println("Payment validation failed");
            return false;
        }
        
        if (!processPayment()) {
            System.out.println("Payment processing failed");
            return false;
        }
        
        sendConfirmation();
        System.out.println("Payment completed successfully");
        return true;
    }
    
    // Abstract method for getting payment method name
    public abstract String getPaymentMethod();
    
    // Getters
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
}

class CreditCardProcessor extends PaymentProcessor {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    
    public CreditCardProcessor(double amount, String currency, String cardNumber, String expiryDate, String cvv) {
        super(amount, currency);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
    
    @Override
    public boolean validatePayment() {
        System.out.println("Validating credit card details...");
        // Simplified validation logic
        if (cardNumber.length() != 16) {
            System.out.println("Invalid card number length");
            return false;
        }
        if (cvv.length() != 3) {
            System.out.println("Invalid CVV");
            return false;
        }
        System.out.println("Credit card validation successful");
        return true;
    }
    
    @Override
    public boolean processPayment() {
        System.out.println("Processing credit card payment...");
        System.out.println("Contacting bank for authorization...");
        System.out.println("Payment authorized by bank");
        return true;
    }
    
    @Override
    public void sendConfirmation() {
        System.out.println("Credit card payment confirmation sent");
        System.out.println("Transaction ID: CC" + System.currentTimeMillis());
    }
    
    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}

class PayPalProcessor extends PaymentProcessor {
    private String email;
    private String password;
    
    public PayPalProcessor(double amount, String currency, String email, String password) {
        super(amount, currency);
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean validatePayment() {
        System.out.println("Validating PayPal credentials...");
        if (!email.contains("@")) {
            System.out.println("Invalid email format");
            return false;
        }
        if (password.length() < 6) {
            System.out.println("Password too short");
            return false;
        }
        System.out.println("PayPal validation successful");
        return true;
    }
    
    @Override
    public boolean processPayment() {
        System.out.println("Processing PayPal payment...");
        System.out.println("Connecting to PayPal servers...");
        System.out.println("Payment processed through PayPal");
        return true;
    }
    
    @Override
    public void sendConfirmation() {
        System.out.println("PayPal payment confirmation sent to " + email);
        System.out.println("Transaction ID: PP" + System.currentTimeMillis());
    }
    
    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}

class BankTransferProcessor extends PaymentProcessor {
    private String accountNumber;
    private String routingNumber;
    
    public BankTransferProcessor(double amount, String currency, String accountNumber, String routingNumber) {
        super(amount, currency);
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }
    
    @Override
    public boolean validatePayment() {
        System.out.println("Validating bank account details...");
        if (accountNumber.length() < 8) {
            System.out.println("Invalid account number");
            return false;
        }
        if (routingNumber.length() != 9) {
            System.out.println("Invalid routing number");
            return false;
        }
        System.out.println("Bank account validation successful");
        return true;
    }
    
    @Override
    public boolean processPayment() {
        System.out.println("Processing bank transfer...");
        System.out.println("Initiating ACH transfer...");
        System.out.println("Bank transfer initiated (may take 1-3 business days)");
        return true;
    }
    
    @Override
    public void sendConfirmation() {
        System.out.println("Bank transfer confirmation sent");
        System.out.println("Transaction ID: BT" + System.currentTimeMillis());
    }
    
    @Override
    public String getPaymentMethod() {
        return "Bank Transfer";
    }
}

// Interface for demonstrating abstraction through interfaces
interface DatabaseConnection {
    boolean connect();
    void disconnect();
    boolean executeQuery(String query);
    java.util.List<java.util.Map<String, Object>> fetchResults();
    String getConnectionType();
}

// Abstract base class with interface implementation
abstract class AbstractDatabaseConnection implements DatabaseConnection {
    protected String host;
    protected int port;
    protected String database;
    
    public AbstractDatabaseConnection(String host, int port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }
    
    // Concrete method with common functionality
    public void performOperation(String query) {
        System.out.println("\n--- Database Operation ---");
        if (connect()) {
            System.out.println("Connected to database: " + database);
            if (executeQuery(query)) {
                java.util.List<java.util.Map<String, Object>> results = fetchResults();
                System.out.println("Query executed successfully. Results: " + results.size() + " rows");
            }
            disconnect();
        }
    }
    
    public String getHost() { return host; }
    public int getPort() { return port; }
    public String getDatabase() { return database; }
}

class MySQLConnection extends AbstractDatabaseConnection {
    private String username;
    private String password;
    
    public MySQLConnection(String host, int port, String database, String username, String password) {
        super(host, port, database);
        this.username = username;
        this.password = password;
    }
    
    @Override
    public boolean connect() {
        System.out.println("Connecting to MySQL database at " + host + ":" + port + "...");
        System.out.println("Using username: " + username);
        return true;
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnected from MySQL database");
    }
    
    @Override
    public boolean executeQuery(String query) {
        System.out.println("Executing MySQL query: " + query);
        return true;
    }
    
    @Override
    public java.util.List<java.util.Map<String, Object>> fetchResults() {
        java.util.List<java.util.Map<String, Object>> results = new java.util.ArrayList<>();
        
        java.util.Map<String, Object> row1 = new java.util.HashMap<>();
        row1.put("id", 1);
        row1.put("name", "John Doe");
        row1.put("email", "john@email.com");
        
        java.util.Map<String, Object> row2 = new java.util.HashMap<>();
        row2.put("id", 2);
        row2.put("name", "Jane Smith");
        row2.put("email", "jane@email.com");
        
        results.add(row1);
        results.add(row2);
        
        return results;
    }
    
    @Override
    public String getConnectionType() {
        return "MySQL";
    }
}

class PostgreSQLConnection extends AbstractDatabaseConnection {
    private String username;
    private String password;
    
    public PostgreSQLConnection(String host, int port, String database, String username, String password) {
        super(host, port, database);
        this.username = username;
        this.password = password;
    }
    
    @Override
    public boolean connect() {
        System.out.println("Connecting to PostgreSQL database at " + host + ":" + port + "...");
        System.out.println("Using credentials for user: " + username);
        return true;
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnected from PostgreSQL database");
    }
    
    @Override
    public boolean executeQuery(String query) {
        System.out.println("Executing PostgreSQL query: " + query);
        return true;
    }
    
    @Override
    public java.util.List<java.util.Map<String, Object>> fetchResults() {
        java.util.List<java.util.Map<String, Object>> results = new java.util.ArrayList<>();
        
        java.util.Map<String, Object> row1 = new java.util.HashMap<>();
        row1.put("user_id", 101);
        row1.put("username", "alice_cooper");
        row1.put("status", "active");
        
        java.util.Map<String, Object> row2 = new java.util.HashMap<>();
        row2.put("user_id", 102);
        row2.put("username", "bob_wilson");
        row2.put("status", "inactive");
        
        results.add(row1);
        results.add(row2);
        
        return results;
    }
    
    @Override
    public String getConnectionType() {
        return "PostgreSQL";
    }
}

public class abstraction {
    
    // Function demonstrating abstraction usage
    public static void demonstrateVehicleAbstraction(Vehicle[] vehicles) {
        System.out.println("=== Vehicle Abstraction Demo ===");
        for (Vehicle vehicle : vehicles) {
            System.out.println("\n--- " + vehicle.getVehicleType() + " Demo ---");
            vehicle.displayInfo();
            vehicle.startEngine();
            vehicle.accelerate();
            vehicle.brake();
            vehicle.stopEngine();
        }
    }
    
    public static void demonstratePaymentAbstraction(PaymentProcessor[] processors) {
        System.out.println("\n=== Payment Processing Abstraction Demo ===");
        for (PaymentProcessor processor : processors) {
            System.out.println("\n--- " + processor.getPaymentMethod() + " ---");
            processor.executePayment();
        }
    }
    
    public static void demonstrateDatabaseAbstraction(DatabaseConnection[] connections) {
        System.out.println("\n=== Database Abstraction Demo ===");
        for (DatabaseConnection connection : connections) {
            System.out.println("\n--- " + connection.getConnectionType() + " ---");
            if (connection instanceof AbstractDatabaseConnection) {
                ((AbstractDatabaseConnection) connection).performOperation("SELECT * FROM users WHERE active = true");
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Abstraction Demonstration ===");
        
        // Demonstrating vehicle abstraction
        Vehicle[] vehicles = {
            new Car("Toyota", "Camry", 4, "Automatic"),
            new Car("Honda", "Civic", 4, "Manual"),
            new Motorcycle("Harley-Davidson", "Sportster", 883, true),
            new Motorcycle("Yamaha", "YZF-R3", 321, true)
        };
        
        demonstrateVehicleAbstraction(vehicles);
        
        // Demonstrating payment processing abstraction
        PaymentProcessor[] paymentProcessors = {
            new CreditCardProcessor(299.99, "USD", "1234567890123456", "12/25", "123"),
            new PayPalProcessor(149.50, "USD", "user@example.com", "password123"),
            new BankTransferProcessor(500.00, "USD", "12345678901", "123456789")
        };
        
        demonstratePaymentAbstraction(paymentProcessors);
        
        // Demonstrating database abstraction
        DatabaseConnection[] dbConnections = {
            new MySQLConnection("localhost", 3306, "myapp_db", "admin", "password"),
            new PostgreSQLConnection("localhost", 5432, "app_database", "postgres", "secret")
        };
        
        demonstrateDatabaseAbstraction(dbConnections);
        
        System.out.println("\n=== Interface vs Abstract Class Demo ===");
        
        // Interface can be implemented by any class
        DatabaseConnection mysqlConn = new MySQLConnection("db.example.com", 3306, "production", "user", "pass");
        System.out.println("MySQL connection type: " + mysqlConn.getConnectionType());
        
        // Abstract class provides shared implementation
        AbstractDatabaseConnection abstractConn = new PostgreSQLConnection("localhost", 5432, "test", "test", "test");
        System.out.println("PostgreSQL host: " + abstractConn.getHost());
        
        System.out.println("\n=== Abstraction Benefits ===");
        System.out.println("1. Hide complex implementation details");
        System.out.println("2. Provide a clean, simple interface");
        System.out.println("3. Allow different implementations of the same concept");
        System.out.println("4. Make code more maintainable and extensible");
        System.out.println("5. Enable polymorphic behavior through abstract contracts");
        System.out.println("6. Force subclasses to implement required methods");
        System.out.println("7. Provide common functionality through concrete methods");
        
        System.out.println("\n=== Abstract Class vs Interface ===");
        System.out.println("Abstract Class:");
        System.out.println("- Can have concrete methods and abstract methods");
        System.out.println("- Can have instance variables");
        System.out.println("- Single inheritance only");
        System.out.println("- Can have constructors");
        
        System.out.println("\nInterface:");
        System.out.println("- All methods are abstract by default (before Java 8)");
        System.out.println("- Can have default and static methods (Java 8+)");
        System.out.println("- Variables are final and static by default");
        System.out.println("- Multiple inheritance supported");
        System.out.println("- Cannot have constructors");
    }
}
