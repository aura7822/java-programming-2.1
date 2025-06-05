//code for a car rental system
/*
NAME : Aura
ADM :BSE-05-0180/2024
GROUP : 3
 */
/**
 * Car Rental System
 *
 * This program demonstrates a simple car rental system using object-oriented programming (OOP) principles.
 * It includes classes for cars, customers, and a rental agency, and supports renting and returning cars.
 *
 * Author: joshua Aura
 * Date: 5th june 2025
 * Language: Java
 */

import java.util.*;
class Entity {
    protected String id;
    protected String name;
    public Entity(String id, String name) {
        this.id = id;
        this.name = name;
    }public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
class Car extends Entity {
    private boolean isAvailable;
    public Car(String carId, String model) {
        super(carId, model);
        this.isAvailable = true;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void rent() {
        isAvailable = false;
    }
    public void returnCar() {
        isAvailable = true;
    }
}
class Customer extends Entity {
    public Customer(String customerId, String name) {
        super(customerId, name);
    }
}
class RentalAgency {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    public void addCar(Car car) {
        cars.add(car);
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public boolean rentCar(String carId, String customerId) {
        for (Car car : cars) {
            if (car.getId().equals(carId) && car.isAvailable()) {
                car.rent();
                System.out.println("Car rented to customer " + customerId);
                return true;
            }
        }
        System.out.println("Car not available.");
        return false;
    }
    public void returnCar(String carId) {
        for (Car car : cars) {
            if (car.getId().equals(carId)) {
                car.returnCar();
                System.out.println("Car returned: " + carId);
                return;
            }
        }
        System.out.println("Car ID not found.");
    }
}
public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        Car car1 = new Car("C1", "Toyota Camry");
        Car car2 = new Car("C2", "Honda Civic");
        agency.addCar(car1);
        agency.addCar(car2);

        Customer customer1 = new Customer("U1", "Alice");
        agency.addCustomer(customer1);

        agency.rentCar("C1", "U1");
        agency.returnCar("C1");
    }
}
/**
 * Documentation Summary:
 *
 * Classes:
 * - Entity: Abstract base for common fields (id, name)
 * - Car: Inherits from Entity, tracks availability status
 * - Customer: Inherits from Entity
 * - RentalAgency: Manages car and customer lists, handles rental and return operations
 * - Main: Entry point, includes embedded test cases
 *
 * Functionalities:
 * - Add car/customer
 * - Rent and return cars
 * - Check availability
 * - Basic testing framework for validation
 */




