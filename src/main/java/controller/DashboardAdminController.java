package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import model.VoucherApplied;
import service.AdminSession;
import service.Navigator;
import utils.DynamicBarChart;

import java.util.List;

public class DashboardAdminController {
  @FXML
  private void handleVouchersClick(MouseEvent me) { Navigator.navigate(me, Navigator.VOUCHERS_ADMIN); }
  @FXML
  private void handleCreateClick(MouseEvent me) { Navigator.navigate(me, Navigator.CREATE_VOUCHER); }
  @FXML
  private void handleProfileClick(MouseEvent me) { Navigator.navigate(me, Navigator.PROFILE_ADMIN); }
  @FXML
  private void handleLogoutClick(MouseEvent me) {
      AdminSession.getInstance(null).cleanAdminSession();
      Navigator.navigate(me, Navigator.HOME_PAGE);
  }
  @FXML
  private StackPane chartPane;

  private DynamicBarChart barChart;

  public void initialize() {
    barChart = new DynamicBarChart();
    chartPane.getChildren().add(barChart);
  }

  public void updateChart(List<VoucherApplied> voucherAppliedList) {
    barChart.updateData(voucherAppliedList);
  }
}
