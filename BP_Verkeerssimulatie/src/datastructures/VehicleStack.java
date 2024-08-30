package datastructures;

import models.Vehicle;

public class VehicleStack {

    private Vehicle[] stackArray; // Array to hold stack elements
    private String[] directions;  // Array to hold directions
    private int top;              // Index for the top element
    private int maxSize;          // Maximum size of the stack

    // Constructor to initialize the stack with a given size
    public VehicleStack(int size) {
        this.maxSize = size;
        this.stackArray = new Vehicle[maxSize];
        this.directions = new String[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Push a Vehicle and its direction onto the stack
    public void push(Vehicle vehicle, String direction) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push vehicle: " + vehicle.getLicensePlate());
            return;
        }
        stackArray[++top] = vehicle;     // Increment top and insert the vehicle
        directions[top] = direction;     // Store the direction with the vehicle
    }

    // Pop a Vehicle from the stack
    public Vehicle pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop vehicle.");
            return null;
        }
        return stackArray[top--];        // Return the top vehicle and decrement top
    }

    // Pop a direction corresponding to the vehicle from the stack
    public String popDirection() {

        return directions[top + 1];      // Return the direction corresponding to the popped vehicle
    }

    // Peek at the top Vehicle without removing it
    public Vehicle peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return null;
        }
        return stackArray[top];
    }

    // Peek at the direction of the top Vehicle without removing it
    public String peekDirection() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek direction.");
            return null;
        }
        return directions[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Get the current size of the stack
    public int size() {
        return top + 1;
    }
}
