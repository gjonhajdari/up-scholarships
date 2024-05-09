package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import service.Navigator;

public class DashboardAdminController {


    @FXML
    private void handleVouchersClick(MouseEvent me){
        Navigator.navigate( me, Navigator.VOUCHERS_ADMIN);
    }

    @FXML
    private void handleCreateClick(MouseEvent me){
        Navigator.navigate( me, Navigator.CREATE_VOUCHER);
    }
    @FXML
    private void handleProfileClick(MouseEvent me){
        Navigator.navigate( me, Navigator.PROFILE_ADMIN);
    }

}