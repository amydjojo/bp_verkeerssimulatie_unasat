package datastructures;

import models.Vehicle;

public class VehicleStack {

    private VehicleLinkedList<Vehicle> stack;

    public VehicleStack() {
        stack = new VehicleLinkedList<>();
    }

    public void push(Vehicle vehicle) {
        stack.addFirst(vehicle);
    }

    public Vehicle pop() {

        return stack.removeFirst();
    }


    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
