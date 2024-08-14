package services;

import models.TrafficLight;
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

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        intersection.simulate();
    }
}
