// Polymorphism demonstration in Dart
import 'dart:math';

// Base class for demonstrating polymorphism
abstract class Shape {
  String color;

  Shape(this.color);

  // Abstract methods - must be implemented by subclasses
  double calculateArea();
  double calculatePerimeter();

  // Concrete method that can be overridden
  void display() {
    print('This is a $color shape');
  }

  // Method that uses polymorphic behavior
  void showDetails() {
    display();
    print('Area: ${calculateArea().toStringAsFixed(2)}');
    print('Perimeter: ${calculatePerimeter().toStringAsFixed(2)}');
  }
}

// Concrete implementation of Shape
class Circle extends Shape {
  double radius;

  Circle(String color, this.radius) : super(color);

  @override
  double calculateArea() {
    return 3.14159 * radius * radius;
  }

  @override
  double calculatePerimeter() {
    return 2 * 3.14159 * radius;
  }

  @override
  void display() {
    print('This is a $color circle with radius $radius');
  }
}

class Rectangle extends Shape {
  double width;
  double height;

  Rectangle(String color, this.width, this.height) : super(color);

  @override
  double calculateArea() {
    return width * height;
  }

  @override
  double calculatePerimeter() {
    return 2 * (width + height);
  }

  @override
  void display() {
    print('This is a $color rectangle with width $width and height $height');
  }
}

class Triangle extends Shape {
  double side1, side2, side3;

  Triangle(String color, this.side1, this.side2, this.side3) : super(color);

  @override
  double calculateArea() {
    // Using Heron's formula
    double s = (side1 + side2 + side3) / 2;
    return sqrt(s * (s - side1) * (s - side2) * (s - side3)).abs();
  }

  @override
  double calculatePerimeter() {
    return side1 + side2 + side3;
  }

  @override
  void display() {
    print('This is a $color triangle with sides $side1, $side2, $side3');
  }
}

// Another example of polymorphism with different class hierarchy
abstract class Employee {
  String name;
  int id;
  double baseSalary;

  Employee(this.name, this.id, this.baseSalary);

  // Abstract method for calculating salary (polymorphic behavior)
  double calculateSalary();

  // Concrete method
  void displayInfo() {
    print('Employee: $name (ID: $id)');
    print('Salary: \$${calculateSalary().toStringAsFixed(2)}');
  }

  // Abstract method for work description
  void describeWork();
}

class FullTimeEmployee extends Employee {
  double benefits;

  FullTimeEmployee(String name, int id, double baseSalary, this.benefits)
    : super(name, id, baseSalary);

  @override
  double calculateSalary() {
    return baseSalary + benefits;
  }

  @override
  void describeWork() {
    print('$name works full-time with benefits.');
  }
}

class PartTimeEmployee extends Employee {
  int hoursWorked;
  double hourlyRate;

  PartTimeEmployee(String name, int id, this.hoursWorked, this.hourlyRate)
    : super(name, id, 0);

  @override
  double calculateSalary() {
    return hoursWorked * hourlyRate;
  }

  @override
  void describeWork() {
    print(
      '$name works part-time for $hoursWorked hours at \$${hourlyRate}/hour.',
    );
  }
}

class Contractor extends Employee {
  int projectsCompleted;
  double ratePerProject;

  Contractor(String name, int id, this.projectsCompleted, this.ratePerProject)
    : super(name, id, 0);

  @override
  double calculateSalary() {
    return projectsCompleted * ratePerProject;
  }

  @override
  void describeWork() {
    print(
      '$name is a contractor who completed $projectsCompleted projects at \$${ratePerProject}/project.',
    );
  }
}

// Interface-like class for demonstrating polymorphism
mixin Drawable {
  void draw();
}

mixin Movable {
  void move(double x, double y);
}

// Class implementing multiple interfaces (mixins in Dart)
class GameShape with Drawable, Movable {
  String name;
  double x, y;

  GameShape(this.name, this.x, this.y);

  @override
  void draw() {
    print('Drawing $name at position ($x, $y)');
  }

  @override
  void move(double newX, double newY) {
    print('Moving $name from ($x, $y) to ($newX, $newY)');
    x = newX;
    y = newY;
  }
}

// Function demonstrating runtime polymorphism
void processShape(Shape shape) {
  print('\n--- Processing Shape ---');
  shape.showDetails(); // The actual implementation depends on the runtime type
}

void processEmployee(Employee employee) {
  print('\n--- Processing Employee ---');
  employee.displayInfo();
  employee.describeWork();
}

// Function demonstrating polymorphism with lists
void calculateTotalArea(List<Shape> shapes) {
  double totalArea = 0;
  print('\n=== Calculating Total Area ===');

  for (Shape shape in shapes) {
    double area = shape.calculateArea();
    print('${shape.runtimeType}: ${area.toStringAsFixed(2)}');
    totalArea += area;
  }

  print('Total Area: ${totalArea.toStringAsFixed(2)}');
}

void calculateTotalPayroll(List<Employee> employees) {
  double totalPayroll = 0;
  print('\n=== Calculating Total Payroll ===');

  for (Employee employee in employees) {
    double salary = employee.calculateSalary();
    print('${employee.name}: \$${salary.toStringAsFixed(2)}');
    totalPayroll += salary;
  }

  print('Total Payroll: \$${totalPayroll.toStringAsFixed(2)}');
}

void main() {
  print('=== Polymorphism with Shapes ===');

  // Creating different shape objects
  List<Shape> shapes = [
    Circle('red', 5.0),
    Rectangle('blue', 4.0, 6.0),
    Triangle('green', 3.0, 4.0, 5.0),
    Circle('yellow', 3.0),
    Rectangle('purple', 2.0, 8.0),
  ];

  // Demonstrating polymorphism - same method call, different behavior
  for (Shape shape in shapes) {
    processShape(shape); // Polymorphic method calls
  }

  // Calculate total area using polymorphism
  calculateTotalArea(shapes);

  print('\n=== Polymorphism with Employees ===');

  // Creating different employee objects
  List<Employee> employees = [
    FullTimeEmployee('Alice Johnson', 1001, 75000, 15000),
    PartTimeEmployee('Bob Smith', 1002, 20, 25.0),
    Contractor('Carol Davis', 1003, 5, 5000),
    FullTimeEmployee('David Wilson', 1004, 85000, 18000),
    PartTimeEmployee('Eve Brown', 1005, 15, 30.0),
  ];

  // Demonstrating polymorphism with employee processing
  for (Employee employee in employees) {
    processEmployee(employee); // Polymorphic behavior
  }

  // Calculate total payroll using polymorphism
  calculateTotalPayroll(employees);

  print('\n=== Method Overriding Demonstration ===');

  // Same reference type, different object types
  Shape shape1 = Circle('orange', 4.0);
  Shape shape2 = Rectangle('pink', 5.0, 3.0);
  Shape shape3 = Triangle('cyan', 6.0, 8.0, 10.0);

  // Each call to display() will use the overridden version
  shape1.display(); // Circle's display method
  shape2.display(); // Rectangle's display method
  shape3.display(); // Triangle's display method

  print('\n=== Interface-like Polymorphism ===');

  List<GameShape> gameShapes = [
    GameShape('Player', 10.0, 20.0),
    GameShape('Enemy', 50.0, 30.0),
    GameShape('PowerUp', 15.0, 45.0),
  ];

  // Polymorphic behavior with mixed-in methods
  for (GameShape gameShape in gameShapes) {
    gameShape.draw();
    gameShape.move(gameShape.x + 5, gameShape.y + 3);
  }

  print('\n=== Runtime Type Checking ===');

  // Demonstrating runtime type checking with polymorphism
  for (Shape shape in shapes) {
    if (shape is Circle) {
      print('Found a circle with radius ${shape.radius}');
    } else if (shape is Rectangle) {
      print(
        'Found a rectangle with width ${shape.width} and height ${shape.height}',
      );
    } else if (shape is Triangle) {
      print(
        'Found a triangle with sides ${shape.side1}, ${shape.side2}, ${shape.side3}',
      );
    }
  }
}
