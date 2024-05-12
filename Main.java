import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application
{
    public static void main( String args[] )
    {
        // The main method only gets used when launching from the command line
        // launch initialises the system and then calls start
        // In BlueJ, BlueJ calls start itself
        launch(args);
    }

    public void start(Stage window) 
    {
        // set up debugging and print initial debugging message
        Debug.set(true);             
        Debug.trace("atm starting"); 
        Debug.trace("Main::start");
        //make the window a fixed size
        window.setResizable(false);

        // Create a Bank object for this ATM
        Bank b = new Bank();
        // add some test bank accounts
        b.addBankAccount(10001, 11111, 100);
        b.addBankAccount(10002, 22222, 50);
        b.addBankAccount(1, 1, 200);

        // Create the Model, View and Controller objects
        Model model = new Model(b);   // the model needs the Bank object to 'talk to' the bank
        View  view  = new View();
        Controller controller  = new Controller();

        // Link them together so they can talk to each other
        // Each one has instances variable for the other two
        model.view = view;
        model.controller = controller;
        
        controller.model = model;
        controller.view = view;
        
        view.model = model;
        view.controller = controller;

        // start up the GUI (view), and then tell the model to initialise and display itself
        view.start(window);
        model.initialise("Welcome to the ATM"); 
        model.display();   

        // application is now running
        Debug.trace("atm running"); 
    }
}
