package com.rocky.collections.list.arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create an ArrayList
        List<String> list = new ArrayList<>();

        // Add elements to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Print the ArrayList
        System.out.println("ArrayList: " + list);

        // Access elements from the ArrayList
        String firstElement = list.get(0);
        System.out.println("First element: " + firstElement);

        // Remove an element from the ArrayList
        list.remove("Banana");
        System.out.println("After removal: " + list);

        // Get the size of the ArrayList
        System.out.println("Size of ArrayList: " + list.size());

        //Above list is not synchronized, thread-safe, Here's how to create thread-safe list from list
        List<String> synchronizedList = Collections.synchronizedList(list);
        System.out.println(synchronizedList);

        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");

        System.out.println("Employee Operations start here:");

        //Create a ArrayList to hold Employe objects
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John Doe", 50000, "1234567890", "HR"));
        employeeList.add(new Employee("Jane Smith", 60000, "0987654321", "IT"));
        employeeList.add(new Employee("Alice Johnson", 70000, "1122334455", "Finance"));
        employeeList.add(new Employee("Bob Brown", 80000, "2233445566", "Marketing"));
        // Print the employee list
        System.out.println("Employee List: "+employeeList);
        //Output Below if Employee doesnt implement toString()
        //Output: [com.rocky.collections.list.arrayList.Employee@3b9a45b3, com.rocky.collections.list.arrayList.Employee@7699a589, com.rocky.collections.list.arrayList.Employee@58372a00, com.rocky.collections.list.arrayList.Employee@4dd8dc3]

        //Employee class should override toString() method to print the employee details
        //Employee List: [Employee{name='John Doe', salary=50000.0, phoneNumber='1234567890', department='HR'}, Employee{name='Jane Smith', salary=60000.0, phoneNumber='0987654321', department='IT'}, Employee{name='Alice Johnson', salary=70000.0, phoneNumber='1122334455', department='Finance'}, Employee{name='Bob Brown', salary=80000.0, phoneNumber='2233445566', department='Marketing'}]

        //*******IMP*******
        //ArrayList maintains insertion order, not sorted order.
        //Even if your class implements Comparable, List won’t auto-sort unless explicitly told to do so via:
        //Collections.sort(list)
        //list.sort(...)
        //Or using a sorted data structure like TreeSet.

        //To Sort Employees by name :: DNSO, Default Natural Sorting Order
        Collections.sort(employeeList);


        //Explicit Comparator
        //Collections.sort(employeeList, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        //employeeList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));


        System.out.println("Employee List after Sorting: "+employeeList);

    }
}
class Employee implements Comparable<Employee>{
    private String name;
    private double salary;
    private String phoneNumber;
    private String department;

    public Employee(String name, double salary, String phoneNumber, String department) {
        this.name = name;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
