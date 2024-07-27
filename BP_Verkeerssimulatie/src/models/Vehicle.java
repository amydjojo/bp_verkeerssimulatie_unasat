package models;

public class Vehicle {
    private int sequenceNumber;
    private String licensePlate;

    public Vehicle(int sequenceNumber, String licensePlate) {
        this.sequenceNumber = sequenceNumber;
        this.licensePlate = licensePlate;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

