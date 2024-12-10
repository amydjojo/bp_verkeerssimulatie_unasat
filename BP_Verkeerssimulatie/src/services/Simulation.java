package services;

import models.TrafficLight;
import models.Vehicle;
import datastructures.CustomQueue;
import queue.VehicleQueue;
import datastructures.VehicleStack;

public class Simulation {
    private TrafficLight northLight;
    private TrafficLight southLight;
    private TrafficLight eastLight;
    private TrafficLight westLight;

    private VehicleQueue vehicleQueue;
    private VehicleStack playbackStack;

    public Simulation() {
        vehicleQueue = new VehicleQueue();
        playbackStack = new VehicleStack(100);

        northLight = new TrafficLight("North", true);
        southLight = new TrafficLight("South", true);
        eastLight = new TrafficLight("East", true);
        westLight = new TrafficLight("West", true);
    }

    public void simulate() {
        int cycles = 0;

        processPriority1Vehicles();
        processPriority2Vehicles();
        processPriority3Vehicles();

        while (!vehicleQueue.getNorthQueue().isEmpty() || !vehicleQueue.getSouthQueue().isEmpty() ||
                !vehicleQueue.getEastQueue().isEmpty() || !vehicleQueue.getWestQueue().isEmpty()) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Cycle " + (++cycles));
            System.out.println("-------------------------------------------------------------------------");

            // Simulate North
            processVehiclesForPlayback(vehicleQueue.getNorthQueue(), "North");
            northLight.simulateTraffic(vehicleQueue.getNorthQueue());
            northLight.incrementCycleCount();

            // Simulate South
            processVehiclesForPlayback(vehicleQueue.getSouthQueue(), "South");
            southLight.simulateTraffic(vehicleQueue.getSouthQueue());
            southLight.incrementCycleCount();

            // Simulate East
            processVehiclesForPlayback(vehicleQueue.getEastQueue(), "East");
            eastLight.simulateTraffic(vehicleQueue.getEastQueue());
            eastLight.incrementCycleCount();

            // Simulate West
            processVehiclesForPlayback(vehicleQueue.getWestQueue(), "West");
            westLight.simulateTraffic(vehicleQueue.getWestQueue());
            westLight.incrementCycleCount();
        }

        System.out.println("Simulation complete.");
        System.out.println("North Light Cycles: " + northLight.getCycleCount());
        System.out.println("South Light Cycles: " + southLight.getCycleCount());
        System.out.println("East Light Cycles: " + eastLight.getCycleCount());
        System.out.println("West Light Cycles: " + westLight.getCycleCount());

        reversePlayback();
    }

    private boolean processPriorityVehicles(CustomQueue queue, int priority) {
        boolean processed = false;

        CustomQueue tempQueue = new CustomQueue();
        while (!queue.isEmpty()) {
            Vehicle vehicle = queue.poll();
            if (vehicle.getPriority() == priority) {
                System.out.println(" priority " + priority + " vehicle: " + vehicle.getLicensePlate());
                processed = true;
                playbackStack.push(vehicle, getQueueDirection(queue));
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

    private void processVehiclesForPlayback(CustomQueue queue, String direction) {
        CustomQueue tempQueue = new CustomQueue();

        while (!queue.isEmpty()) {
            Vehicle vehicle = queue.poll();
            playbackStack.push(vehicle, direction);
            tempQueue.add(vehicle);
        }

        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.poll());
        }
    }

    private void reversePlayback() {
        System.out.println("Starting reverse playback");
        while (!playbackStack.isEmpty()) {
            Vehicle vehicle = playbackStack.pop();
            String direction = playbackStack.popDirection();
            System.out.println("Playback vehicle: " + vehicle.getLicensePlate() + " with " + vehicle.getPriority() + " priority from " + direction + " road.");
        }
    }

    // Helper method to get the direction from the queue object
    private String getQueueDirection(CustomQueue queue) {
        if (queue == vehicleQueue.getNorthQueue()) return "North";
        if (queue == vehicleQueue.getSouthQueue()) return "South";
        if (queue == vehicleQueue.getEastQueue()) return "East";
        if (queue == vehicleQueue.getWestQueue()) return "West";
        return "Unknown";
    }
}
