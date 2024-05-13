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
    @FXML
    private void handleLogoutClick(MouseEvent me) {
        AdminSession.getInstance(null).cleanAdminSession();
        Navigator.navigate(me, Navigator.HOME_PAGE);
    }
}
