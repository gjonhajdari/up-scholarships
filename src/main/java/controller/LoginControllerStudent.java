package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import service.Navigator;

public class LoginControllerStudent {
  @FXML
  private TextField txtStudentId;
  @FXML
  private PasswordField pwdPassword;

  @FXML
  private void handleLoginStudentClick(MouseEvent me) {
    Navigator.navigate(me, Navigator.DASHBOARD_STUDENT);
  }
}
