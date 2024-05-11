package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import service.Navigator;
import service.UserSession;

public class DashboardStudentController {
    @FXML
    private Text txtWelcomeMessage;

    public void initialize() {
        String firstName = UserSession.getInstance(null).getFirstName();
        txtWelcomeMessage.setText("Welcome back, " + firstName);
    }

    @FXML
    private void handleAppliedClick(MouseEvent me) { Navigator.navigate(me, Navigator.APPLIED_STUDENT); }
    @FXML
    private void handleProfileClick(MouseEvent me) { Navigator.navigate(me, Navigator.PROFILE_STUDENT); }
    @FXML
    private void handleHelpClick(MouseEvent me) { Navigator.navigate(me, Navigator.HELP_STUDENT); }
    @FXML
    private void handleLogoutClick(MouseEvent me) {
        UserSession.getInstance(null).cleanUserSession();
        Navigator.navigate(me, Navigator.LOGIN_PAGE_STUDENT);
    }
}
