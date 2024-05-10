package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import service.Navigator;

public class CreateVoucherController {
    @FXML
    private void handleDashboardClick(MouseEvent me) { Navigator.navigate( me, Navigator.DASHBOARD_ADMIN); }
    @FXML
    private void handleVouchersClick(MouseEvent me) { Navigator.navigate( me, Navigator.VOUCHERS_ADMIN); }
    @FXML
    private void handleProfileClick(MouseEvent me) { Navigator.navigate( me, Navigator.PROFILE_ADMIN); }
    @FXML
    private void handleLogoutClick(MouseEvent me){ Navigator.navigate( me, Navigator.LOGIN_PAGE_ADMIN); }
}
