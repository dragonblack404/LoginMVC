package dad.login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

public class View extends GridPane{

	private Label userLabel = new Label("Usuario: ");
	private Label passwdLabel = new Label("Contraseña: ");
	private TextField userText = new TextField();
	private PasswordField passwdText = new PasswordField();
	private CheckBox checkLdap = new CheckBox("Usar LDAP");
	private Button accessButton = new Button("Acceder");
	private Button cancelButton = new Button("Cancelar");
	private HBox buttonsBox = new HBox();

	public View() {

		userText.setPromptText("Usuario");
		passwdText.setPromptText("Contraseña");

		addRow(0, userLabel, userText);
		addRow(1, passwdLabel, passwdText);
		addRow(2,  new Label(), checkLdap);
		add(buttonsBox, 0, 3,2,1);
		buttonsBox.getChildren().addAll(new HBox(5,accessButton, cancelButton));

		accessButton.setDefaultButton(true);
		
		setPadding(new Insets(5));
		setHgap(15);
		setVgap(15);
		setGridLinesVisible(false);
		setAlignment(Pos.CENTER);

		buttonsBox.setSpacing(10);
		buttonsBox.setAlignment(Pos.BASELINE_CENTER);

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints() };

		getColumnConstraints().setAll(cols);

		RowConstraints[] rows = { new RowConstraints(), new RowConstraints(), new RowConstraints() };

		getRowConstraints().setAll(rows);
	}

	public TextField getUser() {
		return userText;
	}

	public PasswordField getPassword() {

		return passwdText;
	}

	public Button getAccessButton() {
		return accessButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}
	
	public CheckBox getCheckLdap() {
		return checkLdap;
	}
	


}