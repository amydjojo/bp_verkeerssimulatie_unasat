package queue;

import datastructures.CustomQueue;
import models.Vehicle;


public class VehicleQueue {
    private CustomQueue northQueue;
    private CustomQueue southQueue;
    private CustomQueue eastQueue;
    private CustomQueue westQueue;

    private Vehicle[] vehicles;

    public VehicleQueue() {
        northQueue = new CustomQueue();
        southQueue = new CustomQueue();
        eastQueue = new CustomQueue();
        westQueue = new CustomQueue();

        initializeVehicles();
        populateQueues();
        printInitialState();
    }

    private void initializeVehicles() {
        vehicles = new Vehicle[41];

        int index = 0;

        // Noord autos
        vehicles[index++] = new Vehicle(index, "XP-09-90", 4);
        vehicles[index++] = new Vehicle(index, "AB-12-91", 4);
        vehicles[index++] = new Vehicle(index, "Ambulance", 3);
        vehicles[index++] = new Vehicle(index, "CD-34-92", 4);

        // Zuid autos
        vehicles[index++] = new Vehicle(index, "GH-78-94", 4);
        vehicles[index++] = new Vehicle(index, "IJ-90-95", 4);
        vehicles[index++] = new Vehicle(index, "KL-12-96", 4);
        vehicles[index++] = new Vehicle(index, "MN-34-97", 4);
        vehicles[index++] = new Vehicle(index, "OP-56-98", 4);
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
        vehicles[index++] = new Vehicle(index, "Brandweer", 2);
        vehicles[index++] = new Vehicle(index, "CC-78-09", 4);

        // Oost autos
        vehicles[index++] = new Vehicle(index, "GG-90-10", 4);
        vehicles[index++] = new Vehicle(index, "HH-12-11", 4);
        vehicles[index++] = new Vehicle(index, "II-34-12", 4);
        vehicles[index++] = new Vehicle(index, "JJ-56-13", 4);
        vehicles[index++] = new Vehicle(index, "KK-78-14", 4);

        // West autos
        vehicles[index++] = new Vehicle(index, "LL-90-15", 4);
        vehicles[index++] = new Vehicle(index, "MM-12-16", 4);
        vehicles[index++] = new Vehicle(index, "NN-34-17", 4);
        vehicles[index++] = new Vehicle(index, "OO-56-18", 4);
        vehicles[index++] = new Vehicle(index, "PP-78-19", 4);
        vehicles[index++] = new Vehicle(index, "QQ-90-20", 4);
        vehicles[index++] = new Vehicle(index, "RR-12-21", 4);
        vehicles[index++] = new Vehicle(index, "SS-34-22", 4);
        vehicles[index++] = new Vehicle(index, "Politie", 1);
        vehicles[index++] = new Vehicle(index, "UU-78-24", 4);
        vehicles[index++] = new Vehicle(index, "VV-90-25", 4);
        vehicles[index++] = new Vehicle(index, "WW-12-26", 4);
        vehicles[index++] = new Vehicle(index, "XX-34-27", 4);
        vehicles[index++] = new Vehicle(index, "YY-56-28", 4);
    }

    private void populateQueues() {
        // noord
        for (int i = 0; i < 4; i++) {
            northQueue.add(vehicles[i]);
        }

        // zuid
        for (int i = 4; i < 22; i++) {
            southQueue.add(vehicles[i]);
        }

        // oost
        for (int i = 22; i < 27; i++) {
            eastQueue.add(vehicles[i]);
        }

        // west
        for (int i = 27; i < 41; i++) {
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

    public CustomQueue getNorthQueue() {
        return northQueue;
    }

    public CustomQueue getSouthQueue() {
        return southQueue;
    }

    public CustomQueue getEastQueue() {
        return eastQueue;
    }

    public CustomQueue getWestQueue() {
        return westQueue;
    }
}
