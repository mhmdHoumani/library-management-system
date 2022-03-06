package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;

import com.jfoenix.controls.JFXToggleButton;

import Model.AlertMaker;
import Model.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button loginBtn;
	@FXML
	private JFXToggleButton isAdmin;

	private Preferences pref;
	public static boolean admin = false;

	@FXML
	private void loginAction(ActionEvent event) {
		if (username.getText().isEmpty() || password.getText().isEmpty())
			AlertMaker.showWarningAlert(null, "Username and password are REQUIRED to login");
		else {
			if (isAdmin.isSelected()) {
				admin = true;
				pref = Preferences.getConfigurations();
				String user = username.getText();
				String pass = DigestUtils.shaHex(password.getText());
				if (user.equals(pref.getUsername()) && pass.equals(pref.getPassword())) {
					try {
						Parent parent = FXMLLoader.load(getClass().getResource("/View/AdminView.fxml"));
						Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						stage.setTitle("Admin");
						stage.setScene(new Scene(parent));
						stage.setMinHeight(440);
						stage.setMinWidth(615);
						stage.show();
					} catch (IOException e) {
						AlertMaker.showErrorAlert("Opps",
								"Something went wrong while logging in.\nPlease try again in a minute.");
						e.printStackTrace();
					}
				} else {
					AlertMaker.showWarningAlert("Attention", "Invalid username or password");
				}
			} else {
				admin = false;
				if (username.getText().equals("Mhmd") && password.getText().equals("mhmd@123")) {
					try {
						Parent parent = FXMLLoader.load(getClass().getResource("/View/MainView.fxml"));
						Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						stage.setTitle("Home");
						stage.setScene(new Scene(parent));
						stage.setMinHeight(440);
						stage.setMinWidth(615);
						stage.show();
					} catch (IOException e) {
						AlertMaker.showErrorAlert("Opps",
								"Something went wrong while logging in.\nPlease try again in a minute.");
						e.printStackTrace();
					}
				}
				else {
					AlertMaker.showWarningAlert("Attention", "Invalid username or password");
				}
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
