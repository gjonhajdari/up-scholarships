package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.dto.StudentChangePasswordDto;
import service.*;
import utils.Validator;

import java.sql.SQLException;

public class ProfileStudentController {
  @FXML
  private PasswordField pwdOldPassword;
  @FXML
  private PasswordField pwdNewPassword;
  @FXML
  private PasswordField pwdConfirmPassword;
  @FXML
  private Text txtErrorMessage;
  @FXML
  private Text txtSuccessMessage;

  @FXML
  private void handleSaveClick(MouseEvent me) throws SQLException {
    if (Validator.isEmpty(pwdOldPassword.getText(), pwdNewPassword.getText(), pwdConfirmPassword.getText())) {
      txtErrorMessage.setText("Please fill in all fields.");
      return;
    }

    if (!pwdNewPassword.getText().equals(pwdConfirmPassword.getText())) {
      txtErrorMessage.setText("Passwords do not match.");
      return;
    }

    StudentChangePasswordDto studentSaveDto = new StudentChangePasswordDto(
      pwdOldPassword.getText(),
      pwdNewPassword.getText()
    );

    boolean isSaved = UserService.updatePassword(studentSaveDto);

    if (!isSaved) {
      txtErrorMessage.setText("Password is incorrect.");
      return;
    }

    txtSuccessMessage.setText("Password changed successfully");
    txtErrorMessage.setText("");
  }

  @FXML
  private void handleAppliedClick(MouseEvent me) { Navigator.navigate(me, Navigator.APPLIED_STUDENT); }
  @FXML
  private void handleDashboardClick(MouseEvent me) { Navigator.navigate(me, Navigator.DASHBOARD_STUDENT); }
  @FXML
  private void handleHelpClick(MouseEvent me) { Navigator.navigate(me, Navigator.HELP_STUDENT); }
  @FXML
  private void handleLogoutClick(MouseEvent me) {
    UserSession.clearUserSession();
    Navigator.navigate(me, Navigator.HOME_PAGE);
  }
}
