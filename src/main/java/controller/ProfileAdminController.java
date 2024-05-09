package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import service.Navigator;

public class ProfileAdminController {
    @FXML
    private PasswordField txtPassword11;
    @FXML
    private PasswordField txtPassword1;
    @FXML
    private PasswordField  txtPassword;
    @FXML
    private ToggleGroup Language;
    @FXML
    private Button btnLogin;

    @FXML
    private void handleDashboardClick(MouseEvent me){
        Navigator.navigate( me, Navigator.DASHBOARD_ADMIN);
    }
    @FXML
    private void handleVouchersClick(MouseEvent me){
        Navigator.navigate( me, Navigator.VOUCHERS_ADMIN);
    }

    @FXML
    private void handleCreateClick(MouseEvent me){
        Navigator.navigate( me, Navigator.CREATE_VOUCHER);
    }

}
