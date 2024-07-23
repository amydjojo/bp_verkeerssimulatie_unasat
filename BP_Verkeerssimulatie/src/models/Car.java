package models;

public class Car {
    private String carName;
    private int carPriority;
    private String licensePlate;

    public Car(String carName, int carPriority, String licensePlate) {
        this.carName = carName;
        this.carPriority = carPriority;
        this.licensePlate = licensePlate;

    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarPriority() {
        return carPriority;
    }

    public void setCarPriority(int carPriority) {
        this.carPriority = carPriority;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carPriority=" + carPriority +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
