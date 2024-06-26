package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.dto.LoginUserDto;
import service.Navigator;
import service.UserService;
import utils.Validator;

import java.sql.SQLException;

public class LoginControllerStudent {
  @FXML
  private TextField txtStudentId;
  @FXML
  private PasswordField pwdPassword;
  @FXML
  private Button btnLogin;
  @FXML
  private Text txtErrorMessage;

  @FXML
  private void initialize() {
    EventHandler<KeyEvent> enterKeyHandler = event -> {
      if (event.getCode() == KeyCode.ENTER) {
        try {
          handleLoginStudent();
          if (txtErrorMessage.getText().isEmpty()) {
            Navigator.navigate(event, Navigator.DASHBOARD_STUDENT);
          }
        } catch (SQLException sqle) {
          sqle.printStackTrace();
        }
      }
    };

    pwdPassword.setOnKeyPressed(enterKeyHandler);
    btnLogin.setOnKeyPressed(enterKeyHandler);
  }

  @FXML
  private void handleLoginStudentClick(MouseEvent event) throws SQLException {
    handleLoginStudent();
    if (txtErrorMessage.getText().isEmpty()) {
      Navigator.navigate(event, Navigator.DASHBOARD_STUDENT);
    }
  }

  @FXML
  private void handleLoginStudent() throws SQLException {
    if (Validator.isEmpty(txtStudentId.getText(), pwdPassword.getText())) {
      txtErrorMessage.setText("Please fill in all fields");
      return;
    }

    LoginUserDto loginUserDto = new LoginUserDto(
      Validator.clearSpaces(this.txtStudentId.getText()),
      Validator.clearSpaces(this.pwdPassword.getText())
    );

    boolean isLogin = UserService.login(loginUserDto);

    if(!isLogin) {
      txtErrorMessage.setText("Username or password is incorrect");
      return;
    }

    txtErrorMessage.setText("");
  }
}
