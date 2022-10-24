package dad.login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

	private View view = new View();
	private Model model = new Model();

	public Controller() {
		view.getAccessButton().setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				try {
					boolean isValid = model.checkLogin(view.getUser(), view.getPassword());
					if (isValid) {
						mostrarAlert(AlertType.INFORMATION, "Acceso permitido",
								"Las credenciales de acceso son válidas.");
					} else {
						mostrarAlert(AlertType.ERROR, "Acceso denegado",
								"El usuario y/o contraseña no son válidos.");
					}
				} catch (Exception e) {
					mostrarAlert(AlertType.ERROR, "Error", e.getMessage());
				}
			};

		});

		view.getCancelButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				view.getCancelButton().setOnAction(e -> Platform.exit());
			}
		});
	}
	
	public static void mostrarAlert(AlertType tipoAlerta, String cabecera, String contenido) {
		Alert alert = new Alert(tipoAlerta);
		alert.setTitle("Iniciar sesión");
		alert.setHeaderText(cabecera);
		alert.setContentText(contenido);
		
		alert.showAndWait();
	}

	public View getView() {
		return view;
	}

}