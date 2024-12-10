package models;

import datastructures.CustomQueue;



public class TrafficLight {
    private String direction;
    private int cycleCount;
    private boolean hasSensor;
    private int vehiclesToClear;

    public TrafficLight(String direction, boolean hasSensor) {
        this.direction = direction;
        this.cycleCount = 0;
        this.hasSensor = hasSensor;
        this.vehiclesToClear = 0;
    }

    public void incrementCycleCount() {
        cycleCount++;
    }

    public int getCycleCount() {
        return cycleCount;
    }



    public void simulateTraffic(CustomQueue queue) {

        // Zuid sensor
        if (hasSensor && direction.equals("South")) {
            if (queue.size() > 10 && vehiclesToClear == 0) {
                vehiclesToClear = 10;
            }
            if (vehiclesToClear > 0) {
                System.out.println("----------------------------------------------------------- ");
                System.out.println("South sensor detected more than 10 vehicles. ");
                System.out.println("----------------------------------------------------------- ");
                while (vehiclesToClear > 0 && !queue.isEmpty()) {
                    Vehicle vehicle = queue.poll();
                    System.out.println( vehicle.getLicensePlate() + " at " + direction + " road.");
                    vehiclesToClear--;
                }
                return;
            }
            if (queue.isEmpty()) {
                System.out.println("Sensor detected no vehicles on " + direction );
                System.out.println("----------------------------------------------------------- ");
                return;
            }

        }

        // Oost sensor
        if (hasSensor && direction.equals("East") && queue.isEmpty()) {
            System.out.println("----------------------------------------------------------- ");
            System.out.println("Sensor detected no vehicles on " + direction );
            System.out.println("----------------------------------------------------------- ");
            return;
        }

        // West sensor
        if (hasSensor && direction.equals("West")) {
            if (queue.size() > 10 && vehiclesToClear == 0) {
                vehiclesToClear = 10;
            }
            if (vehiclesToClear > 0) {
                System.out.println("----------------------------------------------------------- ");
                System.out.println("West sensor detected more than 10 vehicles. ");
                while (vehiclesToClear > 0 && !queue.isEmpty()) {
                    Vehicle vehicle = queue.poll();
                    System.out.println( vehicle.getLicensePlate() + " at " + direction + " road.");
                    vehiclesToClear--;
                }
                return;
            }
            if (queue.isEmpty()) {
                System.out.println("----------------------------------------------------------- ");
                System.out.println("Sensor detected no vehicles on " + direction );
                System.out.println("----------------------------------------------------------- ");
                return;
            }
        }

        // Noord sensor
        if (hasSensor && direction.equals("North") && queue.size() < 5 && !queue.isEmpty()) {
            System.out.println("North sensor detected fewer than 5 vehicles. ");
            while (!queue.isEmpty()) {
                Vehicle vehicle = queue.poll();
                System.out.println( vehicle.getLicensePlate() + " at " + direction + " road.");
            }
            return;
        }if (queue.isEmpty()) {
            System.out.println("Sensor detected no vehicles on " + direction );
            return;
        }

        //verkeerslicht zonder sensoren
        int maxVehiclesToProcess = 5;
        if (!queue.isEmpty()) {
            System.out.println("----------------------------------------------------------- ");
            System.out.println("Green light for " + direction + " road.");
            System.out.println("----------------------------------------------------------- ");
            int count = 0;
            while (!queue.isEmpty() && count < maxVehiclesToProcess) {
                Vehicle vehicle = queue.poll();
                System.out.println( vehicle.getLicensePlate() + " at " + direction + " road.");
                count++;
            }
            if (queue.isEmpty()) {

                System.out.println("No more vehicles on " + direction + " road. ");
            }
        } else {
            System.out.println("----------------------------------------------------------- ");
            System.out.println("No vehicles on " + direction + " road.");
        }
    }
}
