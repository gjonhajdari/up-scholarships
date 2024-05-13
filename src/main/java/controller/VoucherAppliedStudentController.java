package controller;

import controller.interfaces.InitialisableController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.VoucherApplied;
import service.Navigator;
import service.UserSession;
import service.VoucherService;
import utils.Formatter;

public class VoucherAppliedStudentController implements InitialisableController {
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
  private Text txtApplicationDate;
  @FXML
  private Text txtStatus;

  private int voucherId;

  public void initData(int id) {
    VoucherApplied voucherApplied = VoucherService.getAppliedById(id);

    voucherId = voucherApplied.getId();
    txtVoucherId.setText("Voucher #" + String.valueOf(voucherId));

    txtTitle.setText(voucherApplied.getTitle());
    txtAmount.setText(Formatter.formatCurrency(voucherApplied.getAmount()) + " EUR");
    txtDeadline.setText(Formatter.formatDate(voucherApplied.getDeadline()));
    txtDescription.setText(voucherApplied.getDescription());
    txtApplicationDate.setText(Formatter.formatDate(voucherApplied.getApplicationDate()));

    String status = voucherApplied.getStatus();
    txtStatus.setText(status);

    Platform.runLater(() -> {
      if (status.equals("APPROVED")) {
        txtStatus.setStyle("-fx-fill: #14b8a6");
      } else if (status.equals("REJECTED")) {
        txtStatus.setStyle("-fx-fill: #ef4444");
      }
    });
  }

  @FXML
  private void handleBackClick(MouseEvent me) { Navigator.back(me); }

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
    Navigator.navigate(me, Navigator.HOME_PAGE);
  }
}
