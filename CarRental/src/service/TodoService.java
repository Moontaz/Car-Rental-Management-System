package service;

import model.TodoModel;
import repository.TodoRepository;

import java.util.List;

public class TodoService {

    TodoRepository TR = new TodoRepository();

    public boolean insert(int idCar, String plateNumber, String brand,
                               String color, String seat, String transmition, String cost){
        try {
            TR.insert(idCar, plateNumber, brand, color, seat, transmition, cost);
            return true;
        }catch (Exception e){
//            System.out.println(e.toString());
            System.out.println(e);
            return false;
        }
    }

    public boolean writeCsv( String filepath, int idCar, String plateNumber, String brand,
                             String color, String seat, String transmition, String cost) {
        try {
            TR.writeCsv(filepath, idCar, plateNumber, brand, color, seat, transmition, cost);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

//    public TodoModel[] getTodo(){
//
//        return TR.getTodo();
//    }

    public void addSize(){
        TR.addSize();
    }
    public boolean readCsv(String filePath) {
        return TR.readCsv(filePath);
    }

    public void display(){
        TR.display();
    }

    public TodoModel find(int key){
        return TR.findId(key);
    }

    public TodoModel findPlate(String plate){
        return TR.findPlate(plate);
    }

    public TodoModel findBrand(String brand){
        return TR.findBrand(brand);
    }

    public TodoModel findColor(String color){
        return TR.findColor(color);
    }

    public TodoModel findSeat(String seat){
        return TR.findSeat(seat);
    }

    public TodoModel findTrans(String trans){
        return TR.findTrans(trans);
    }

    public TodoModel findCost(String cost){
        return TR.findCost(cost);
    }

    public TodoModel addCart(TodoModel data){
        return TR.addCart(data);
    }

    public List<TodoModel> getCart(){
        return TR.getCart();
    }

    public boolean deleteCart(){
        return TR.deleteCart();
    }

    public void delete(String filePath, int key){
        if(TR.delete(filePath, key)){
            System.out.println("Success to Delete Data");
        }else {
            System.out.println("Failed to Delete Data");
        }
    }
}
