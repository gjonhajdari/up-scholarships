package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.dto.LoginUserDto;
import service.AdminService;
import service.Navigator;

import java.sql.SQLException;

public class LoginControllerAdmin {
  @FXML
  private TextField txtUsername;

  @FXML
  private PasswordField pwdPassword;

  @FXML
  private void handleLoginAdminClick(MouseEvent me) throws SQLException {
    LoginUserDto loginUserDto = new LoginUserDto(
      this.txtUsername.getText(),
      this.pwdPassword.getText()
    );

    boolean isLogin = AdminService.login(loginUserDto);

    if (!isLogin) {
      System.out.println("Login failed");
    }else {
      System.out.println("Login successful");
      Navigator.navigate(me, Navigator.DASHBOARD_ADMIN);
    }
  }
}
