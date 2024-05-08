package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import service.Navigator;

public class HomeController {
  @FXML
  private Button btnStudent;
  @FXML
  private Button btnAdmin;

  @FXML
  private void handleStudentClick(MouseEvent me) {
    Navigator.navigate(me, Navigator.LOGIN_PAGE_STUDENT);
  }

  @FXML
  private void handleAdminClick(MouseEvent me) {
    Navigator.navigate(me, Navigator.LOGIN_PAGE_ADMIN);
  }
}
