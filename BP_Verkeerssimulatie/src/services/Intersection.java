package services;

import models.TrafficLight;
import models.Vehicle;

import java.util.LinkedList;
import java.util.Queue;

public class Intersection {
    private Queue<Vehicle> northQueue;
    private Queue<Vehicle> southQueue;
    private Queue<Vehicle> eastQueue;
    private Queue<Vehicle> westQueue;

    private TrafficLight northLight;
    private TrafficLight southLight;
    private TrafficLight eastLight;
    private TrafficLight westLight;

    public Intersection() {
        northQueue = new LinkedList<>();
        southQueue = new LinkedList<>();
        eastQueue = new LinkedList<>();
        westQueue = new LinkedList<>();

        northLight = new TrafficLight("North", 10, 20,true );
        southLight = new TrafficLight("South", 15, 30, true);
        eastLight = new TrafficLight("East", 12, 24, true);
        westLight = new TrafficLight("West", 8, 16, true);

        initializeVehicles();
    }

    private void initializeVehicles() {
        // Add vehicles to queues
        for (int i = 1; i <= 4; i++) {
            northQueue.add(new Vehicle(i, "PY-" + i));
        }
        for (int i = 1; i <= 18; i++) {
            southQueue.add(new Vehicle(i, "PZ-" + i));
        }
        for (int i = 1; i <= 5; i++) {
            eastQueue.add(new Vehicle(i, "PA-" + i));
        }
        for (int i = 1; i <= 14; i++) {
            westQueue.add(new Vehicle(i, "PB-" + i));
        }

        // Debugging: Print initial state of queues
        System.out.println("Initial state:");
        System.out.println("North Queue: " + northQueue.size() + " vehicles");
        System.out.println("South Queue: " + southQueue.size() + " vehicles");
        System.out.println("East Queue: " + eastQueue.size() + " vehicles");
        System.out.println("West Queue: " + westQueue.size() + " vehicles");
        System.out.println("----------------------------------------------------------- 1");
    }

    public void simulate() {
        while (!northQueue.isEmpty() || !southQueue.isEmpty() || !eastQueue.isEmpty() || !westQueue.isEmpty()) {
            System.out.println("Simulation cycle:");
            System.out.println("----------------------------------------------------------- 2");
            // Example of processing North Light
            northLight.simulateTraffic(northQueue);
            southLight.simulateTraffic(southQueue);
            eastLight.simulateTraffic(eastQueue);
            westLight.simulateTraffic(westQueue);

            System.out.println("----------------------------------------------------------- 3");

            // Increase cycle count
            northLight.incrementCycleCount();
            southLight.incrementCycleCount();
            eastLight.incrementCycleCount();
            westLight.incrementCycleCount();



            // Debugging: Print state of queues and traffic lights
            System.out.println("North Queue: " + northQueue.size() + " vehicles");
            System.out.println("South Queue: " + southQueue.size() + " vehicles");
            System.out.println("East Queue: " + eastQueue.size() + " vehicles");
            System.out.println("West Queue: " + westQueue.size() + " vehicles");

            System.out.println("----------------------------------------------------------- 5");
            System.out.println("Nect cycle");
        }

        // Print final result
        System.out.println("Simulation completed:");
        System.out.println("North light cycles: " + northLight.getCycleCount());
        System.out.println("South light cycles: " + southLight.getCycleCount());
        System.out.println("East light cycles: " + eastLight.getCycleCount());
        System.out.println("West light cycles: " + westLight.getCycleCount());
    }


}
