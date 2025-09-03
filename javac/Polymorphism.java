// Polymorphism demonstration in Java

// Base class for demonstrating polymorphism
abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    // Concrete method that can be overridden
    public void display() {
        System.out.println("This is a " + color + " shape");
    }
    
    // Method that uses polymorphic behavior
    public void showDetails() {
        display();
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", calculatePerimeter()));
    }
    
    public String getColor() {
        return color;
    }
}

// Concrete implementation of Shape
class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void display() {
        System.out.println("This is a " + color + " circle with radius " + radius);
    }
    
    public double getRadius() {
        return radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public void display() {
        System.out.println("This is a " + color + " rectangle with width " + width + " and height " + height);
    }
    
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

class Triangle extends Shape {
    private double side1, side2, side3;
    
    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    @Override
    public double calculateArea() {
        // Using Heron's formula
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void display() {
        System.out.println("This is a " + color + " triangle with sides " + side1 + ", " + side2 + ", " + side3);
    }
    
    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }
}

// Another example of polymorphism with different class hierarchy
abstract class Employee {
    protected String name;
    protected int id;
    protected double baseSalary;
    
    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }
    
    // Abstract method for calculating salary (polymorphic behavior)
    public abstract double calculateSalary();
    
    // Concrete method
    public void displayInfo() {
        System.out.println("Employee: " + name + " (ID: " + id + ")");
        System.out.println("Salary: $" + String.format("%.2f", calculateSalary()));
    }
    
    // Abstract method for work description
    public abstract void describeWork();
    
    // Getters
    public String getName() { return name; }
    public int getId() { return id; }
    public double getBaseSalary() { return baseSalary; }
}

class FullTimeEmployee extends Employee {
    private double benefits;
    
    public FullTimeEmployee(String name, int id, double baseSalary, double benefits) {
        super(name, id, baseSalary);
        this.benefits = benefits;
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary + benefits;
    }
    
    @Override
    public void describeWork() {
        System.out.println(name + " works full-time with benefits.");
    }
    
    public double getBenefits() { return benefits; }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    
    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
    
    @Override
    public void describeWork() {
        System.out.println(name + " works part-time for " + hoursWorked + " hours at $" + hourlyRate + "/hour.");
    }
    
    public int getHoursWorked() { return hoursWorked; }
    public double getHourlyRate() { return hourlyRate; }
}

class Contractor extends Employee {
    private int projectsCompleted;
    private double ratePerProject;
    
    public Contractor(String name, int id, int projectsCompleted, double ratePerProject) {
        super(name, id, 0);
        this.projectsCompleted = projectsCompleted;
        this.ratePerProject = ratePerProject;
    }
    
    @Override
    public double calculateSalary() {
        return projectsCompleted * ratePerProject;
    }
    
    @Override
    public void describeWork() {
        System.out.println(name + " is a contractor who completed " + projectsCompleted + 
                         " projects at $" + ratePerProject + "/project.");
    }
    
    public int getProjectsCompleted() { return projectsCompleted; }
    public double getRatePerProject() { return ratePerProject; }
}

// Interface for demonstrating polymorphism
interface Drawable {
    void draw();
}

interface Movable {
    void move(double x, double y);
}

// Class implementing multiple interfaces
class GameShape implements Drawable, Movable {
    private String name;
    private double x, y;
    
    public GameShape(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing " + name + " at position (" + x + ", " + y + ")");
    }
    
    @Override
    public void move(double newX, double newY) {
        System.out.println("Moving " + name + " from (" + x + ", " + y + ") to (" + newX + ", " + newY + ")");
        this.x = newX;
        this.y = newY;
    }
    
    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }
}

// Vehicle hierarchy for method overloading demonstration
class Vehicle {
    protected String brand;
    protected String model;
    
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    // Method overloading - same method name, different parameters
    public void start() {
        System.out.println(brand + " " + model + " started with default method");
    }
    
    public void start(boolean quickStart) {
        if (quickStart) {
            System.out.println(brand + " " + model + " started quickly!");
        } else {
            start(); // Call the no-parameter version
        }
    }
    
    public void start(String startType) {
        System.out.println(brand + " " + model + " started with " + startType + " start");
    }
    
    public void start(boolean quickStart, String startType) {
        System.out.println(brand + " " + model + " started with " + startType + 
                         (quickStart ? " (quick)" : " (normal)"));
    }
    
    public String getBrand() { return brand; }
    public String getModel() { return model; }
}

public class Polymorphism {
    
    // Function demonstrating runtime polymorphism
    public static void processShape(Shape shape) {
        System.out.println("\n--- Processing Shape ---");
        shape.showDetails(); // The actual implementation depends on the runtime type
    }
    
    public static void processEmployee(Employee employee) {
        System.out.println("\n--- Processing Employee ---");
        employee.displayInfo();
        employee.describeWork();
    }
    
    // Function demonstrating polymorphism with arrays
    public static void calculateTotalArea(Shape[] shapes) {
        double totalArea = 0;
        System.out.println("\n=== Calculating Total Area ===");
        
        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            System.out.println(shape.getClass().getSimpleName() + ": " + String.format("%.2f", area));
            totalArea += area;
        }
        
        System.out.println("Total Area: " + String.format("%.2f", totalArea));
    }
    
    public static void calculateTotalPayroll(Employee[] employees) {
        double totalPayroll = 0;
        System.out.println("\n=== Calculating Total Payroll ===");
        
        for (Employee employee : employees) {
            double salary = employee.calculateSalary();
            System.out.println(employee.getName() + ": $" + String.format("%.2f", salary));
            totalPayroll += salary;
        }
        
        System.out.println("Total Payroll: $" + String.format("%.2f", totalPayroll));
    }
    
    // Method demonstrating interface polymorphism
    public static void demonstrateDrawables(Drawable[] drawables) {
        System.out.println("\n=== Drawable Objects Demo ===");
        for (Drawable drawable : drawables) {
            drawable.draw();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Polymorphism Demonstration ===");
        
        System.out.println("\n=== Polymorphism with Shapes ===");
        
        // Creating different shape objects
        Shape[] shapes = {
            new Circle("red", 5.0),
            new Rectangle("blue", 4.0, 6.0),
            new Triangle("green", 3.0, 4.0, 5.0),
            new Circle("yellow", 3.0),
            new Rectangle("purple", 2.0, 8.0)
        };
        
        // Demonstrating polymorphism - same method call, different behavior
        for (Shape shape : shapes) {
            processShape(shape); // Polymorphic method calls
        }
        
        // Calculate total area using polymorphism
        calculateTotalArea(shapes);
        
        System.out.println("\n=== Polymorphism with Employees ===");
        
        // Creating different employee objects
        Employee[] employees = {
            new FullTimeEmployee("Alice Johnson", 1001, 75000, 15000),
            new PartTimeEmployee("Bob Smith", 1002, 20, 25.0),
            new Contractor("Carol Davis", 1003, 5, 5000),
            new FullTimeEmployee("David Wilson", 1004, 85000, 18000),
            new PartTimeEmployee("Eve Brown", 1005, 15, 30.0)
        };
        
        // Demonstrating polymorphism with employee processing
        for (Employee employee : employees) {
            processEmployee(employee); // Polymorphic behavior
        }
        
        // Calculate total payroll using polymorphism
        calculateTotalPayroll(employees);
        
        System.out.println("\n=== Method Overriding Demonstration ===");
        
        // Same reference type, different object types
        Shape shape1 = new Circle("orange", 4.0);
        Shape shape2 = new Rectangle("pink", 5.0, 3.0);
        Shape shape3 = new Triangle("cyan", 6.0, 8.0, 10.0);
        
        // Each call to display() will use the overridden version
        shape1.display(); // Circle's display method
        shape2.display(); // Rectangle's display method
        shape3.display(); // Triangle's display method
        
        System.out.println("\n=== Interface Polymorphism ===");
        
        GameShape[] gameShapes = {
            new GameShape("Player", 10.0, 20.0),
            new GameShape("Enemy", 50.0, 30.0),
            new GameShape("PowerUp", 15.0, 45.0)
        };
        
        // Polymorphic behavior with interfaces
        Drawable[] drawables = gameShapes; // Implicit casting to interface
        demonstrateDrawables(drawables);
        
        for (GameShape gameShape : gameShapes) {
            gameShape.move(gameShape.getX() + 5, gameShape.getY() + 3);
        }
        
        System.out.println("\n=== Method Overloading Demonstration ===");
        
        Vehicle car = new Vehicle("Toyota", "Camry");
        
        // Different method signatures - compile-time polymorphism
        car.start();                    // No parameters
        car.start(true);               // Boolean parameter
        car.start("remote");           // String parameter
        car.start(false, "key");       // Boolean and String parameters
        
        System.out.println("\n=== Runtime Type Checking ===");
        
        // Demonstrating runtime type checking with polymorphism
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.println("Found a circle with radius " + circle.getRadius());
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                System.out.println("Found a rectangle with width " + rectangle.getWidth() + 
                                 " and height " + rectangle.getHeight());
            } else if (shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                System.out.println("Found a triangle with sides " + triangle.getSide1() + 
                                 ", " + triangle.getSide2() + ", " + triangle.getSide3());
            }
        }
        
        System.out.println("\n=== Polymorphism with Collections ===");
        
        java.util.ArrayList<Shape> shapeList = new java.util.ArrayList<>();
        shapeList.add(new Circle("magenta", 2.5));
        shapeList.add(new Rectangle("brown", 3.0, 4.0));
        
        System.out.println("Processing shapes from ArrayList:");
        for (Shape shape : shapeList) {
            shape.display(); // Polymorphic call
        }
        
        System.out.println("\n=== Key Polymorphism Concepts Demonstrated ===");
        System.out.println("1. Method Overriding: Subclasses provide specific implementations");
        System.out.println("2. Runtime Polymorphism: Method calls resolved at runtime");
        System.out.println("3. Compile-time Polymorphism: Method overloading resolved at compile time");
        System.out.println("4. Interface Polymorphism: Objects implementing interfaces can be treated uniformly");
        System.out.println("5. Abstract Classes: Enforcing implementation of abstract methods");
        System.out.println("6. instanceof operator: Runtime type checking");
        System.out.println("7. Casting: Converting between related types");
        System.out.println("8. Collections: Storing different types in same collection polymorphically");
    }
}
