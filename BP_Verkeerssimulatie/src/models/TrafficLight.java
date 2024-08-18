package models;

import queue.CustomPriorityQueue;



public class TrafficLight {
    private String direction;
    private int greenDuration;
    private int redDuration;
    private int cycleCount;
    private boolean hasSensor;
    private int vehiclesToClear;

    public TrafficLight(String direction, int greenDuration, int redDuration, boolean hasSensor) {
        this.direction = direction;
        this.greenDuration = greenDuration;
        this.redDuration = redDuration;
        this.cycleCount = 0;
        this.hasSensor = hasSensor;
        this.vehiclesToClear = 0;
    }

    public String getDirection() {
        return direction;
    }

    public boolean hasSensor() {
        return hasSensor;
    }

    public void incrementCycleCount() {
        cycleCount++;
    }

    public int getCycleCount() {
        return cycleCount;
    }

    public void simulateTraffic(CustomPriorityQueue queue) {
        // South sensor logic
        if (hasSensor && direction.equals("South")) {
            if (queue.size() > 10 && vehiclesToClear == 0) {
                vehiclesToClear = 10;
            }
            if (vehiclesToClear > 0) {
                System.out.println("----------------------------------------------------------- ");
                System.out.println("South sensor detected more than 10 vehicles. Light remains green.");
                while (vehiclesToClear > 0 && !queue.isEmpty()) {
                    Vehicle vehicle = queue.poll();
                    System.out.println("Processing vehicle " + vehicle.getLicensePlate() + " at " + direction + " road.");
                    vehiclesToClear--;
                }
                return;
            }
        }

        // East sensor logic
        if (hasSensor && direction.equals("East") && queue.isEmpty()) {
            System.out.println("----------------------------------------------------------- ");
            System.out.println("Sensor detected no vehicles on " + direction + " road. Light stays red.");
            System.out.println("----------------------------------------------------------- ");
            return;
        }

        // West sensor logic
        if (hasSensor && direction.equals("West")) {
            if (queue.size() > 10 && vehiclesToClear == 0) {
                vehiclesToClear = 10;
            }
            if (vehiclesToClear > 0) {
                System.out.println("West sensor detected more than 10 vehicles. Light remains green.");
                while (vehiclesToClear > 0 && !queue.isEmpty()) {
                    Vehicle vehicle = queue.poll();
                    System.out.println("Processing vehicle " + vehicle.getLicensePlate() + " at " + direction + " road.");
                    vehiclesToClear--;
                }
                return;
            }
            if (queue.isEmpty()) {
                System.out.println("Sensor detected no vehicles on " + direction + " road. Light stays red.");
                return;
            }
        }

        // North sensor logic
        if (hasSensor && direction.equals("North") && queue.size() < 5 && !queue.isEmpty()) {
            System.out.println("North sensor detected fewer than 5 vehicles. Light remains green until all vehicles have left.");
            while (!queue.isEmpty()) {
                Vehicle vehicle = queue.poll();
                System.out.println("Processing vehicle " + vehicle.getLicensePlate() + " at " + direction + " road.");
            }
            return;
        }

        // Default behavior when no special conditions are met
        if (!queue.isEmpty()) {
            System.out.println("----------------------------------------------------------- ");
            System.out.println("Green light for " + direction + " road.");
            Vehicle vehicle = queue.poll();
            System.out.println("Vehicle " + vehicle.getLicensePlate() + " processed.");
        } else {
            System.out.println("No vehicles on " + direction + " road. Light stays red.");
        }
    }
}
