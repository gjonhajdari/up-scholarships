package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import service.AdminSession;
import service.Navigator;

public class CreateVoucherController {
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtAmount;
    @FXML
    private DatePicker dtpDeadline;
    @FXML
    private ComboBox<String> cmbCategory;
    @FXML
    private TextArea txtDescription;

    @FXML
    private void handleCreateClick(MouseEvent me) {

    }

    @FXML
    private void handleDashboardClick(MouseEvent me) { Navigator.navigate(me, Navigator.DASHBOARD_ADMIN); }
    @FXML
    private void handleVouchersClick(MouseEvent me) { Navigator.navigate(me, Navigator.VOUCHERS_ADMIN); }
    @FXML
    private void handleProfileClick(MouseEvent me) { Navigator.navigate(me, Navigator.PROFILE_ADMIN); }
    @FXML
    private void handleLogoutClick(MouseEvent me) {
        AdminSession.getInstance(null).cleanAdminSession();
        Navigator.navigate(me, Navigator.LOGIN_PAGE_ADMIN);
    }
}
