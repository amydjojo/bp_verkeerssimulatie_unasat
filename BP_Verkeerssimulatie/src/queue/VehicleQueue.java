package queue;

import models.Vehicle;
import java.util.Queue;
import java.util.LinkedList;

public class VehicleQueue {
    private CustomPriorityQueue northQueue;
    private CustomPriorityQueue southQueue;
    private CustomPriorityQueue eastQueue;
    private CustomPriorityQueue westQueue;

    private Vehicle[] vehicles;

    public VehicleQueue() {
        northQueue = new CustomPriorityQueue();
        southQueue = new CustomPriorityQueue();
        eastQueue = new CustomPriorityQueue();
        westQueue = new CustomPriorityQueue();

        initializeVehicles();
        populateQueues();
        printInitialState();
    }

    private void initializeVehicles() {
        vehicles = new Vehicle[41]; // Total number of vehicles

        int index = 0;

        // North vehicles
        vehicles[index++] = new Vehicle(index, "XP-09-90", 2);
        vehicles[index++] = new Vehicle(index, "AB-12-91", 2);
        vehicles[index++] = new Vehicle(index, "CD-34-92", 2);
        vehicles[index++] = new Vehicle(index, "Ambulance", 1);

        // South vehicles
        vehicles[index++] = new Vehicle(index, "GH-78-94", 2);
        vehicles[index++] = new Vehicle(index, "IJ-90-95", 2);
        vehicles[index++] = new Vehicle(index, "KL-12-96", 2);
        vehicles[index++] = new Vehicle(index, "MN-34-97", 2);
        vehicles[index++] = new Vehicle(index, "Politie", 1);
        vehicles[index++] = new Vehicle(index, "QR-78-99", 2);
        vehicles[index++] = new Vehicle(index, "ST-90-00", 2);
        vehicles[index++] = new Vehicle(index, "UV-12-01", 2);
        vehicles[index++] = new Vehicle(index, "WX-34-02", 2);
        vehicles[index++] = new Vehicle(index, "YZ-56-03", 2);
        vehicles[index++] = new Vehicle(index, "AA-78-04", 2);
        vehicles[index++] = new Vehicle(index, "BB-90-05", 2);
        vehicles[index++] = new Vehicle(index, "CC-12-06", 2);
        vehicles[index++] = new Vehicle(index, "DD-34-07", 2);
        vehicles[index++] = new Vehicle(index, "EE-56-08", 2);
        vehicles[index++] = new Vehicle(index, "FF-78-09", 2);

        // East vehicles
        vehicles[index++] = new Vehicle(index, "GG-90-10", 2);
        vehicles[index++] = new Vehicle(index, "HH-12-11", 2);
        vehicles[index++] = new Vehicle(index, "Brandweer", 1);
        vehicles[index++] = new Vehicle(index, "JJ-56-13", 2);
        vehicles[index++] = new Vehicle(index, "KK-78-14", 2);

        // West vehicles
        vehicles[index++] = new Vehicle(index, "LL-90-15", 2);
        vehicles[index++] = new Vehicle(index, "MM-12-16", 2);
        vehicles[index++] = new Vehicle(index, "NN-34-17", 2);
        vehicles[index++] = new Vehicle(index, "OO-56-18", 2);
        vehicles[index++] = new Vehicle(index, "PP-78-19", 2);
        vehicles[index++] = new Vehicle(index, "QQ-90-20", 2);
        vehicles[index++] = new Vehicle(index, "RR-12-21", 2);
        vehicles[index++] = new Vehicle(index, "SS-34-22", 2);
        vehicles[index++] = new Vehicle(index, "TT-56-23", 2);
        vehicles[index++] = new Vehicle(index, "UU-78-24", 2);
        vehicles[index++] = new Vehicle(index, "VV-90-25", 2);
        vehicles[index++] = new Vehicle(index, "WW-12-26", 2);
        vehicles[index++] = new Vehicle(index, "XX-34-27", 2);
        vehicles[index++] = new Vehicle(index, "YY-56-28", 2);
        vehicles[index++] = new Vehicle(index, "ZZ-78-29", 2);
    }

    private void populateQueues() {
        // North vehicles
        northQueue.add(vehicles[0]);
        northQueue.add(vehicles[1]);
        northQueue.add(vehicles[2]);
        northQueue.add(vehicles[3]);

        // South vehicles
        for (int i = 4; i < 19; i++) {
            southQueue.add(vehicles[i]);
        }

        // East vehicles
        for (int i = 19; i < 24; i++) {
            eastQueue.add(vehicles[i]);
        }

        // West vehicles
        for (int i = 24; i < 39; i++) {
            westQueue.add(vehicles[i]);
        }
    }

    private void printInitialState() {
        System.out.println("Initial state of the queues:");
        System.out.println("North Queue: " + northQueue.size() + " vehicles");
        System.out.println("South Queue: " + southQueue.size() + " vehicles");
        System.out.println("East Queue: " + eastQueue.size() + " vehicles");
        System.out.println("West Queue: " + westQueue.size() + " vehicles");
        System.out.println("----------------------------------------------------------- ");
    }

    public CustomPriorityQueue getNorthQueue() {
        return northQueue;
    }

    public CustomPriorityQueue getSouthQueue() {
        return southQueue;
    }

    public CustomPriorityQueue getEastQueue() {
        return eastQueue;
    }

    public CustomPriorityQueue getWestQueue() {
        return westQueue;
    }
}
