package models;

import java.util.List;

public class Wegdek {


    private String wegdekNaam;
    private List<Car> carList;

    public String getWegdekNaam() {
        return wegdekNaam;
    }

    public void setWegdekNaam(String wegdekNaam) {
        this.wegdekNaam = wegdekNaam;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Wegdek(String wegdekNaam, List<Car> carList) {
        this.wegdekNaam = wegdekNaam;
        this.carList = carList;
    }
}
