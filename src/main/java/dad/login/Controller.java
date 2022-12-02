package dad.login;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

	private View view = new View();
	private Model model = new Model();

	public Controller() {

		// bindings

		model.userProperty().bind(view.getUser().textProperty());
		model.passProperty().bindBidirectional(view.getPassword().textProperty());
		model.useLdapProperty().bind(view.getCheckLdap().selectedProperty());

		// listeners

		view.getAccessButton().setOnAction(this::onAccessAction);
		view.getCancelButton().setOnAction(this::onCancelAction);

	}

	private void onAccessAction(ActionEvent e) {
		AuthService auth = model.isUseLdap() ? new LdapAuthService() : new FileAuthService();

		try {
			if (model.getPass() != null && model.getUser() != null && auth.login(model.getUser(), model.getPass())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Inicar sesión");
				alert.setHeaderText("Acceso permitido");
				alert.setContentText("Las credenciales de acceso son válidas");
				alert.showAndWait();
				App.primaryStage.close();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Inicar sersión");
				alert.setHeaderText("Acceso denegado");
				alert.setContentText("El usuario y/o la contraseña no son válidos");
				alert.showAndWait();
				model.setPass(null);
			}
		} catch (Exception e2) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText(e2.getMessage());
			alert.showAndWait();
			e2.printStackTrace();
		}

	}

	private void onCancelAction(ActionEvent e) {
		App.primaryStage.close();
	}

	public View getView() {
		return view;
	}

	public Model getModel() {
		return model;
	}

}