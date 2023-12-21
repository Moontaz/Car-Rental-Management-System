import controller.Controller;
import service.TodoService;
import view.TodoView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        TodoService TS = new TodoService();
        Controller controller = new Controller(TS);
        TodoView todoView = new TodoView(controller);
        todoView.init();
    }
}