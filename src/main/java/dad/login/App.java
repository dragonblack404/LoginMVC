package dad.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	public static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		
		App.primaryStage = primaryStage;
		
		Controller controller = new Controller();
		Scene scene = new Scene(controller.getView(), 300, 250);
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}