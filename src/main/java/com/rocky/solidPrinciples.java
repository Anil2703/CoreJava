package com.rocky;

public class solidPrinciples {

    public static void main(String[] args) {
        //************************* SOLID Principles *************************//

        // Single Responsibility Principle (SRP)
        // A class should have only one reason to change.
        // Example: A class that handles user authentication should not also handle user profile management.

        //Wrong
        class Invoice {
            public void calculateTotal() { /* logic */ }
            public void printInvoice() { /* logic */ }
            public void saveToDatabase() { /* logic */ }
        }

        //Correct
        class Invoice1 {
            public void calculateTotal() { /* calculation logic */ }
        }

        class InvoicePrinter {
            public void print(Invoice invoice) { /* printing logic */ }
        }

        class InvoiceRepository {
            public void save(Invoice invoice) { /* database save logic */ }
        }

        // Open/Closed Principle (OCP)
        // Software entities should be open for extension but closed for modification.
        // Example: Use interfaces or abstract classes to allow new functionality without modifying existing code.


        //Wrong
        class PaymentService {
            public void pay(String type) {
                if (type.equals("creditcard")) { /* pay by credit card */ }
                else if (type.equals("paypal")) { /* pay by paypal */ }
            }
        }


        //Correct
        interface Payment {
            void pay();
        }

        class CreditCardPayment implements Payment {
            public void pay() { /* credit card logic */ }
        }

        class PayPalPayment implements Payment {
            public void pay() { /* PayPal logic */ }
        }

        class PaymentService1 {
            public void processPayment(Payment payment) {
                payment.pay(); // extension without modification
            }
        }

        // Liskov Substitution Principle (LSP)
        // Subtypes must be substitutable for their base types without altering the correctness of the program.
        // Example: If a class is a subclass of another, it should be able to replace the parent class without issues.

        //Wrong
        class Bird {
            public void fly() { /* flying logic */ }
        }

        class Ostrich extends Bird {
            public void fly() { throw new UnsupportedOperationException(); } // violates LSP
        }

        //Correct
        class Bird1 {
            public void move() { /* general movement logic */ }
        }

        class Sparrow extends Bird1 {
            public void move() { /* flying logic */ }
        }

        class Ostrich1 extends Bird1 {
            public void move() { /* walking logic */ } // no flying
        }


        // Interface Segregation Principle (ISP)
        // Clients should not be forced to depend on interfaces they do not use.
        // Example: Instead of one large interface, create smaller, more specific interfaces.

        //Wrong
        interface Machine {
            void print();
            void scan();
            void fax();
        }

        class MultiFunctionPrinter implements Machine {
            public void print() { /* printing logic */ }
            public void scan() { /* scanning logic */ }
            public void fax() { /* faxing logic */ }
        }
        //Correct
        interface Printer {
            void print();
        }
        interface Scanner {
            void scan();
        }
        interface Fax {
            void fax();
        }
        class MultiFunctionPrinter1 implements Printer, Scanner, Fax {
            public void print() { /* printing logic */ }
            public void scan() { /* scanning logic */ }
            public void fax() { /* faxing logic */ }
        }


        // Dependency Inversion Principle (DIP)
        // High-level modules should not depend on low-level modules. Both should depend on abstractions.
        // Example: Use dependency injection to decouple classes and make them easier to test and maintain.

        //Wrong
        class Database {
            public void save() { /* save logic */ }
        }

        class UserService {
            private Database database = new Database(); // tight coupling

            public void saveUser() {
                database.save();
            }
        }

        //Correct
        interface Database1 {
            void save();
        }
        class MySQLDatabase implements Database1 {
            public void save() { /* MySQL save logic */ }
        }
        class MongoDBDatabase implements Database1 {
            public void save() { /* MongoDB save logic */ }
        }
        class UserService1 {
            private Database1 database;

            public UserService1(Database1 database) { // dependency injection
                this.database = database;
            }

            public void saveUser() {
                database.save();
            }
        }



    }
}
