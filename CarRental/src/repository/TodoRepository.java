package repository;

import model.TodoModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private TodoModel root;
    private TodoModel current;
    private TodoModel pointer;

    private List<TodoModel> cartUser;

    private int size;

    private int length;
    private String filePath;
    public TodoRepository() {
        this.size = 0;
        this.length = 0;
        this.cartUser = new ArrayList<>();
    }

    public boolean readCsv(String filePath) {
        String line = "";
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            size = countRows(filePath);
            int rows = countRows(filePath);
            int cols = countCols(filePath);

            boolean skipHeader = true;
            int row = 0;

            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] columns = line.split(csvSplitBy);
//                addSize();
                int idTemp = Integer.parseInt(columns[0]);
                insert(idTemp, columns [1], columns [2], columns [3], columns [4], columns [5], columns[6]);
                row++;
            }
            br.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Metode untuk menghitung jumlah baris dalam file CSV
    private static int countRows(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int rowCount = (int) br.lines().count();
            br.close();
            return rowCount - 1; // Mengurangkan satu untuk mengabaikan header
        }
    }

    // Metode untuk menghitung jumlah kolom dalam file CSV
    private static int countCols(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();
            br.close();
            return headerLine.split(";").length;
        }
    }

    public void writeCsv( String filepath, int idCar, String plateNumber, String brand,
                         String color, String seat, String transmition, String cost) {
        String line = "";
        this.filePath = filepath;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))) {
            // Menulis baris ke file CSV
            String idCarString = String.valueOf(idCar);
            String[] record = {idCarString, plateNumber, brand, color, seat, transmition, cost};
            for (int i = 0; i < record.length; i++) {
                writer.write(record[i]);
                if (i < record.length - 1) {
                    writer.write(";");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insert(int idCar, String plateNumber, String brand,
                            String color, String seat, String transmition, String cost){

//        TodoModel newLink = new TodoModel(idCar, plateNumber, brand,
//                color, seat, transmition, cost);
//        if (root == null) {
//            root = newLink;
//            current = root;
//            pointer = root;
//        } else {
//            TodoModel current = root;
//            TodoModel parent;
//            while (true) {
//                parent = current;
//                if (current.getPlateNumber().compareToIgnoreCase(plateNumber) > 0) {
//                    current = current.leftChild;
//                    if (current == null) {
//                        parent.leftChild = newLink;
//                        return;
//                    }
//                } else {
//                    current = current.rightChild;
//                    if (current == null) {
//                        parent.rightChild = newLink;
//                        return;
//                    }
//                }
//            }
//        }
        TodoModel newLink = new TodoModel(idCar, plateNumber, brand,
                color, seat, transmition, cost);
        if (root == null) {
            root = newLink;
            current = root;
            pointer = root;
        } else {
            TodoModel current = root;
            TodoModel parent;
            while (true) {
                parent = current;
                if (idCar < current.car.getIdCar()) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newLink;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newLink;
                        return;
                    }
                }
            }
        }
    }
    public void display(){
        if (root != null) {
            System.out.println("ID Car"+"\tPlate Number"+"\tBrand"+"\t\tColor"+
                    "\t\tSeat Size"+"\tTransmition Type"+"\tCost per day");
            displayData(root);
        }
    }

    private void displayData(TodoModel localRoot) {
        if (localRoot != null) {
            displayData(localRoot.leftChild);
            localRoot.display();
            displayData(localRoot.rightChild);
        }
    }

    public void addSize(){
        size++;
    }

    private int getSize() {
        return size;
    }

    public TodoModel findId(int idCar){
        String idCarString = "1" + idCar;
        idCar = Integer.parseInt(idCarString);
        TodoModel temp = root;
        while (temp.car.getIdCar() != idCar) {
            if (idCar < temp.car.getIdCar()) {
                temp = temp.leftChild;
            } else {
                temp = temp.rightChild;
            }
            if (temp == null) {
                return null;
            }
        }
        return temp;

    }

//    public TodoModel idCar(TodoModel localroot, int idCar) {
//        if (localroot == null) {
//            return null;  // Jika mencapai leaf node tanpa menemukan target
//        }
//
//        // Cari di sub-pohon kiri
//        TodoModel leftResult = idCar(localroot.leftChild, idCar);
//        if (leftResult != null) {
//            return leftResult;
//        }
//
//        // Cek node saat ini
//        if (localroot.car.getIdCar() == idCar) {
//            return localroot;  // Target ditemukan di node saat ini
//        }
//
//        // Cari di sub-pohon kanan
//        return idCar(localroot.rightChild, idCar);
//    }

    public TodoModel findPlate(String plate){
        return plate(root, plate);
    }
    public TodoModel plate(TodoModel localroot, String plate) {
        if (localroot == null) {
            return null;  // Jika mencapai leaf node tanpa menemukan target
        }

        // Cari di sub-pohon kiri
        TodoModel leftResult = plate(localroot.leftChild, plate);
        if (leftResult != null) {
            return leftResult;
        }

        // Cek node saat ini
        if (localroot.car.getPlateNumber().equalsIgnoreCase(plate)) {
            return localroot;  // Target ditemukan di node saat ini
        }

        // Cari di sub-pohon kanan
        return plate(localroot.rightChild, plate);
    }

public TodoModel findBrand(String brand){
        return brand(root, brand);
}
public TodoModel brand(TodoModel localroot, String brand) {
        if (localroot == null) {
            return null;  // Jika mencapai leaf node  atau ujung node tanpa menemukan target
        }

        // Cari di sub-pohon kiri
        TodoModel leftResult = brand(localroot.leftChild, brand);
        if (leftResult != null) {
            return leftResult;
        }

        // Cek node saat ini
        if (localroot.car.getBrand().equalsIgnoreCase(brand)) {
            localroot.display();  // Target ditemukan di node saat ini
        }

        // Cari di sub-pohon kanan
        return brand(localroot.rightChild, brand);
    }

    public TodoModel findColor(String color){
        return color(root, color);
    }
    public TodoModel color(TodoModel localroot, String color) {
        if (localroot == null) {
            return null;  // Jika mencapai leaf node atau ujung node tanpa menemukan target
        }

        // Cari di sub-pohon kiri
        TodoModel leftResult = color(localroot.leftChild, color);
        if (leftResult != null) {
            return leftResult;
        }

        // Cek node saat ini
        if (localroot.car.getColor().equalsIgnoreCase(color)) {
            localroot.display();  // Target ditemukan di node saat ini
        }

        // Cari di sub-pohon kanan
        return color(localroot.rightChild, color);
    }

    public TodoModel findSeat(String seat){
        return seat(root, seat);
    }
    public TodoModel seat(TodoModel localroot, String seat) {
        if (localroot == null) {
            return null;  // Jika mencapai leaf node tanpa menemukan target
        }

        // Cari di sub-pohon kiri
        TodoModel leftResult = seat(localroot.leftChild, seat);
        if (leftResult != null) {
            return leftResult;
        }

        // Cek node saat ini
        if (localroot.car.getSeat().equalsIgnoreCase(seat)) {
            localroot.display();  // Target ditemukan di node saat ini
        }

        // Cari di sub-pohon kanan
        return seat(localroot.rightChild, seat);
    }

    public TodoModel findTrans(String trans){
        return trans(root, trans);
    }
    public TodoModel trans(TodoModel localroot, String trans) {
        if (localroot == null) {
            return null;  // Jika mencapai leaf node tanpa menemukan target
        }

        // Cari di sub-pohon kiri
        TodoModel leftResult = trans(localroot.leftChild, trans);
        if (leftResult != null) {
            return leftResult;
        }

        // Cek node saat ini
        if (localroot.car.getTransmition().equalsIgnoreCase(trans)) {
            localroot.display();  // Target ditemukan di node saat ini
        }

        // Cari di sub-pohon kanan
        return trans(localroot.rightChild, trans);
    }

    public TodoModel findCost(String cost){
        int costNumber = Integer.parseInt(cost);
        return cost(root, costNumber);
    }
    public TodoModel cost(TodoModel localroot, int cost) {
        if (localroot == null) {
            return null;  // Jika mencapai leaf node tanpa menemukan target
        }

        // Cari di sub-pohon kiri
        TodoModel leftResult = cost(localroot.leftChild, cost);
        if (leftResult != null) {
            return leftResult;
        }

        // Cek node saat ini
        if (Integer.parseInt(localroot.car.getCost())<= cost) {
            localroot.display();  // Target ditemukan di node saat ini
        }

        // Cari di sub-pohon kanan
        return cost(localroot.rightChild, cost);
    }

public TodoModel addCart(TodoModel data){
        for(TodoModel dataCart : cartUser){
            if (dataCart == data){
                return data;
            }
        }
        cartUser.add(data);
        return null;
}

public List<TodoModel> getCart(){
        return this.cartUser;
}

public boolean deleteCart(){
        if (cartUser != null) {
            cartUser = null;
            cartUser = new ArrayList<>();
            return true;
        }else {
            return false;
        }
}
public boolean delete(String filePath, int key) {
    TodoModel current = root;
    TodoModel parent = root;
    boolean isLeftChild = true;

    while (current.car.getIdCar() != key) {
        parent = current;
        if (key < current.car.getIdCar()) {
            isLeftChild = true;
            current = current.leftChild;
        } else {
            isLeftChild = false;
            current = current.rightChild;
        }
        if (current == null) {
            return false;
        }
    }
    if (current.leftChild == null && current.rightChild == null) {
        if (current == root) {
            root = null;
        } else if (isLeftChild) {
            parent.leftChild = current.leftChild;
        } else {
            parent.rightChild = current.leftChild;
        }
    } else if (current.rightChild == null) {
        if (current == root) {
            root = current.leftChild;

        } else if (isLeftChild) {
            parent.leftChild = current.leftChild;
        } else {
            parent.rightChild = current.leftChild;
        }
    } else if (current.leftChild == null) {
        if (current == root) {
            root = current.rightChild;
        } else if (isLeftChild) {
            parent.leftChild = current.rightChild;
        } else {
            parent.rightChild = current.rightChild;
        }
    } else {
        TodoModel successor = getSuccessor(current);
        if (current == root) {
            root = successor;
        } else if (isLeftChild) {
            parent.leftChild = successor;
        } else {
            parent.rightChild = successor;
        }
        successor.leftChild = current.leftChild;
    }
    try {
        // Read the CSV file into memory
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        List<String> lines = new ArrayList<>();

        String line;
        String value = String.valueOf(key);
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.contains(value)) {
                lines.add(line);
            }
        }

        bufferedReader.close();

        // Write the modified data back to the CSV file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        for (String updatedLine : lines) {
            bufferedWriter.write(updatedLine);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return true;
}
    private TodoModel getSuccessor(TodoModel delNode) {
        TodoModel successorParent = delNode;
        TodoModel successor = delNode;
        TodoModel current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

//    public void displayTree() {
//        Stack globalStack = new Stack();
//        globalStack.push(root);
//        int nBlanks = 32;
//        boolean isRowEmpty = false;
//        System.out.println("............................................");
//        while (isRowEmpty == false) {
//            Stack localStack = new Stack();
//            isRowEmpty = true;
//            for (int j = 0; j < nBlanks; j++) {
//                System.out.print(' ');
//            }
//            while (globalStack.isEmpty() == false) {
//                TodoModel temp = (TodoModel) globalStack.pop();
//                if (temp != null) {
//                System.out.print(temp.car.getIdCar());
//                localStack.push(temp.leftChild);
//                localStack.push(temp.rightChild);
//                if (temp.leftChild != null || temp.rightChild != null) {
//                    isRowEmpty = false;
//                    }
//                } else {
//                System.out.print("--");
//                localStack.push(null);
//                localStack.push(null);
//                }
//                for (int j = 0; j < nBlanks * 2 - 2; j++) {
//                    System.out.print(' ');
//                }
//            }
//            System.out.println();
//            nBlanks /= 2;
//            while (localStack.isEmpty() == false) {
//                globalStack.push(localStack.pop());
//            }
//        }
//        System.out.println(
//                "............................................");
//    }
}
