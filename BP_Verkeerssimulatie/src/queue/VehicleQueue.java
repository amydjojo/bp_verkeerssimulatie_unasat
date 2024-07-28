package queue;

import models.Vehicle;

import java.util.LinkedList;
import java.util.Queue;

public class VehicleQueue {
    private Queue<Vehicle> northQueue;
    private Queue<Vehicle> southQueue;
    private Queue<Vehicle> eastQueue;
    private Queue<Vehicle> westQueue;

    private Vehicle[] vehicles;

    public VehicleQueue() {
        northQueue = new LinkedList<>();
        southQueue = new LinkedList<>();
        eastQueue = new LinkedList<>();
        westQueue = new LinkedList<>();

        initializeVehicles();
        populateQueues();
        printInitialState();
    }

    private void initializeVehicles() {
        vehicles = new Vehicle[41]; // Total number of vehicles

        int index = 0;

        // North vehicles
        vehicles[index++] = new Vehicle(index, "XP-09-90");
        vehicles[index++] = new Vehicle(index, "AB-12-91");
        vehicles[index++] = new Vehicle(index, "CD-34-92");
        vehicles[index++] = new Vehicle(index, "EF-56-93");

        // South vehicles
        vehicles[index++] = new Vehicle(index, "GH-78-94");
        vehicles[index++] = new Vehicle(index, "IJ-90-95");
        vehicles[index++] = new Vehicle(index, "KL-12-96");
        vehicles[index++] = new Vehicle(index, "MN-34-97");
        vehicles[index++] = new Vehicle(index, "OP-56-98");
        vehicles[index++] = new Vehicle(index, "QR-78-99");
        vehicles[index++] = new Vehicle(index, "ST-90-00");
        vehicles[index++] = new Vehicle(index, "UV-12-01");
        vehicles[index++] = new Vehicle(index, "WX-34-02");
        vehicles[index++] = new Vehicle(index, "YZ-56-03");
        vehicles[index++] = new Vehicle(index, "AA-78-04");
        vehicles[index++] = new Vehicle(index, "BB-90-05");
        vehicles[index++] = new Vehicle(index, "CC-12-06");
        vehicles[index++] = new Vehicle(index, "DD-34-07");
        vehicles[index++] = new Vehicle(index, "EE-56-08");
        vehicles[index++] = new Vehicle(index, "FF-78-09");

        // East vehicles
        vehicles[index++] = new Vehicle(index, "GG-90-10");
        vehicles[index++] = new Vehicle(index, "HH-12-11");
        vehicles[index++] = new Vehicle(index, "II-34-12");
        vehicles[index++] = new Vehicle(index, "JJ-56-13");
        vehicles[index++] = new Vehicle(index, "KK-78-14");

        // West vehicles
        vehicles[index++] = new Vehicle(index, "LL-90-15");
        vehicles[index++] = new Vehicle(index, "MM-12-16");
        vehicles[index++] = new Vehicle(index, "NN-34-17");
        vehicles[index++] = new Vehicle(index, "OO-56-18");
        vehicles[index++] = new Vehicle(index, "PP-78-19");
        vehicles[index++] = new Vehicle(index, "QQ-90-20");
        vehicles[index++] = new Vehicle(index, "RR-12-21");
        vehicles[index++] = new Vehicle(index, "SS-34-22");
        vehicles[index++] = new Vehicle(index, "TT-56-23");
        vehicles[index++] = new Vehicle(index, "UU-78-24");
        vehicles[index++] = new Vehicle(index, "VV-90-25");
        vehicles[index++] = new Vehicle(index, "WW-12-26");
        vehicles[index++] = new Vehicle(index, "XX-34-27");
        vehicles[index++] = new Vehicle(index, "YY-56-28");
        vehicles[index++] = new Vehicle(index, "ZZ-78-29");
    }

    private void populateQueues() {
        for (int i = 0; i < 4; i++) {
            northQueue.add(vehicles[i]);
//            System.out.println("Adding vehicle " + vehicles[i].getLicensePlate() + " to North queue.");
        }
        for (int i = 4; i < 22; i++) {
            southQueue.add(vehicles[i]);
//            System.out.println("Adding vehicle " + vehicles[i].getLicensePlate() + " to South queue.");
        }
        for (int i = 22; i < 27; i++) {
            eastQueue.add(vehicles[i]);
//            System.out.println("Adding vehicle " + vehicles[i].getLicensePlate() + " to East queue.");
        }
        for (int i = 27; i < 41; i++) {
            westQueue.add(vehicles[i]);
//            System.out.println("Adding vehicle " + vehicles[i].getLicensePlate() + " to West queue.");
        }
    }

    private void printInitialState() {
        System.out.println("Initial state:");
        System.out.println("North Queue: " + northQueue.size() + " vehicles");
        System.out.println("South Queue: " + southQueue.size() + " vehicles");
        System.out.println("East Queue: " + eastQueue.size() + " vehicles");
        System.out.println("West Queue: " + westQueue.size() + " vehicles");
    }


    public Queue<Vehicle> getNorthQueue() {
        return northQueue;
    }

    public Queue<Vehicle> getSouthQueue() {
        return southQueue;
    }

    public Queue<Vehicle> getEastQueue() {
        return eastQueue;
    }

    public Queue<Vehicle> getWestQueue() {
        return westQueue;
    }
}