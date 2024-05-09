package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.dto.LoginUserDto;
import service.Navigator;
import service.UserService;

public class LoginControllerStudent {
  @FXML
  private TextField txtStudentId;
  @FXML
  private PasswordField pwdPassword;

  @FXML
  private void handleLoginStudentClick(MouseEvent me) {
    LoginUserDto loginUserDto = new LoginUserDto(
            this.txtStudentId.getText(),
            this.pwdPassword.getText()
    );

    boolean isLogin = UserService.login(loginUserDto);

    if(!isLogin){
      System.out.println("Login failed");
    }
    else{
      System.out.println("Login successful");
      Navigator.navigate(me, Navigator.DASHBOARD_STUDENT);
    }
  }
}
