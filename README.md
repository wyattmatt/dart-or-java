# Object-Oriented Programming: Dart vs Java Comparison

A comprehensive educational project demonstrating the four fundamental principles of Object-Oriented Programming (OOP) implemented in both Dart and Java. This repository provides side-by-side comparisons to help developers understand how OOP concepts are applied in both languages.

## 🎯 Project Overview

This project showcases the implementation of core OOP principles through practical examples in both Dart and Java:

- **Classes and Objects** - Basic class definition, constructors, and object instantiation
- **Encapsulation** - Data hiding and controlled access through private members
- **Inheritance** - Code reuse through parent-child class relationships
- **Polymorphism** - Multiple forms of the same interface through method overriding
- **Abstraction** - Hiding implementation details through abstract classes and interfaces

## 📁 Project Structure

```
dart-or-java/
├── dart/                          # Dart implementations
│   ├── class_and_object.dart      # Classes, objects, constructors
│   ├── encapsulation.dart         # Private members, getters, setters
│   ├── inheritance.dart           # Extends, super, method overriding
│   ├── polymorphism.dart          # Runtime polymorphism, interfaces
│   └── abstraction.dart           # Abstract classes, contracts
├── java/                          # Java implementations
│   ├── class_and_object.java      # Classes, objects, constructors
│   ├── encapsulation.java         # Private fields, access modifiers
│   ├── inheritance.java           # Extends, super, method overriding
│   ├── polymorphism.java          # Runtime polymorphism, interfaces
│   └── abstraction.java           # Abstract classes, interfaces
├── LICENSE                        # MIT License
└── README.md                      # This documentation
```

## 🔧 Prerequisites

### For Dart:

- [Dart SDK](https://dart.dev/get-dart) (version 2.12 or higher)
- Any text editor or IDE (VS Code, IntelliJ IDEA, etc.)

### For Java:

- [Java JDK](https://www.oracle.com/java/technologies/downloads/) (version 8 or higher)
- Any text editor or IDE (VS Code, IntelliJ IDEA, Eclipse, etc.)

## 🚀 Running the Examples

### Dart Examples

```bash
# Navigate to the dart directory
cd dart

# Run individual examples
dart run class_and_object.dart
dart run encapsulation.dart
dart run inheritance.dart
dart run polymorphism.dart
dart run abstraction.dart
```

### Java Examples

```bash
# Navigate to the java directory
cd java

# Compile and run individual examples
javac class_and_object.java && java class_and_object
javac encapsulation.java && java encapsulation
javac inheritance.java && java inheritance
javac polymorphism.java && java polymorphism
javac abstraction.java && java abstraction
```

## 📚 Core Concepts Demonstrated

### 1. Classes and Objects

**What you'll learn:**

- Class definition and structure
- Constructor overloading
- Instance variables and methods
- Object instantiation and usage

**Key Examples:**

- `Person` class with multiple constructors
- `Student` class with grade management
- Method chaining and object interaction

### 2. Encapsulation

**What you'll learn:**

- Private members and data hiding
- Getter and setter methods
- Controlled access to internal state
- Data validation and business logic

**Key Examples:**

- `BankAccount` class with secure transactions
- `Student` class with grade validation
- `Library` system with book management

### 3. Inheritance

**What you'll learn:**

- Single inheritance (`extends` keyword)
- Method overriding (`@override`)
- Super class constructor calls
- Multi-level inheritance chains

**Key Examples:**

- `Vehicle` → `Car` → `ElectricCar` inheritance chain
- `Animal` → `Dog`/`Cat` specialization
- Method overriding for specialized behavior

### 4. Polymorphism

**What you'll learn:**

- Runtime polymorphism
- Method overriding vs overloading
- Interface implementation
- Dynamic method dispatch

**Key Examples:**

- `Shape` hierarchy with area calculations
- `Employee` payroll system with different salary calculations
- Payment processing with multiple providers

### 5. Abstraction

**What you'll learn:**

- Abstract classes and methods
- Interface contracts
- Implementation hiding
- Common functionality sharing

**Key Examples:**

- `Vehicle` abstract class with concrete and abstract methods
- `PaymentProcessor` with different payment methods
- `DatabaseConnection` interface with multiple implementations

## 🔍 Language-Specific Differences

### Syntax Differences

| Feature               | Dart                      | Java                                                   |
| --------------------- | ------------------------- | ------------------------------------------------------ |
| **Class Declaration** | `class MyClass { }`       | `public class MyClass { }`                             |
| **Constructor**       | `MyClass(this.field);`    | `public MyClass(String field) { this.field = field; }` |
| **Private Members**   | `String _private;`        | `private String field;`                                |
| **Method Override**   | `@override`               | `@Override`                                            |
| **Abstract Class**    | `abstract class Base { }` | `abstract class Base { }`                              |
| **Interface**         | `mixin MyMixin { }`       | `interface MyInterface { }`                            |

### Key Conceptual Differences

1. **Access Modifiers:**

   - **Dart:** Uses underscore prefix (`_`) for private members
   - **Java:** Uses explicit keywords (`private`, `protected`, `public`)

2. **Constructor Syntax:**

   - **Dart:** Simplified with `this.parameter` syntax
   - **Java:** More verbose with explicit assignment

3. **Interfaces:**

   - **Dart:** Uses mixins and abstract classes
   - **Java:** Dedicated `interface` keyword

4. **Multiple Inheritance:**
   - **Dart:** Supports mixins for multiple inheritance-like behavior
   - **Java:** Single inheritance only, multiple interface implementation

## 🎓 Learning Path

1. **Start with Classes and Objects** - Understand the basics of OOP
2. **Learn Encapsulation** - Master data hiding and access control
3. **Explore Inheritance** - Understand code reuse and specialization
4. **Study Polymorphism** - Learn dynamic behavior and method dispatch
5. **Master Abstraction** - Understand contracts and implementation hiding

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

### Guidelines:

- Maintain the educational focus of examples
- Keep code well-commented and beginner-friendly
- Ensure examples work in both languages
- Add appropriate documentation for new concepts

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🔗 Additional Resources

### Dart Resources:

- [Dart Language Tour](https://dart.dev/guides/language/language-tour)
- [Effective Dart](https://dart.dev/guides/language/effective-dart)
- [Dart OOP Documentation](https://dart.dev/guides/language/language-tour#classes)

### Java Resources:

- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Effective Java](https://www.oracle.com/java/technologies/javase/effectivejava-3e.html)

### General OOP Resources:

- [Object-Oriented Programming Principles](https://en.wikipedia.org/wiki/Object-oriented_programming)
- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [Design Patterns](https://refactoring.guru/design-patterns)

---

**Happy Learning! 🚀**

_This project aims to make OOP concepts accessible and understandable through practical examples and clear comparisons between Dart and Java._
