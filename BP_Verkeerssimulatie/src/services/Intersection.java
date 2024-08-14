package services;

import models.TrafficLight;
import models.Vehicle;
import queue.VehicleQueue;

import java.util.LinkedList;
import java.util.Queue;

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

    private boolean processPriority1Vehicles(){
        boolean hasPriority1Vehicles = false;

        hasPriority1Vehicles |=processPriority1Vehicles(vehicleQueue.getNorthQueue());
        hasPriority1Vehicles |= processPriority1Vehicles(vehicleQueue.getSouthQueue());
        hasPriority1Vehicles |= processPriority1Vehicles(vehicleQueue.getEastQueue());
        hasPriority1Vehicles |= processPriority1Vehicles(vehicleQueue.getWestQueue());
        return hasPriority1Vehicles;
    }

    private boolean processPriority1Vehicles(Queue<Vehicle>queue) {
        boolean processed = false;

        Queue<Vehicle> tempQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Vehicle vehicle = queue.poll();
            if (vehicle.getPriority() == 1) {
                System.out.println("Processing priority 1 vehicle: " + vehicle.getLicensePlate());
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


    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        intersection.simulate();
    }
}
