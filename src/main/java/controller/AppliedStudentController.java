package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import service.Navigator;
import service.UserSession;

public class AppliedStudentController {
    @FXML
    private void handleDashboardClick(MouseEvent me) { Navigator.navigate( me, Navigator.DASHBOARD_STUDENT); }
    @FXML
    private void handleProfileClick(MouseEvent me) { Navigator.navigate( me, Navigator.PROFILE_STUDENT); }
    @FXML
    private void handleHelpClick(MouseEvent me) { Navigator.navigate( me, Navigator.HELP_STUDENT); }
    @FXML
    private void handleLogoutClick(MouseEvent me) {
        UserSession.getInstance(null).cleanUserSession();
        Navigator.navigate(me, Navigator.LOGIN_PAGE_STUDENT);
    }
}
