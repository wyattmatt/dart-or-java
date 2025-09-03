// Inheritance demonstration in Dart

// Base class (Parent class)
class Vehicle {
  String brand;
  String model;
  int year;
  double price;

  // Constructor
  Vehicle(this.brand, this.model, this.year, this.price);

  // Methods that can be inherited
  void startEngine() {
    print('$brand $model engine started!');
  }

  void stopEngine() {
    print('$brand $model engine stopped.');
  }

  void displayInfo() {
    print('Vehicle: $year $brand $model - \$${price.toStringAsFixed(2)}');
  }

  // Method that can be overridden
  void accelerate() {
    print('$brand $model is accelerating...');
  }

  // Method that can be overridden
  double calculateInsurance() {
    return price * 0.05; // 5% of vehicle price
  }
}

// Derived class (Child class) - Single Inheritance
class Car extends Vehicle {
  int numberOfDoors;
  String fuelType;

  // Constructor calling parent constructor using super
  Car(
    String brand,
    String model,
    int year,
    double price,
    this.numberOfDoors,
    this.fuelType,
  ) : super(brand, model, year, price);

  // Method specific to Car class
  void openTrunk() {
    print('$brand $model trunk opened.');
  }

  // Overriding parent method
  @override
  void accelerate() {
    print('$brand $model car is smoothly accelerating on the road...');
  }

  // Overriding parent method with additional logic
  @override
  void displayInfo() {
    super.displayInfo(); // Call parent method
    print('  - Doors: $numberOfDoors');
    print('  - Fuel Type: $fuelType');
  }

  // Overriding insurance calculation for cars
  @override
  double calculateInsurance() {
    double baseInsurance = super.calculateInsurance();
    // Cars have lower insurance rates
    return baseInsurance * 0.8;
  }
}

// Another derived class from Vehicle
class Motorcycle extends Vehicle {
  int engineSize; // in CC
  bool hasSidecar;

  Motorcycle(
    String brand,
    String model,
    int year,
    double price,
    this.engineSize,
    this.hasSidecar,
  ) : super(brand, model, year, price);

  // Method specific to Motorcycle
  void wheelie() {
    print('$brand $model is doing a wheelie! 🏍️');
  }

  // Overriding parent method
  @override
  void accelerate() {
    print('$brand $model motorcycle is rapidly accelerating with a roar!');
  }

  @override
  void displayInfo() {
    super.displayInfo();
    print('  - Engine Size: ${engineSize}cc');
    print('  - Has Sidecar: ${hasSidecar ? 'Yes' : 'No'}');
  }

  // Different insurance calculation for motorcycles
  @override
  double calculateInsurance() {
    double baseInsurance = super.calculateInsurance();
    // Motorcycles have higher insurance rates due to risk
    return baseInsurance * 1.5;
  }
}

// Multi-level inheritance: ElectricCar inherits from Car
class ElectricCar extends Car {
  double batteryCapacity; // in kWh
  int range; // in miles

  ElectricCar(
    String brand,
    String model,
    int year,
    double price,
    int numberOfDoors,
    this.batteryCapacity,
    this.range,
  ) : super(brand, model, year, price, numberOfDoors, 'Electric');

  // Method specific to electric cars
  void chargeBattery() {
    print(
      '$brand $model is charging... Battery capacity: ${batteryCapacity}kWh',
    );
  }

  // Overriding car's accelerate method
  @override
  void accelerate() {
    print(
      '$brand $model electric car is silently and instantly accelerating...',
    );
  }

  @override
  void startEngine() {
    print('$brand $model electric system activated silently.');
  }

  @override
  void displayInfo() {
    super.displayInfo();
    print('  - Battery Capacity: ${batteryCapacity}kWh');
    print('  - Range: $range miles');
  }

  // Electric cars may have different insurance rates
  @override
  double calculateInsurance() {
    double baseInsurance = super.calculateInsurance();
    // Electric cars might have slightly higher insurance due to expensive parts
    return baseInsurance * 1.1;
  }
}

// Demonstrating inheritance with abstract class
abstract class Animal {
  String name;
  int age;

  Animal(this.name, this.age);

  // Abstract method - must be implemented by child classes
  void makeSound();

  // Concrete method that can be inherited
  void sleep() {
    print('$name is sleeping...');
  }

  void eat() {
    print('$name is eating...');
  }
}

class Dog extends Animal {
  String breed;

  Dog(String name, int age, this.breed) : super(name, age);

  @override
  void makeSound() {
    print('$name the $breed barks: Woof! Woof!');
  }

  void fetch() {
    print('$name is fetching the ball!');
  }
}

class Cat extends Animal {
  bool isIndoor;

  Cat(String name, int age, this.isIndoor) : super(name, age);

  @override
  void makeSound() {
    print('$name meows: Meow! Meow!');
  }

  void purr() {
    print('$name is purring contentedly...');
  }
}

void main() {
  print('=== Vehicle Inheritance Demo ===');

  // Creating instances of different classes
  Vehicle genericVehicle = Vehicle('Generic', 'Vehicle', 2020, 15000);
  Car sedan = Car('Toyota', 'Camry', 2023, 28000, 4, 'Gasoline');
  Motorcycle sportBike = Motorcycle('Yamaha', 'R1', 2023, 18000, 1000, false);
  ElectricCar tesla = ElectricCar(
    'Tesla',
    'Model 3',
    2023,
    45000,
    4,
    75.0,
    300,
  );

  // Demonstrating inheritance - child classes have access to parent methods
  List<Vehicle> vehicles = [genericVehicle, sedan, sportBike, tesla];

  for (Vehicle vehicle in vehicles) {
    print('\n--- ${vehicle.brand} ${vehicle.model} ---');
    vehicle.displayInfo();
    vehicle.startEngine();
    vehicle.accelerate(); // This will call the overridden method for each type
    print('Insurance: \$${vehicle.calculateInsurance().toStringAsFixed(2)}');
    vehicle.stopEngine();
  }

  // Demonstrating specific methods available to child classes
  print('\n=== Specific Child Class Methods ===');
  sedan.openTrunk();
  sportBike.wheelie();
  tesla.chargeBattery();

  print('\n=== Animal Inheritance Demo ===');

  Dog dog = Dog('Buddy', 3, 'Golden Retriever');
  Cat cat = Cat('Whiskers', 2, true);

  List<Animal> animals = [dog, cat];

  for (Animal animal in animals) {
    print('\n--- ${animal.name} ---');
    animal.makeSound(); // Polymorphic behavior
    animal.eat(); // Inherited method
    animal.sleep(); // Inherited method
  }

  // Specific methods
  dog.fetch();
  cat.purr();

  print('\n=== Inheritance Chain Demo ===');
  print('ElectricCar inherits from Car, which inherits from Vehicle:');
  tesla.displayInfo(); // From Vehicle (overridden in Car and ElectricCar)
  tesla.startEngine(); // From Vehicle (overridden in ElectricCar)
  tesla.openTrunk(); // From Car
  tesla.chargeBattery(); // From ElectricCar
}
