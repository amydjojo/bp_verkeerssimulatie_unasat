package queue;

import models.Vehicle;
//vehicle queue class

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
        vehicles[index++] = new Vehicle(index, "XP-09-90", 4);
        vehicles[index++] = new Vehicle(index, "AB-12-91", 4);
        vehicles[index++] = new Vehicle(index, "CD-34-92", 4);
        vehicles[index++] = new Vehicle(index, "Ambulance", 3);

        // South vehicles
        vehicles[index++] = new Vehicle(index, "GH-78-94", 4);
        vehicles[index++] = new Vehicle(index, "IJ-90-95", 4);
        vehicles[index++] = new Vehicle(index, "KL-12-96", 4);
        vehicles[index++] = new Vehicle(index, "MN-34-97", 4);
        vehicles[index++] = new Vehicle(index, "Politie", 1);
        vehicles[index++] = new Vehicle(index, "QR-78-99", 4);
        vehicles[index++] = new Vehicle(index, "ST-90-00", 4);
        vehicles[index++] = new Vehicle(index, "UV-12-01", 4);
        vehicles[index++] = new Vehicle(index, "WX-34-02", 4);
        vehicles[index++] = new Vehicle(index, "YZ-56-03", 4);
        vehicles[index++] = new Vehicle(index, "AA-78-04", 4);
        vehicles[index++] = new Vehicle(index, "BB-90-05", 4);
        vehicles[index++] = new Vehicle(index, "CC-12-06", 4);
        vehicles[index++] = new Vehicle(index, "DD-34-07", 4);
        vehicles[index++] = new Vehicle(index, "EE-56-08", 4);
        vehicles[index++] = new Vehicle(index, "FF-78-09", 4);

        // East vehicles
        vehicles[index++] = new Vehicle(index, "GG-90-10", 4);
        vehicles[index++] = new Vehicle(index, "HH-12-11", 4);
        vehicles[index++] = new Vehicle(index, "Brandweer", 2);
        vehicles[index++] = new Vehicle(index, "JJ-56-13", 4);
        vehicles[index++] = new Vehicle(index, "KK-78-14", 4);

        // West vehicles
        vehicles[index++] = new Vehicle(index, "LL-90-15", 4);
        vehicles[index++] = new Vehicle(index, "MM-12-16", 4);
        vehicles[index++] = new Vehicle(index, "NN-34-17", 4);
        vehicles[index++] = new Vehicle(index, "OO-56-18", 4);
        vehicles[index++] = new Vehicle(index, "PP-78-19", 4);
        vehicles[index++] = new Vehicle(index, "QQ-90-20", 4);
        vehicles[index++] = new Vehicle(index, "RR-12-21", 4);
        vehicles[index++] = new Vehicle(index, "SS-34-22", 4);
        vehicles[index++] = new Vehicle(index, "TT-56-23", 4);
        vehicles[index++] = new Vehicle(index, "UU-78-24", 4);
        vehicles[index++] = new Vehicle(index, "VV-90-25", 4);
        vehicles[index++] = new Vehicle(index, "WW-12-26", 4);
        vehicles[index++] = new Vehicle(index, "XX-34-27", 4);
        vehicles[index++] = new Vehicle(index, "YY-56-28", 4);
        vehicles[index++] = new Vehicle(index, "ZZ-78-29", 4);
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
