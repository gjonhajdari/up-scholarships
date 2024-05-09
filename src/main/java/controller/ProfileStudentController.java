package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import service.Navigator;

public class ProfileStudentController {

    @FXML
    private void handleAppliedClick(MouseEvent me){
        Navigator.navigate( me, Navigator.APPLIED_STUDENT);
    }
    @FXML
    private void handleDashboardClick(MouseEvent me){
        Navigator.navigate( me, Navigator.DASHBOARD_STUDENT);
    }

    @FXML
    private void handleHelpClick(MouseEvent me){
        Navigator.navigate( me, Navigator.HELP_STUDENT);
    }
}
