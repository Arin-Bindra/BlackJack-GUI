package black_jack_casino;

/*
 *
 * Arin Bindra
 * 
 */

/**
* 
* The table main class holds the main method of the package, and creates a
* relationship between the model, view, and controller classes.
* 
**/

public class TableMain {
    
       public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        model.addObserver(view);
    }
}
