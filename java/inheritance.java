package java;

// Inheritance demonstration in Java

// Base class (Parent class)
class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double price;
    
    // Constructor
    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    
    // Methods that can be inherited
    public void startEngine() {
        System.out.println(brand + " " + model + " engine started!");
    }
    
    public void stopEngine() {
        System.out.println(brand + " " + model + " engine stopped.");
    }
    
    public void displayInfo() {
        System.out.println("Vehicle: " + year + " " + brand + " " + model + " - $" + 
                         String.format("%.2f", price));
    }
    
    // Method that can be overridden
    public void accelerate() {
        System.out.println(brand + " " + model + " is accelerating...");
    }
    
    // Method that can be overridden
    public double calculateInsurance() {
        return price * 0.05; // 5% of vehicle price
    }
    
    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
}

// Derived class (Child class) - Single Inheritance
class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    
    // Constructor calling parent constructor using super
    public Car(String brand, String model, int year, double price, int numberOfDoors, String fuelType) {
        super(brand, model, year, price); // Call parent constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }
    
    // Method specific to Car class
    public void openTrunk() {
        System.out.println(brand + " " + model + " trunk opened.");
    }
    
    // Overriding parent method
    @Override
    public void accelerate() {
        System.out.println(brand + " " + model + " car is smoothly accelerating on the road...");
    }
    
    // Overriding parent method with additional logic
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("  - Doors: " + numberOfDoors);
        System.out.println("  - Fuel Type: " + fuelType);
    }
    
    // Overriding insurance calculation for cars
    @Override
    public double calculateInsurance() {
        double baseInsurance = super.calculateInsurance();
        // Cars have lower insurance rates
        return baseInsurance * 0.8;
    }
    
    // Getters for Car-specific properties
    public int getNumberOfDoors() { return numberOfDoors; }
    public String getFuelType() { return fuelType; }
}

// Another derived class from Vehicle
class Motorcycle extends Vehicle {
    private int engineSize; // in CC
    private boolean hasSidecar;
    
    public Motorcycle(String brand, String model, int year, double price, int engineSize, boolean hasSidecar) {
        super(brand, model, year, price);
        this.engineSize = engineSize;
        this.hasSidecar = hasSidecar;
    }
    
    // Method specific to Motorcycle
    public void wheelie() {
        System.out.println(brand + " " + model + " is doing a wheelie! 🏍️");
    }
    
    // Overriding parent method
    @Override
    public void accelerate() {
        System.out.println(brand + " " + model + " motorcycle is rapidly accelerating with a roar!");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  - Engine Size: " + engineSize + "cc");
        System.out.println("  - Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
    
    // Different insurance calculation for motorcycles
    @Override
    public double calculateInsurance() {
        double baseInsurance = super.calculateInsurance();
        // Motorcycles have higher insurance rates due to risk
        return baseInsurance * 1.5;
    }
    
    // Getters
    public int getEngineSize() { return engineSize; }
    public boolean hasSidecar() { return hasSidecar; }
}

// Multi-level inheritance: ElectricCar inherits from Car
class ElectricCar extends Car {
    private double batteryCapacity; // in kWh
    private int range; // in miles
    
    public ElectricCar(String brand, String model, int year, double price, int numberOfDoors, 
                      double batteryCapacity, int range) {
        super(brand, model, year, price, numberOfDoors, "Electric");
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }
    
    // Method specific to electric cars
    public void chargeBattery() {
        System.out.println(brand + " " + model + " is charging... Battery capacity: " + 
                         batteryCapacity + "kWh");
    }
    
    // Overriding car's accelerate method
    @Override
    public void accelerate() {
        System.out.println(brand + " " + model + " electric car is silently and instantly accelerating...");
    }
    
    @Override
    public void startEngine() {
        System.out.println(brand + " " + model + " electric system activated silently.");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  - Battery Capacity: " + batteryCapacity + "kWh");
        System.out.println("  - Range: " + range + " miles");
    }
    
    // Electric cars may have different insurance rates
    @Override
    public double calculateInsurance() {
        double baseInsurance = super.calculateInsurance();
        // Electric cars might have slightly higher insurance due to expensive parts
        return baseInsurance * 1.1;
    }
    
    // Getters
    public double getBatteryCapacity() { return batteryCapacity; }
    public int getRange() { return range; }
}

// Demonstrating inheritance with abstract class
abstract class Animal {
    protected String name;
    protected int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Abstract method - must be implemented by child classes
    public abstract void makeSound();
    
    // Concrete method that can be inherited
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }
    
    public void eat() {
        System.out.println(name + " is eating...");
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
}

class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " the " + breed + " barks: Woof! Woof!");
    }
    
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
    
    public String getBreed() { return breed; }
}

class Cat extends Animal {
    private boolean isIndoor;
    
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    public void purr() {
        System.out.println(name + " is purring contentedly...");
    }
    
    public boolean isIndoor() { return isIndoor; }
}

// Interface for multiple inheritance-like behavior
interface Flyable {
    void fly();
    void land();
}

// Class implementing interface
class Bird extends Animal implements Flyable {
    private double wingspan;
    
    public Bird(String name, int age, double wingspan) {
        super(name, age);
        this.wingspan = wingspan;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void fly() {
        System.out.println(name + " is flying with wingspan of " + wingspan + " inches!");
    }
    
    @Override
    public void land() {
        System.out.println(name + " has landed gracefully.");
    }
    
    public double getWingspan() { return wingspan; }
}

public class inheritance {
    
    // Method demonstrating polymorphism through inheritance
    public static void demonstrateVehicleOperations(Vehicle[] vehicles) {
        System.out.println("\n=== Vehicle Operations Demo ===");
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("\n--- " + vehicle.getBrand() + " " + vehicle.getModel() + " ---");
            vehicle.displayInfo();
            vehicle.startEngine();
            vehicle.accelerate(); // This will call the overridden method for each type
            System.out.println("Insurance: $" + String.format("%.2f", vehicle.calculateInsurance()));
            vehicle.stopEngine();
        }
    }
    
    public static void demonstrateAnimalBehavior(Animal[] animals) {
        System.out.println("\n=== Animal Behavior Demo ===");
        
        for (Animal animal : animals) {
            System.out.println("\n--- " + animal.getName() + " ---");
            animal.makeSound(); // Polymorphic behavior
            animal.eat();       // Inherited method
            animal.sleep();     // Inherited method
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Inheritance Demonstration ===");
        
        // Creating instances of different classes
        Vehicle genericVehicle = new Vehicle("Generic", "Vehicle", 2020, 15000);
        Car sedan = new Car("Toyota", "Camry", 2023, 28000, 4, "Gasoline");
        Motorcycle sportBike = new Motorcycle("Yamaha", "R1", 2023, 18000, 1000, false);
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2023, 45000, 4, 75.0, 300);
        
        // Demonstrating inheritance - child classes have access to parent methods
        Vehicle[] vehicles = {genericVehicle, sedan, sportBike, tesla};
        demonstrateVehicleOperations(vehicles);
        
        // Demonstrating specific methods available to child classes
        System.out.println("\n=== Specific Child Class Methods ===");
        sedan.openTrunk();
        sportBike.wheelie();
        tesla.chargeBattery();
        
        System.out.println("\n=== Animal Inheritance Demo ===");
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, true);
        Bird bird = new Bird("Robin", 1, 12.5);
        
        Animal[] animals = {dog, cat, bird};
        demonstrateAnimalBehavior(animals);
        
        // Specific methods
        dog.fetch();
        cat.purr();
        bird.fly();
        bird.land();
        
        System.out.println("\n=== Inheritance Chain Demo ===");
        System.out.println("ElectricCar inherits from Car, which inherits from Vehicle:");
        tesla.displayInfo();    // From Vehicle (overridden in Car and ElectricCar)
        tesla.startEngine();    // From Vehicle (overridden in ElectricCar)
        tesla.openTrunk();      // From Car
        tesla.chargeBattery();  // From ElectricCar
        
        System.out.println("\n=== instanceof Demonstration ===");
        System.out.println("tesla instanceof Vehicle: " + (tesla instanceof Vehicle));
        System.out.println("tesla instanceof Car: " + (tesla instanceof Car));
        System.out.println("tesla instanceof ElectricCar: " + (tesla instanceof ElectricCar));
        System.out.println("sedan instanceof ElectricCar: " + (sedan instanceof ElectricCar));
        
        System.out.println("\n=== Interface Implementation Demo ===");
        if (bird instanceof Flyable) {
            Flyable flyingBird = (Flyable) bird;
            flyingBird.fly();
            flyingBird.land();
        }
        
        System.out.println("\n=== Access Modifier Demonstration ===");
        System.out.println("Accessing protected fields from child class:");
        System.out.println("Car brand (protected): " + sedan.getBrand());
        System.out.println("Car model (protected): " + sedan.getModel());
        
        // The following would cause compilation errors:
        // System.out.println(sedan.brand); // OK - protected accessible from same package
        // System.out.println(sedan.numberOfDoors); // Error - private field
        
        System.out.println("\n=== Key Inheritance Concepts Demonstrated ===");
        System.out.println("1. Single Inheritance: Car extends Vehicle");
        System.out.println("2. Multi-level Inheritance: ElectricCar extends Car extends Vehicle");
        System.out.println("3. Method Overriding: Child classes override parent methods");
        System.out.println("4. super keyword: Calling parent constructors and methods");
        System.out.println("5. Abstract classes: Animal with abstract makeSound() method");
        System.out.println("6. Interface implementation: Bird implements Flyable");
        System.out.println("7. Polymorphism: Same method calls, different behavior based on object type");
        System.out.println("8. Access modifiers: protected fields accessible to child classes");
    }
}
