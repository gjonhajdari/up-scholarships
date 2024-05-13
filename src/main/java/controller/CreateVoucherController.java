package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.dto.CreateVoucherDto;
import service.AdminSession;
import service.Navigator;
import service.Validator;
import service.VoucherService;

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
    private Text txtErrorMessage;
    @FXML
    private Text txtSuccessMessage;

    @FXML
    private void handleCreateClick(MouseEvent me) {
      if (Validator.isEmpty(txtTitle.getText(), txtAmount.getText(), txtDescription.getText()) || Validator.isEmpty(dtpDeadline.getValue(), cmbCategory.getValue())) {
        txtErrorMessage.setText("Please fill in all fields.");
        txtSuccessMessage.setText("");
        return;
      }

      boolean isCreated = VoucherService.createVoucher(
        txtTitle.getText(),
        txtAmount.getText(),
        dtpDeadline.getValue().toString(),
        cmbCategory.getValue(),
        txtDescription.getText()
      );

      if (!isCreated) {
        txtErrorMessage.setText("Failed to create voucher.");
        txtSuccessMessage.setText("");
        return;
      }

      txtSuccessMessage.setText("Voucher created successfully.");
      txtErrorMessage.setText("");
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
        Navigator.navigate(me, Navigator.HOME_PAGE);
    }
}
