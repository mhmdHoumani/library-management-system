package Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Model.AlertMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddEmployeeController implements Initializable {

	@FXML
	private TextField empName, email, phoneNbr, employeeID;
	@FXML
	private PasswordField password;
	@FXML
	private Button saveBtn, cancelBtn;

	@FXML
	public void saveCancelAction(ActionEvent event) {
		if (event.getSource().equals(saveBtn)) {
			if (empName.getText().isEmpty() || employeeID.getText().isEmpty() || phoneNbr.getText().isEmpty()
					|| email.getText().isEmpty()) {
				AlertMaker.showWarningAlert("Invalid Inputs", "All field are REQUIRED for adding this employee");
			} else if (phoneNbr.getText().chars().allMatch(Character::isDigit)) {
				if (phoneNbr.getText().length() < 8) {
					AlertMaker.showWarningAlert("Invalid Phone Number", "The Phone Number should be at least 8 digits");
				} else {
					Optional<ButtonType> response = AlertMaker.showConfigurationAlert(null, "Proceed ?");
					if (response.get().equals(ButtonType.OK)) {
						AlertMaker.showInformationAlert("Save Member", "Employee added successfully to your list");
						Stage stage = (Stage) saveBtn.getScene().getWindow();
						stage.close();
					}
				}
			} else {
				AlertMaker.showWarningAlert("Invalid Phone Number", "The Phone Number should be contains only digits");
			}
		}
		if (event.getSource().equals(cancelBtn)) {
			Stage stage = (Stage) cancelBtn.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
