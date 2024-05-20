package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.dto.AdminChangePasswordDto;
import service.AdminService;
import service.AdminSession;
import service.Navigator;
import utils.Validator;

import java.sql.SQLException;

public class ProfileAdminController {
  @FXML
  private PasswordField pwdOldPassword;
  @FXML
  private PasswordField pwdNewPassword;
  @FXML
  private PasswordField pwdConfirmPassword;
  @FXML
  private ToggleGroup Language;
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

    AdminChangePasswordDto adminSaveDto = new AdminChangePasswordDto(
      pwdOldPassword.getText(),
      pwdNewPassword.getText()
    );

    boolean isSaved = AdminService.updatePassword(adminSaveDto);

    if (!isSaved) {
      txtErrorMessage.setText("Password is incorrect.");
      return;
    }

    txtSuccessMessage.setText("Password changed successfully");
    txtErrorMessage.setText("");
  }

  @FXML
  private void handleDashboardClick(MouseEvent me) { Navigator.navigate(me, Navigator.DASHBOARD_ADMIN); }
  @FXML
  private void handleVouchersClick(MouseEvent me) { Navigator.navigate(me, Navigator.VOUCHERS_ADMIN); }
  @FXML
  private void handleCreateClick(MouseEvent me) { Navigator.navigate(me, Navigator.CREATE_VOUCHER); }
  @FXML
  private void handleLogoutClick(MouseEvent me) {
    AdminSession.clearAdminSession();
    Navigator.navigate(me, Navigator.HOME_PAGE);
  }
}
