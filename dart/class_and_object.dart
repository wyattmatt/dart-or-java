// Class and Object demonstration in Dart

// Define a class
class Person {
  // Properties (instance variables)
  String name;
  int age;
  String email;

  // Constructor
  Person(this.name, this.age, this.email);

  // Named constructor
  Person.withNameOnly(this.name) : age = 0, email = '';

  // Methods
  void introduce() {
    print('Hello, my name is $name and I am $age years old.');
  }

  void celebrate() {
    age++;
    print('$name is now $age years old! 🎉');
  }

  // Getter
  String get info => 'Name: $name, Age: $age, Email: $email';

  // Setter
  set updateEmail(String newEmail) {
    email = newEmail;
  }
}

// Main function to demonstrate class and object usage
void main() {
  // Creating objects (instances) of the Person class
  Person person1 = Person('Alice', 25, 'alice@email.com');
  Person person2 = Person('Bob', 30, 'bob@email.com');
  Person person3 = Person.withNameOnly('Charlie');

  // Using object methods
  person1.introduce();
  person2.introduce();
  person3.introduce();

  // Modifying object properties
  person1.celebrate();
  person2.updateEmail = 'bob.smith@email.com';

  // Using getters
  print(person1.info);
  print(person2.info);
  print(person3.info);

  // Creating multiple objects to show they are independent
  List<Person> people = [
    Person('David', 22, 'david@email.com'),
    Person('Eve', 28, 'eve@email.com'),
  ];

  print('\nAll people:');
  for (Person person in people) {
    print(person.info);
  }
}
