package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import service.AdminSession;
import service.Navigator;
import service.UserSession;

public class HelpStudentController {
  @FXML
  private void handleDashboardClick(MouseEvent me) { Navigator.navigate( me, Navigator.DASHBOARD_STUDENT); }
  @FXML
  private void handleProfileClick(MouseEvent me) { Navigator.navigate( me, Navigator.PROFILE_STUDENT); }
  @FXML
  private void handleAppliedClick(MouseEvent me) { Navigator.navigate( me, Navigator.APPLIED_STUDENT); }
//  @FXML
//  private void handleDashboardButtonClick(MouseEvent me) { Navigator.navigate(me,Navigator.DASHBOARD_STUDENT); }
//  @FXML
//  private void handleAppliedButtonClick(MouseEvent me) { Navigator.navigate(me, Navigator.APPLIED_STUDENT); }
//  @FXML
//  private void handleProfileButtonClick(MouseEvent me) {Navigator.navigate(me,Navigator.PROFILE_STUDENT);}
  @FXML
  private void handleKosovoGovernmentButton(MouseEvent me) {Navigator.navigate(me,Navigator.KosovoGovernment_EXTERNAL_PAGE);}
  @FXML
  private void handleMASHTExternalButton(MouseEvent me) {Navigator.navigate(me,Navigator.MASHT_EXTERNAL_PAGE);}
  @FXML
  private void handleMFPTButtonClick(MouseEvent me) {Navigator.navigate(me,Navigator.MFPT_EXTERNAL_PAGE);}
  @FXML
  private void handleUPExternalButtonClick(MouseEvent me) {Navigator.navigate(me,Navigator.UP_EXTERNAL_PAGE);}
  @FXML
  private void handleLogoutClick(MouseEvent me) {
      UserSession.clearUserSession();
      Navigator.navigate(me, Navigator.HOME_PAGE);
  }
}
