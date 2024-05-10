package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import service.Navigator;

public class DashboardStudentController {
    @FXML
    private void handleAppliedClick(MouseEvent me) { Navigator.navigate( me, Navigator.APPLIED_STUDENT); }
    @FXML
    private void handleProfileClick(MouseEvent me) { Navigator.navigate( me, Navigator.PROFILE_STUDENT); }
    @FXML
    private void handleHelpClick(MouseEvent me) {Navigator.navigate( me, Navigator.HELP_STUDENT); }
    @FXML
    private void handleLogoutClick(MouseEvent me){ Navigator.navigate( me, Navigator.LOGIN_PAGE_STUDENT); }
}
