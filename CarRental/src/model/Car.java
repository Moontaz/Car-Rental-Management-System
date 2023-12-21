package model;

public class Car {
    private int idCar;
    private String plateNumber;
    private String brand;
    private String color;
    private String seat;
    private String transmition;
    private String cost;

    public Car(int idCar, String plateNumber, String brand, String color,
               String seat, String transmition, String cost) {
        this.idCar = idCar;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.color = color;
        this.seat = seat;
        this.transmition = transmition;
        this.cost = cost;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getTransmition() {
        return transmition;
    }

    public void setTransmition(String transmition) {
        this.transmition = transmition;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
