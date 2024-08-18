package services;

import models.TrafficLight;
import models.Vehicle;
import queue.CustomPriorityQueue;
import queue.VehicleQueue;

public class Intersection {
    private TrafficLight northLight;
    private TrafficLight southLight;
    private TrafficLight eastLight;
    private TrafficLight westLight;

    private VehicleQueue vehicleQueue;

    public Intersection() {
        vehicleQueue = new VehicleQueue();

        northLight = new TrafficLight("North", 30, 30, true);
        southLight = new TrafficLight("South", 30, 30, true);
        eastLight = new TrafficLight("East", 30, 30, true);
        westLight = new TrafficLight("West", 30, 30, true);
    }

    public void simulate() {
        int cycles = 0;

        processPriority1Vehicles();
        processPriority2Vehicles();
        processPriority3Vehicles();

        while (!vehicleQueue.getNorthQueue().isEmpty() || !vehicleQueue.getSouthQueue().isEmpty() ||
                !vehicleQueue.getEastQueue().isEmpty() || !vehicleQueue.getWestQueue().isEmpty()) {

            System.out.println("Cycle " + (++cycles));

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
    }

    private boolean processPriorityVehicles(CustomPriorityQueue queue, int priority) {
        boolean processed = false;

        CustomPriorityQueue tempQueue = new CustomPriorityQueue();
        while (!queue.isEmpty()) {
            Vehicle vehicle = queue.poll();
            if (vehicle.getPriority() == priority) {
                System.out.println("Processing priority " + priority + " vehicle: " + vehicle.getLicensePlate());
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

    private boolean processPriority1Vehicles() {
        boolean hasPriority1Vehicles = false;

        hasPriority1Vehicles |= processPriorityVehicles(vehicleQueue.getNorthQueue(), 1);
        hasPriority1Vehicles |= processPriorityVehicles(vehicleQueue.getSouthQueue(), 1);
        hasPriority1Vehicles |= processPriorityVehicles(vehicleQueue.getEastQueue(), 1);
        hasPriority1Vehicles |= processPriorityVehicles(vehicleQueue.getWestQueue(), 1);
        return hasPriority1Vehicles;
    }

    private boolean processPriority2Vehicles() {
        boolean hasPriority2Vehicles = false;

        hasPriority2Vehicles |= processPriorityVehicles(vehicleQueue.getNorthQueue(), 2);
        hasPriority2Vehicles |= processPriorityVehicles(vehicleQueue.getSouthQueue(), 2);
        hasPriority2Vehicles |= processPriorityVehicles(vehicleQueue.getEastQueue(), 2);
        hasPriority2Vehicles |= processPriorityVehicles(vehicleQueue.getWestQueue(), 2);
        return hasPriority2Vehicles;
    }

    private boolean processPriority3Vehicles() {
        boolean hasPriority3Vehicles = false;

        hasPriority3Vehicles |= processPriorityVehicles(vehicleQueue.getNorthQueue(), 3);
        hasPriority3Vehicles |= processPriorityVehicles(vehicleQueue.getSouthQueue(), 3);
        hasPriority3Vehicles |= processPriorityVehicles(vehicleQueue.getEastQueue(), 3);
        hasPriority3Vehicles |= processPriorityVehicles(vehicleQueue.getWestQueue(), 3);
        return hasPriority3Vehicles;
    }
}
