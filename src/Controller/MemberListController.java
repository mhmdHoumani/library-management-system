package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberListController implements Initializable {

	@FXML
	private TableView<Member> tableView;
	@FXML
	private TableColumn<Member, String> nameColumn, idColumn, phoneNbrColumn, emailColumn, addressColumn;
	private ObservableList<Member> members = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
		phoneNbrColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNbr"));
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
		members.add(new Member("Mohamad Houmani", "MH1999", "81789581", "mhmd@hotmail.com", "Bir el Abed"));
		members.add(new Member("John Legend", "JL2000", "81010203", "john@hotmail.com", "Bir el Abed"));
		members.add(new Member("Jack Newmann", "JN1990", "78707172", "jack@hotmail.com", "Bir el Abed"));
		members.add(new Member("Carla Jackson", "CJ1993", "70809040", "carla@hotmail.com", "Bir el Abed"));
		members.add(new Member("Jane", "J2002", "03040506", "jane@hotmail.com", "Bir el Abed"));
		members.add(new Member("Samir", "S1985", "71000111", "samir@hotmail.com", "Bir el Abed"));
		members.add(new Member("Danielle", "D2005", "71727374", "danielle@hotmail.com", "Bir el Abed"));
		tableView.getItems().setAll(members);
	}

	@FXML
	void handleBookDelete(ActionEvent event) {
	}

	@FXML
	void handleRefresh(ActionEvent event) {
	}

	@FXML
	void handleBookEdit(ActionEvent event) {
	}

}
