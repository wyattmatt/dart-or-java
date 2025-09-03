// Abstraction demonstration in Dart

// Abstract class demonstrating abstraction
abstract class Vehicle {
  String brand;
  String model;

  Vehicle(this.brand, this.model);

  // Abstract methods - must be implemented by concrete classes
  void startEngine();
  void stopEngine();
  void accelerate();
  void brake();

  // Concrete method that can be used by all vehicles
  void displayInfo() {
    print('Vehicle: $brand $model');
  }

  // Abstract method for getting vehicle type
  String getVehicleType();
}

// Concrete implementation of abstract Vehicle class
class Car extends Vehicle {
  int numberOfDoors;
  String transmission;

  Car(String brand, String model, this.numberOfDoors, this.transmission)
    : super(brand, model);

  @override
  void startEngine() {
    print('$brand $model: Turning key, engine starts with a gentle hum');
  }

  @override
  void stopEngine() {
    print('$brand $model: Engine stopped, key removed');
  }

  @override
  void accelerate() {
    print('$brand $model: Pressing gas pedal, car accelerates smoothly');
  }

  @override
  void brake() {
    print('$brand $model: Applying brakes, car slows down safely');
  }

  @override
  String getVehicleType() {
    return 'Car';
  }

  @override
  void displayInfo() {
    super.displayInfo();
    print('Type: ${getVehicleType()}');
    print('Doors: $numberOfDoors, Transmission: $transmission');
  }
}

class Motorcycle extends Vehicle {
  int engineSize;
  bool hasABS;

  Motorcycle(String brand, String model, this.engineSize, this.hasABS)
    : super(brand, model);

  @override
  void startEngine() {
    print('$brand $model: Kick start or button press, engine roars to life');
  }

  @override
  void stopEngine() {
    print('$brand $model: Engine stopped, motorcycle is quiet');
  }

  @override
  void accelerate() {
    print('$brand $model: Twisting throttle, motorcycle accelerates rapidly');
  }

  @override
  void brake() {
    print('$brand $model: Using hand and foot brakes, motorcycle slows down');
  }

  @override
  String getVehicleType() {
    return 'Motorcycle';
  }

  @override
  void displayInfo() {
    super.displayInfo();
    print('Type: ${getVehicleType()}');
    print('Engine: ${engineSize}cc, ABS: ${hasABS ? 'Yes' : 'No'}');
  }
}

// Another abstraction example - Payment System
abstract class PaymentProcessor {
  double amount;
  String currency;

  PaymentProcessor(this.amount, this.currency);

  // Abstract methods for payment processing
  bool validatePayment();
  bool processPayment();
  void sendConfirmation();

  // Concrete method with common logic
  bool executePayment() {
    print('\n--- Starting payment process ---');
    print('Amount: $amount $currency');

    if (!validatePayment()) {
      print('Payment validation failed');
      return false;
    }

    if (!processPayment()) {
      print('Payment processing failed');
      return false;
    }

    sendConfirmation();
    print('Payment completed successfully');
    return true;
  }

  // Abstract method for getting payment method name
  String getPaymentMethod();
}

class CreditCardProcessor extends PaymentProcessor {
  String cardNumber;
  String expiryDate;
  String cvv;

  CreditCardProcessor(
    double amount,
    String currency,
    this.cardNumber,
    this.expiryDate,
    this.cvv,
  ) : super(amount, currency);

  @override
  bool validatePayment() {
    print('Validating credit card details...');
    // Simplified validation logic
    if (cardNumber.length != 16) {
      print('Invalid card number length');
      return false;
    }
    if (cvv.length != 3) {
      print('Invalid CVV');
      return false;
    }
    print('Credit card validation successful');
    return true;
  }

  @override
  bool processPayment() {
    print('Processing credit card payment...');
    print('Contacting bank for authorization...');
    print('Payment authorized by bank');
    return true;
  }

  @override
  void sendConfirmation() {
    print('Credit card payment confirmation sent');
    print('Transaction ID: CC${DateTime.now().millisecondsSinceEpoch}');
  }

  @override
  String getPaymentMethod() {
    return 'Credit Card';
  }
}

class PayPalProcessor extends PaymentProcessor {
  String email;
  String password;

  PayPalProcessor(double amount, String currency, this.email, this.password)
    : super(amount, currency);

  @override
  bool validatePayment() {
    print('Validating PayPal credentials...');
    if (!email.contains('@')) {
      print('Invalid email format');
      return false;
    }
    if (password.length < 6) {
      print('Password too short');
      return false;
    }
    print('PayPal validation successful');
    return true;
  }

  @override
  bool processPayment() {
    print('Processing PayPal payment...');
    print('Connecting to PayPal servers...');
    print('Payment processed through PayPal');
    return true;
  }

  @override
  void sendConfirmation() {
    print('PayPal payment confirmation sent to $email');
    print('Transaction ID: PP${DateTime.now().millisecondsSinceEpoch}');
  }

  @override
  String getPaymentMethod() {
    return 'PayPal';
  }
}

class BankTransferProcessor extends PaymentProcessor {
  String accountNumber;
  String routingNumber;

  BankTransferProcessor(
    double amount,
    String currency,
    this.accountNumber,
    this.routingNumber,
  ) : super(amount, currency);

  @override
  bool validatePayment() {
    print('Validating bank account details...');
    if (accountNumber.length < 8) {
      print('Invalid account number');
      return false;
    }
    if (routingNumber.length != 9) {
      print('Invalid routing number');
      return false;
    }
    print('Bank account validation successful');
    return true;
  }

  @override
  bool processPayment() {
    print('Processing bank transfer...');
    print('Initiating ACH transfer...');
    print('Bank transfer initiated (may take 1-3 business days)');
    return true;
  }

  @override
  void sendConfirmation() {
    print('Bank transfer confirmation sent');
    print('Transaction ID: BT${DateTime.now().millisecondsSinceEpoch}');
  }

  @override
  String getPaymentMethod() {
    return 'Bank Transfer';
  }
}

// Abstract class for demonstrating data abstraction
abstract class DatabaseConnection {
  String host;
  int port;
  String database;

  DatabaseConnection(this.host, this.port, this.database);

  // Abstract methods that must be implemented
  bool connect();
  void disconnect();
  bool executeQuery(String query);
  List<Map<String, dynamic>> fetchResults();

  // Concrete method with common functionality
  void performOperation(String query) {
    print('\n--- Database Operation ---');
    if (connect()) {
      print('Connected to database: $database');
      if (executeQuery(query)) {
        List<Map<String, dynamic>> results = fetchResults();
        print('Query executed successfully. Results: ${results.length} rows');
      }
      disconnect();
    }
  }

  String getConnectionType();
}

class MySQLConnection extends DatabaseConnection {
  String username;
  String password;

  MySQLConnection(
    String host,
    int port,
    String database,
    this.username,
    this.password,
  ) : super(host, port, database);

  @override
  bool connect() {
    print('Connecting to MySQL database at $host:$port...');
    print('Using username: $username');
    return true;
  }

  @override
  void disconnect() {
    print('Disconnected from MySQL database');
  }

  @override
  bool executeQuery(String query) {
    print('Executing MySQL query: $query');
    return true;
  }

  @override
  List<Map<String, dynamic>> fetchResults() {
    return [
      {'id': 1, 'name': 'John Doe', 'email': 'john@email.com'},
      {'id': 2, 'name': 'Jane Smith', 'email': 'jane@email.com'},
    ];
  }

  @override
  String getConnectionType() {
    return 'MySQL';
  }
}

class PostgreSQLConnection extends DatabaseConnection {
  String username;
  String password;

  PostgreSQLConnection(
    String host,
    int port,
    String database,
    this.username,
    this.password,
  ) : super(host, port, database);

  @override
  bool connect() {
    print('Connecting to PostgreSQL database at $host:$port...');
    print('Using credentials for user: $username');
    return true;
  }

  @override
  void disconnect() {
    print('Disconnected from PostgreSQL database');
  }

  @override
  bool executeQuery(String query) {
    print('Executing PostgreSQL query: $query');
    return true;
  }

  @override
  List<Map<String, dynamic>> fetchResults() {
    return [
      {'user_id': 101, 'username': 'alice_cooper', 'status': 'active'},
      {'user_id': 102, 'username': 'bob_wilson', 'status': 'inactive'},
    ];
  }

  @override
  String getConnectionType() {
    return 'PostgreSQL';
  }
}

// Function demonstrating abstraction usage
void demonstrateVehicleAbstraction(List<Vehicle> vehicles) {
  print('=== Vehicle Abstraction Demo ===');
  for (Vehicle vehicle in vehicles) {
    print('\n--- ${vehicle.getVehicleType()} Demo ---');
    vehicle.displayInfo();
    vehicle.startEngine();
    vehicle.accelerate();
    vehicle.brake();
    vehicle.stopEngine();
  }
}

void demonstratePaymentAbstraction(List<PaymentProcessor> processors) {
  print('\n=== Payment Processing Abstraction Demo ===');
  for (PaymentProcessor processor in processors) {
    print('\n--- ${processor.getPaymentMethod()} ---');
    processor.executePayment();
  }
}

void demonstrateDatabaseAbstraction(List<DatabaseConnection> connections) {
  print('\n=== Database Abstraction Demo ===');
  for (DatabaseConnection connection in connections) {
    print('\n--- ${connection.getConnectionType()} ---');
    connection.performOperation('SELECT * FROM users WHERE active = true');
  }
}

void main() {
  // Demonstrating vehicle abstraction
  List<Vehicle> vehicles = [
    Car('Toyota', 'Camry', 4, 'Automatic'),
    Car('Honda', 'Civic', 4, 'Manual'),
    Motorcycle('Harley-Davidson', 'Sportster', 883, true),
    Motorcycle('Yamaha', 'YZF-R3', 321, true),
  ];

  demonstrateVehicleAbstraction(vehicles);

  // Demonstrating payment processing abstraction
  List<PaymentProcessor> paymentProcessors = [
    CreditCardProcessor(299.99, 'USD', '1234567890123456', '12/25', '123'),
    PayPalProcessor(149.50, 'USD', 'user@example.com', 'password123'),
    BankTransferProcessor(500.00, 'USD', '12345678901', '123456789'),
  ];

  demonstratePaymentAbstraction(paymentProcessors);

  // Demonstrating database abstraction
  List<DatabaseConnection> dbConnections = [
    MySQLConnection('localhost', 3306, 'myapp_db', 'admin', 'password'),
    PostgreSQLConnection(
      'localhost',
      5432,
      'app_database',
      'postgres',
      'secret',
    ),
  ];

  demonstrateDatabaseAbstraction(dbConnections);

  print('\n=== Key Benefits of Abstraction ===');
  print('1. Hide complex implementation details');
  print('2. Provide a clean, simple interface');
  print('3. Allow different implementations of the same concept');
  print('4. Make code more maintainable and extensible');
  print('5. Enable polymorphic behavior through abstract contracts');
}
