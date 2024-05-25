package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.dto.StudentChangePasswordDto;
import service.Navigator;
import service.UserSession;
import service.UserService;
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
  private Button btnSave;
  @FXML
  private Text txtErrorMessage;
  @FXML
  private Text txtSuccessMessage;
  @FXML
  private ToggleGroup languageGroup;
  @FXML
  private javafx.scene.control.RadioButton radioAlb; 
  @FXML
  private javafx.scene.control.RadioButton radioEng;

  @FXML
  private void initialize() {
    btnSave.setOnKeyPressed(event -> {
      if (event.getCode() == KeyCode.ENTER) {
        try {
          handleSaveClick(null);
        } catch (SQLException sqle) {
          sqle.printStackTrace();
        }
      }
    });

    languageGroup = new ToggleGroup();
    radioAlb.setToggleGroup(languageGroup);
    radioEng.setToggleGroup(languageGroup);
    radioAlb.setUserData("sq");
    radioEng.setUserData("en");

    languageGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue != null) {
        String selectedLanguage = newValue.getUserData().toString();
        changeLanguage(selectedLanguage);
      }
    });

    String currentLanguage = java.util.Locale.getDefault().getLanguage();
    if (currentLanguage.equals("sq")) {
      radioAlb.setSelected(true);
    } else {
      radioEng.setSelected(true);
    }
  }

  private void changeLanguage(String languageCode) {
    java.util.Locale locale = new java.util.Locale(languageCode);
    java.util.Locale.setDefault(locale);
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("translations.content", locale);
    Navigator.reloadCurrentScene(bundle);
  }

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