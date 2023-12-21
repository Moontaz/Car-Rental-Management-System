package validator;

import model.TodoModel;

public class TodoValidator {
    public static boolean cekId(TodoModel[] datas, int idCar){
        for (int i = 0; i < datas.length; i++) {
            if(datas[i]!=null){
                if(datas[i].car.getIdCar()==idCar){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cekPlateNumber(String plateNumber){

        return true;
    }
}
