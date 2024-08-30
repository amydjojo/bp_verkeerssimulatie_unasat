package services;

import models.TrafficLight;
import models.Vehicle;
import datastructures.CustomPriorityQueue;
import queue.VehicleQueue;
import datastructures.VehicleStack;

public class Simulation {
    private TrafficLight northLight;
    private TrafficLight southLight;
    private TrafficLight eastLight;
    private TrafficLight westLight;

    private VehicleQueue vehicleQueue;

    public Simulation() {
        vehicleQueue = new VehicleQueue();

        northLight = new TrafficLight("North",  true);
        southLight = new TrafficLight("South",  true);
        eastLight = new TrafficLight("East",  true);
        westLight = new TrafficLight("West",  true);
    }

    public void simulate() {
        int cycles = 0;

        // Initialize the stack to store processed vehicles
        VehicleStack processedVehiclesStack = new VehicleStack();

        processPriority1Vehicles(processedVehiclesStack);
        processPriority2Vehicles(processedVehiclesStack);
        processPriority3Vehicles(processedVehiclesStack);

        processPriority4Vehicles(processedVehiclesStack);

        while (!vehicleQueue.getNorthQueue().isEmpty() || !vehicleQueue.getSouthQueue().isEmpty() ||
                !vehicleQueue.getEastQueue().isEmpty() || !vehicleQueue.getWestQueue().isEmpty()) {
            System.out.println("-------------------------------------------------------------------------" );
            System.out.println("Cycle " + (++cycles));
            System.out.println("-------------------------------------------------------------------------" );

            // Simulate North
            northLight.simulateTraffic(vehicleQueue.getNorthQueue());
            northLight.incrementCycleCount();

            // Simulate South
            southLight.simulateTraffic(vehicleQueue.getSouthQueue());
            southLight.incrementCycleCount();

            // Simulate East
            eastLight.simulateTraffic(vehicleQueue.getEastQueue());
            eastLight.incrementCycleCount();

            // Simulate West
            westLight.simulateTraffic(vehicleQueue.getWestQueue());
            westLight.incrementCycleCount();
        }

        System.out.println("Simulation complete.");
        System.out.println("North Light Cycles: " + northLight.getCycleCount());
        System.out.println("South Light Cycles: " + southLight.getCycleCount());
        System.out.println("East Light Cycles: " + eastLight.getCycleCount());
        System.out.println("West Light Cycles: " + westLight.getCycleCount());

        // Perform reverse playback
        reversePlayback(processedVehiclesStack);

    }

    private boolean processPriorityVehicles(CustomPriorityQueue queue, int priority, VehicleStack processedVehiclesStack) {
        boolean processed = false;

        CustomPriorityQueue tempQueue = new CustomPriorityQueue();
        while (!queue.isEmpty()) {
            Vehicle vehicle = queue.poll();
            if (vehicle.getPriority() == priority) {
                System.out.println(" priority " + priority + " vehicle: " + vehicle.getLicensePlate());
                processedVehiclesStack.push(vehicle); // Push processed vehicle to stack
                System.out.println("Pushed to stack: " + vehicle.getLicensePlate());

                processed = true;
            } else {
                tempQueue.add(vehicle);
            }
        }
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.poll());
        }
        return processed;
    }

    private boolean processPriority1Vehicles(VehicleStack processedVehiclesStack) {
        boolean hasPriority1Vehicles = false;

        hasPriority1Vehicles |= processPriorityVehicles(vehicleQueue.getNorthQueue(), 1, processedVehiclesStack);
        hasPriority1Vehicles |= processPriorityVehicles(vehicleQueue.getSouthQueue(), 1, processedVehiclesStack);
        hasPriority1Vehicles |= processPriorityVehicles(vehicleQueue.getEastQueue(), 1, processedVehiclesStack);
        hasPriority1Vehicles |= processPriorityVehicles(vehicleQueue.getWestQueue(), 1, processedVehiclesStack);
        return hasPriority1Vehicles;
    }

    private boolean processPriority2Vehicles(VehicleStack processedVehiclesStack) {
        boolean hasPriority2Vehicles = false;

        hasPriority2Vehicles |= processPriorityVehicles(vehicleQueue.getNorthQueue(), 2, processedVehiclesStack);
        hasPriority2Vehicles |= processPriorityVehicles(vehicleQueue.getSouthQueue(), 2, processedVehiclesStack);
        hasPriority2Vehicles |= processPriorityVehicles(vehicleQueue.getEastQueue(), 2, processedVehiclesStack);
        hasPriority2Vehicles |= processPriorityVehicles(vehicleQueue.getWestQueue(), 2,  processedVehiclesStack);
        return hasPriority2Vehicles;
    }

    private boolean processPriority3Vehicles(VehicleStack processedVehiclesStack) {
        boolean hasPriority3Vehicles = false;

        hasPriority3Vehicles |= processPriorityVehicles(vehicleQueue.getNorthQueue(), 3, processedVehiclesStack);
        hasPriority3Vehicles |= processPriorityVehicles(vehicleQueue.getSouthQueue(), 3, processedVehiclesStack);
        hasPriority3Vehicles |= processPriorityVehicles(vehicleQueue.getEastQueue(), 3, processedVehiclesStack);
        hasPriority3Vehicles |= processPriorityVehicles(vehicleQueue.getWestQueue(), 3, processedVehiclesStack);
        return hasPriority3Vehicles;
    }

    private void processPriority4Vehicles(VehicleStack processedVehiclesStack) {
        System.out.println("Processing non-priority vehicles...");
        processPriorityVehicles(vehicleQueue.getNorthQueue(), 4, processedVehiclesStack);
        processPriorityVehicles(vehicleQueue.getSouthQueue(), 4, processedVehiclesStack);
        processPriorityVehicles(vehicleQueue.getEastQueue(), 4, processedVehiclesStack);
        processPriorityVehicles(vehicleQueue.getWestQueue(), 4, processedVehiclesStack);
    }

    private void reversePlayback(VehicleStack processedVehiclesStack) {
        System.out.println("Starting reverse playback...");
        while (!processedVehiclesStack.isEmpty()) {
            Vehicle vehicle = processedVehiclesStack.pop();
            System.out.println("Replaying vehicle: " + vehicle.getLicensePlate() + " with priority " + vehicle.getPriority());
        }
        System.out.println("Reverse playback complete.");
    }
}
