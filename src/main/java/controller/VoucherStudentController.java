package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Voucher;
import service.Formatter;
import service.Navigator;
import service.UserSession;
import service.VoucherService;

public class VoucherStudentController {
  @FXML
  private Text txtVoucherId;
  @FXML
  private Text txtTitle;
  @FXML
  private Text txtAmount;
  @FXML
  private Text txtDeadline;
  @FXML
  private Text txtDescription;
  @FXML
  private Text txtSuccessMessage;
  @FXML
  private Text txtErrorMessage;

  private int voucherId;

  public void initData(int id) {
    voucherId = id;
    txtVoucherId.setText("Voucher #" + String.valueOf(voucherId));

    Voucher voucher = VoucherService.getVoucherById(id);

    txtTitle.setText(voucher.getTitle());
    txtAmount.setText(Formatter.formatCurrency(voucher.getAmount()) + " EUR");
    txtDeadline.setText(Formatter.formatDate(voucher.getDeadline()));
    txtDescription.setText(voucher.getDescription());
  }

  @FXML
  private void handleApplyClick(MouseEvent me) {
    boolean didApply = VoucherService.apply(voucherId, UserSession.getInstance(null).getId());

    if (!didApply) {
      txtErrorMessage.setText("There was an error applying for this voucher. Please try again later.");
    }

    txtSuccessMessage.setText("Successfully applied for voucher");
    txtErrorMessage.setText("");
  }

  @FXML
  private void handleDashboardClick(MouseEvent me) { Navigator.navigate(me, Navigator.DASHBOARD_STUDENT); }
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
