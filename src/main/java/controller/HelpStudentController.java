package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import service.Navigator;

public class HelpStudentController {
    @FXML
    private void handleDashboardClick(MouseEvent me) { Navigator.navigate( me, Navigator.DASHBOARD_STUDENT); }
    @FXML
    private void handleProfileClick(MouseEvent me) { Navigator.navigate( me, Navigator.PROFILE_STUDENT); }
    @FXML
    private void handleAppliedClick(MouseEvent me) { Navigator.navigate( me, Navigator.APPLIED_STUDENT); }
    @FXML
    private void handleLogoutClick(MouseEvent me){ Navigator.navigate( me, Navigator.LOGIN_PAGE_STUDENT); }
}
