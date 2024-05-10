package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.dto.LoginUserDto;
import service.Navigator;
import service.UserService;

public class LoginControllerStudent {
  @FXML
  private TextField txtStudentId;
  @FXML
  private PasswordField pwdPassword;
  @FXML
  private Text txtErrorMessage;

  @FXML
  private void handleLoginStudentClick(MouseEvent me) {
    if (txtStudentId.getText().isEmpty() || pwdPassword.getText().isEmpty()) {
      txtErrorMessage.setText("Please fill in all fields");
      return;
    }

    LoginUserDto loginUserDto = new LoginUserDto(
            this.txtStudentId.getText(),
            this.pwdPassword.getText()
    );

    boolean isLogin = UserService.login(loginUserDto);

    if(!isLogin) {
      txtErrorMessage.setText("Username or password is incorrect");
      return;
    }

    Navigator.navigate(me, Navigator.DASHBOARD_STUDENT);
  }
}
