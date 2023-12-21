package model;

public class TodoModel {
    public Car car;
//    public TodoModel parent;
    public TodoModel rightChild;
    public TodoModel leftChild;
//    public TodoModel next;
//    public TodoModel item;

    public TodoModel(int idCar, String plateNumber, String brand,
                     String color, String seat, String transmition, String cost) {

        this.car = new Car(idCar, plateNumber, brand,
                color, seat, transmition, cost);
    }
    public void display() {
        String idCarString = String.valueOf(car.getIdCar());
        System.out.println(idCarString.substring(1) + "\t\t" + car.getPlateNumber() + "\t\t"  + car.getBrand() + "\t\t"
                + car.getColor() + "\t\t"  + car.getSeat() + "\t\t\t\t"  + car.getTransmition() + "\t\t\t" + car.getCost());
    }

}