// Encapsulation demonstration in Dart

// Class demonstrating encapsulation principles
class BankAccount {
  // Private properties (encapsulated data)
  String _accountNumber;
  String _holderName;
  double _balance;
  String _pin;

  // Constructor
  BankAccount(this._accountNumber, this._holderName, this._balance, this._pin);

  // Public getter methods (controlled access to private data)
  String get accountNumber => _accountNumber;
  String get holderName => _holderName;
  double get balance => _balance;

  // Public methods that provide controlled access to private data
  bool deposit(double amount) {
    if (amount > 0) {
      _balance += amount;
      print(
        'Deposited \$${amount.toStringAsFixed(2)}. New balance: \$${_balance.toStringAsFixed(2)}',
      );
      return true;
    } else {
      print('Invalid deposit amount. Must be positive.');
      return false;
    }
  }

  bool withdraw(double amount, String pin) {
    if (!_validatePin(pin)) {
      print('Invalid PIN. Transaction denied.');
      return false;
    }

    if (amount <= 0) {
      print('Invalid withdrawal amount. Must be positive.');
      return false;
    }

    if (amount > _balance) {
      print(
        'Insufficient funds. Current balance: \$${_balance.toStringAsFixed(2)}',
      );
      return false;
    }

    _balance -= amount;
    print(
      'Withdrew \$${amount.toStringAsFixed(2)}. New balance: \$${_balance.toStringAsFixed(2)}',
    );
    return true;
  }

  // Private method (internal logic, not accessible from outside)
  bool _validatePin(String inputPin) {
    return _pin == inputPin;
  }

  // Method to change PIN (with validation)
  bool changePin(String oldPin, String newPin) {
    if (!_validatePin(oldPin)) {
      print('Current PIN is incorrect.');
      return false;
    }

    if (newPin.length < 4) {
      print('New PIN must be at least 4 digits.');
      return false;
    }

    _pin = newPin;
    print('PIN changed successfully.');
    return true;
  }

  // Method to get account summary (controlled information display)
  void displayAccountSummary() {
    print('Account Summary:');
    print('Account Number: ${_accountNumber.substring(0, 4)}****');
    print('Holder Name: $_holderName');
    print('Balance: \$${_balance.toStringAsFixed(2)}');
  }
}

// Class showing another encapsulation example
class Student {
  String _name;
  int _id;
  List<double> _grades = [];

  Student(this._name, this._id);

  String get name => _name;
  int get id => _id;

  // Controlled access to add grades
  void addGrade(double grade) {
    if (grade >= 0 && grade <= 100) {
      _grades.add(grade);
      print('Grade $grade added for $_name');
    } else {
      print('Invalid grade. Must be between 0 and 100.');
    }
  }

  // Calculate and return average (derived data)
  double getAverage() {
    if (_grades.isEmpty) return 0.0;
    return _grades.reduce((a, b) => a + b) / _grades.length;
  }

  // Get grade count without exposing the internal list
  int getGradeCount() => _grades.length;

  // Display grades without exposing internal structure
  void displayGrades() {
    if (_grades.isEmpty) {
      print('$_name has no grades yet.');
    } else {
      print('$_name\'s grades: ${_grades.join(', ')}');
      print('Average: ${getAverage().toStringAsFixed(2)}');
    }
  }
}

void main() {
  // Demonstrating encapsulation with BankAccount
  print('=== Bank Account Encapsulation Demo ===');
  BankAccount account = BankAccount('123456789', 'John Doe', 1000.0, '1234');

  // Accessing public methods (controlled access)
  account.displayAccountSummary();
  account.deposit(500.0);
  account.withdraw(200.0, '1234');
  account.withdraw(100.0, '5678'); // Wrong PIN
  account.changePin('1234', '5678');

  // The following would cause compilation errors because these are private:
  // print(account._balance);  // Error: Private member
  // account._balance = 5000;  // Error: Private member
  // account._validatePin('1234'); // Error: Private method

  print('\n=== Student Encapsulation Demo ===');
  Student student = Student('Alice Johnson', 12345);

  // Using controlled access methods
  student.addGrade(85.5);
  student.addGrade(92.0);
  student.addGrade(78.5);
  student.addGrade(105.0); // Invalid grade

  student.displayGrades();

  print('Grade count: ${student.getGradeCount()}');
  print('Average: ${student.getAverage().toStringAsFixed(2)}');
}
