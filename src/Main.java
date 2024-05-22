import controller.BukuController;
import view.BukuView;


public class Main {
    public static void main(String[] args){
        BukuController controller = new BukuController();
        BukuView view = new BukuView(controller);
        view.showMenu();
    
    }
    
}
