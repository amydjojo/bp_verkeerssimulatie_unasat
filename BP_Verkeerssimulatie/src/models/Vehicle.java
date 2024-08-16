package models;

//vehicle class
public class Vehicle {
    private int sequenceNumber;
    private String licensePlate;
    private int priority;

    public Vehicle(int sequenceNumber, String licensePlate, int priority) {
        this.sequenceNumber = sequenceNumber;
        this.licensePlate = licensePlate;
        this.priority = priority;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getPriority() {
        return priority;
    }
}
