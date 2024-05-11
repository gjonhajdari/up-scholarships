package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.dto.LoginUserDto;
import service.AdminService;
import service.Navigator;
import service.Validator;

import java.sql.SQLException;

public class LoginControllerAdmin {
  @FXML
  private TextField txtUsername;
  @FXML
  private PasswordField pwdPassword;
  @FXML
  private Text txtErrorMessage;

  @FXML
  private void handleLoginAdminClick(MouseEvent me) throws SQLException {
    if (Validator.isEmpty(txtUsername.getText(), pwdPassword.getText())) {
      txtErrorMessage.setText("Please fill in all fields");
      return;
    }

    LoginUserDto loginUserDto = new LoginUserDto(
      this.txtUsername.getText(),
      this.pwdPassword.getText()
    );

    boolean isLogin = AdminService.login(loginUserDto);

    if(!isLogin) {
      txtErrorMessage.setText("Username or password is incorrect");
      return;
    }

    Navigator.navigate(me, Navigator.DASHBOARD_ADMIN);
  }
}
