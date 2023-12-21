package controller;

import model.TodoModel;
import service.TodoService;

import java.util.List;

public class Controller {
    TodoService TS;

    public Controller(TodoService TS){
        this.TS=TS;
    }

    public void insert( String filepath, String idCarString, String plateNumber, String brand,
                         String color, String seat, String transmition, String cost) throws InterruptedException {
        String idCarTemp = "1" + idCarString;
        int idCar = Integer.parseInt(idCarTemp);
        var isHaveId = (TS.find(Integer.parseInt(idCarString)));
        var isHavePlate = (TS.findPlate(plateNumber));
        if(isHaveId != null){
            System.out.println("\nID Car has already taken\n");
            return;
        }
        if(isHavePlate != null){
            System.out.println("\nPlate Number has already taken\n");
            return;
        }

        var todo = TS.insert(idCar, plateNumber, brand, color, seat, transmition, cost);
        var write = TS.writeCsv(filepath, idCar, plateNumber, brand, color, seat, transmition, cost);

        if(todo){
            if(write){
                TS.addSize();
                for (int i = 0; i <= 35; i++) {
                    System.out.print("-");
                    Thread.sleep(200);
                    System.out.print("_");
                    Thread.sleep(200);
                    i++;
                }
                //METHOD WWRITE CSV DISINI MANGGIL DARI TS, TS KE REPO
                System.out.println();
                System.out.println("=======================================");
                System.out.println("            Success Add Data");
                System.out.println("=======================================");
                System.out.println();
            }else {
                System.out.println();
                System.out.println("=======================================");
                System.out.println("         Add to Database Error");
                System.out.println("=======================================");
                System.out.println();
            }
        }else {
            for (int i = 0; i <= 35; i++) {
                System.out.print("-");
                Thread.sleep(200);
                System.out.print("_");
                Thread.sleep(200);
                i++;
            }
            System.out.println();
            System.out.println("=======================================");
            System.out.println("               System Error");
            System.out.println("=======================================");
            System.out.println();
        }

    }

    public boolean readCsv(String filePath) {
        var isHave = TS.readCsv(filePath);
        return isHave;
    }


    public void display(){
        TS.display();
    }

    public TodoModel find(int idCar){
        return TS.find(idCar);
    }

    public TodoModel findPlate(String plate){
        return TS.findPlate(plate);
    }

    public TodoModel findBrand(String brand){
        return TS.findBrand(brand);
    }

    public TodoModel findColor(String color){
        return TS.findColor(color);
    }

    public TodoModel findSeat(String seat){
        return TS.findSeat(seat);
    }

    public TodoModel findTrans(String trans){
        return TS.findTrans(trans);
    }

    public TodoModel findCost(String cost){
        return TS.findCost(cost);
    }

    public void delete(String filePath, int idCar){
        TS.delete(filePath, idCar);
    }

    public TodoModel addCart(TodoModel data){
        return TS.addCart(data);
    }

    public List<TodoModel> getCart(){
        return TS.getCart();
    }

    public boolean deleteCart(){
        return TS.deleteCart();
    }
}
