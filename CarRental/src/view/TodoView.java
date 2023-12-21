package view;

import controller.Controller;
import model.TodoModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TodoView {
    BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    Controller controller;

    public TodoView(Controller controller){
        this.controller=controller;
    }

    public void displayTodo() {
        controller.display();
    }

    public void addTodo(String filepath) throws IOException, InterruptedException {
        String idCar = null;
        String plateNumber = null;
        String brand = null;
        String color = null;
        String seat = null;
        String transmition = null;
        String cost = null;

        System.out.println("Please Input Data");
        while(true) {
            System.out.print("Input 3 Digits ID Car: ");
            idCar = scanner.readLine();
            int idCarInt = 0;
            try {
                idCarInt = Integer.parseInt(idCar);
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Use Number Only");
                continue;
            }
            var dataTemp = controller.find(idCarInt);
            if (dataTemp != null) {
                System.out.println("This ID Car Has Already Taken");
            }else{
                while (true) {
                    System.out.print("Input Plate Number: ");
                    plateNumber = scanner.readLine();
                    var dataTemp2 = controller.findPlate(plateNumber);
                    if (dataTemp2 != null) {
                        System.out.println("This Plate Number Has Already Taken");
                    } else {
                        break;
                    }
                }
                break;
            }
        }

        if (!plateNumber.isEmpty() || !idCar.isEmpty()){
            System.out.print("Input Brand Name: ");
            brand = scanner.readLine();
            if (brand.isEmpty()){
                brand = "-";
            }

            System.out.print("Input Color Type: ");
            color = scanner.readLine();
            if (color.isEmpty()){
                color = "-";
            }

            System.out.print("Input Seat Size: ");
            seat = scanner.readLine();
            if (seat.isEmpty()){
                seat = "-";
            }

            System.out.println("Information");
            System.out.println("1. Manual");
            System.out.println("2. Matic");
            System.out.println("Please Input Number");
            System.out.print("Input Transmition Type: ");
            String trans = (scanner.readLine());
                if (trans.equals("1")) {
                    transmition = "Manual";
                } else if (trans.equals("2")) {
                    transmition = "Matic";
                } else {
                    transmition = "-";
                }
            System.out.print("Input Cost per day: ");
            cost = scanner.readLine();
            if (cost.isEmpty()){
                cost = "-";
            }
            controller.insert(filepath, idCar, plateNumber, brand, color, seat, transmition, cost);
        }else {
            System.out.println("Error: Input cannot be Continued");
        }
    }

    public void deleteTodo(String filePath) throws IOException{
        System.out.print("Input 3 Digits ID Car: ");
        String id = "1" + scanner.readLine();
        int idCar = Integer.parseInt(id);
        System.out.println();
        controller.delete(filePath, idCar);
    }

    public void find() throws IOException{
        System.out.println("=============Search By=============");
        System.out.println("1. ID Car");
        System.out.println("2. Plate Number");
        System.out.println("3. Brand");
        System.out.println("4. Color");
        System.out.println("5. Seat");
        System.out.println("6. Transmition");
        System.out.println("7. Maximum Cost");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Your Input: ");
        String input = scanner.readLine();
        if (input.equals("1")) {
            while (true) {
                System.out.print("Input 3 Digits ID Car: ");
                try {
                    int key = Integer.parseInt(scanner.readLine());
                    System.out.println();
                    TodoModel findKey = controller.find(key);
                    if (findKey != null) {
                        System.out.println("\t\t(((Data Has Found)))");
                        System.out.println();

                        System.out.println("ID Car" + "\tPlate Number" + "\tBrand" + "\tColor" +
                                "\tSeat Size" + "\tTransmition Type" + "\tCost per day");
                        findKey.display();
                    } else {
                        System.out.println("Data Not Found");
                        System.out.println();
                    }
                    break;
                }catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Use Number Only");
                }
            }
        } else if (input.equals("2")) {
            System.out.print("Input Plate Number: ");
            String key = scanner.readLine();
            System.out.println();
            TodoModel findKey = controller.findPlate(key);
            if (findKey != null) {
                System.out.println("\t\t(((Data Has Found)))");
                System.out.println();

                System.out.println("ID Car" + "\tPlate Number" + "\tBrand" + "\tColor" +
                        "\tSeat Size" + "\tTransmition Type" + "\tCost per day");
                findKey.display();
            } else {
                System.out.println("Data Not Found");
            }
        } else if (input.equals("3")) {
            System.out.print("Input Brand: ");
            String brand = scanner.readLine();
            System.out.println();
            System.out.println("ID Car" + "\tPlate Number" + "\tBrand" + "\tColor" +
                    "\tSeat Size" + "\tTransmition Type" + "\tCost per day");
            controller.findBrand(brand);
        }else if (input.equals("4")) {
            System.out.print("Input Color: ");
            String color = scanner.readLine();
            System.out.println();
            System.out.println("ID Car" + "\tPlate Number" + "\tBrand" + "\tColor" +
                    "\tSeat Size" + "\tTransmition Type" + "\tCost per day");
            controller.findColor(color);
        } else if (input.equals("5")) {
            System.out.print("Input Seat: ");
            String seat = scanner.readLine();
            System.out.println();
            System.out.println("ID Car" + "\tPlate Number" + "\tBrand" + "\tColor" +
                    "\tSeat Size" + "\tTransmition Type" + "\tCost per day");
            controller.findSeat(seat);
        } else if (input.equals("6")) {
            System.out.println("Information");
            System.out.println("1. Manual");
            System.out.println("2. Matic");
            System.out.println("Please Input Number");
            System.out.print("Input Transmition: ");
            String trans = (scanner.readLine());
            if (trans.equals("1")) {
                trans = "Manual";
            } else if (trans.equals("2")) {
                trans = "Matic";
            } else {
                System.out.println("Eror: Input Invalid");
                return;
            }
            System.out.println();
            System.out.println("ID Car" + "\tPlate Number" + "\tBrand" + "\tColor" +
                    "\tSeat Size" + "\tTransmition Type" + "\tCost per day");
            controller.findTrans(trans);
        } else if (input.equals("7")) {
            System.out.print("Input Maximum Cost: ");
            String cost = scanner.readLine();
            System.out.println();
            System.out.println("ID Car" + "\tPlate Number" + "\tBrand" + "\tColor" +
                    "\tSeat Size" + "\tTransmition Type" + "\tCost per day");
            controller.findCost(cost);
        } else {
            System.out.println("Eror: Input Invalid");
        }
    }

    public void update(){

    }

    public void developer(String filePath) throws IOException, InterruptedException {
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("               NyewaYuk!              |");
            System.out.println("            List of Options           |");
            System.out.println("1. View                               |");
            System.out.println("2. Add                                |");
            System.out.println("3. Delete                             |");
            System.out.println("4. Find                               |");
            System.out.println("0. Exit                               |");
            System.out.println("---------------------------------------");
            System.out.print("Input Option Number: ");
            String pilihan = scanner.readLine();

            System.out.println();
            if (pilihan.equals("1")){
                for (int i = 0; i <= 35; i++) {
                    System.out.print("-");
                    Thread.sleep(50);
                    System.out.print("_");
                    Thread.sleep(50);
                    i++;
                }
                System.out.println();
                displayTodo();
            }else if (pilihan.equals("2")){
                System.out.println();
                addTodo(filePath);
            }else if (pilihan.equals("3")){
                deleteTodo(filePath);
            }else if (pilihan.equals("4")){
                find();
            }else if (pilihan.equals("0")){
                break;
            }else {
                System.out.println("Error: Input Invalid");
            }
        }
    }

    public void addCart() throws IOException {
        boolean exit = false;
        while (!exit){
            System.out.print("Input 3 Digits ID Car: ");
            String id = "1" + scanner.readLine();
            int idCarKey = Integer.parseInt(id);
            TodoModel data = controller.find(idCarKey);
            if (data != null){
                System.out.println("Data Found");
                var isHave = controller.addCart(data);
                if (isHave != null){
                    System.out.println(data.car.getIdCar() + " Has Already in Cart");
                }else {
                    System.out.println("Success Add to Cart");
                }
            }else {
                System.out.println("Data not Found");
            }
            while (true){
                System.out.println("provide input once more?(y/n) ");
                String again = scanner.readLine();
                if (again.equalsIgnoreCase("y")){
                    break;
                } else if (again.equalsIgnoreCase("n")) {
                    exit = true;
                    break;
                }else {
                    System.out.println("Error: Input Invalid");
                }
            }

        }
    }

    public void viewCart(){
        List<TodoModel> cart = controller.getCart();
        if (cart !=null){
            System.out.println("ID Car"+"\tPlate Number"+"\tBrand"+"\tColor"+
                    "\tSeat Size"+"\tTransmition Type"+"\tCost per day");
            for (TodoModel data : cart){
                data.display();
            }
            System.out.println();
        }else {
            System.out.println("Cart is Empty");
        }
    }

    public void deleteCart(){
        boolean dataCart = controller.deleteCart();
        if (dataCart){
            System.out.println("Cart has Deleted");
        }else {
            System.out.println("Cart is Empty");
        }
    }

    public void receiptUser() throws IOException {
        List <TodoModel> cart = controller.getCart();
        if(!cart.isEmpty()){
            int costAll = 0;
            for (TodoModel data : cart){
                costAll += Integer.parseInt(data.car.getCost());
            }

            System.out.println("ID Car"+"\tPlate Number"+"\tBrand"+"\tColor"+
                    "\tSeat Size"+"\tTransmition Type"+"\tCost per day");
            for (TodoModel data : cart){
                data.display();
            }
            System.out.println();
            System.out.print("Input The Number of Days: ");
            int day = Integer.parseInt(scanner.readLine());
            costAll = costAll*day;
            System.out.println();
            System.out.println("Number of Day : " + day);
            System.out.println("Total Cost    : " + costAll);
        }else {
            System.out.println("Cart is Empty");
        }
    }

    public void user() throws InterruptedException, IOException {
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("               NyewaYuk!              |");
            System.out.println("            List of Options           |");
            System.out.println("1. View Car List                      |");
            System.out.println("2. Find Data                          |");
            System.out.println("3. Add to Cart                        |");
            System.out.println("4. View Cart                          |");
            System.out.println("5. Delete Cart                        |");
            System.out.println("6. Payment Receipt                    |");
            System.out.println("0. Exit                               |");
            System.out.println("---------------------------------------");
            System.out.print("Input Option Number: ");
            String pilihan = scanner.readLine();

            System.out.println();
            if (pilihan.equals("1")){
                for (int i = 0; i <= 35; i++) {
                    System.out.print("-");
                    Thread.sleep(50);
                    System.out.print("_");
                    Thread.sleep(50);
                    i++;
                }
                System.out.println();
                displayTodo();
            }else if (pilihan.equals("2")){
                System.out.println();
                find();
            }else if (pilihan.equals("3")){
                System.out.println();
                addCart();
            }else if (pilihan.equals("4")){
                System.out.println();
                viewCart();
            }else if (pilihan.equals("5")){
                System.out.println();
                deleteCart();
            }else if (pilihan.equals("6")){
                System.out.println();
                receiptUser();
                break;
            }else if (pilihan.equals("0")){
                break;
            }else {
                System.out.println("Error: Input Invalid");
            }
        }
    }

    public void init() throws IOException, InterruptedException {
        //change this path to mydata.csv path location
        String filePath = "C:/Users/USER/IdeaProjects/CarRental/src/mydata.csv";
        if(controller.readCsv(filePath)){
            System.out.println("SUCCESS READ DATA");
        }
        System.out.println("==============Welcome in===============");
        System.out.println("===============NyewaYuk!===============");
        System.out.println();

        while (true){
            System.out.println("             Please Choose!            ");
            System.out.println("       (0)User or (1)Developer         ");
            System.out.println("---------------------------------------");
            System.out.println();
            System.out.print("Input Option Number: ");
            String pil = scanner.readLine();
            if (pil.equals("0")){
                user();
                break;
            } else if (pil.equals("1")) {
                developer(filePath);
                break;
            }else {
                System.out.println("Error: Input Invalid");
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("           We Are Here For U          |");
        System.out.println("---------------------------------------");
    }
}