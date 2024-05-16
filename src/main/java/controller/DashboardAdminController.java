package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import model.VoucherApplied;
import service.AdminSession;
import service.FilterService;
import service.Navigator;
import service.VoucherService;
import utils.DynamicBarChart;

import java.util.List;

public class DashboardAdminController {
  @FXML
  private StackPane chartPane;

  private DynamicBarChart barChart;
  private List<VoucherApplied> vouchers;
  private List<VoucherApplied> filteredVouchers;

  public void initialize() {
    barChart = new DynamicBarChart();
    chartPane.getChildren().add(barChart);

    vouchers = VoucherService.getAllAppliedVouchers();
    updateChart(vouchers);
  }

  public void updateChart(List<VoucherApplied> voucherAppliedList) {
    barChart.updateData(voucherAppliedList);
  }

  @FXML
  private void handleFilterWeekClick(MouseEvent me) {
    filteredVouchers = FilterService.filterLastWeek(vouchers);
    updateChart(filteredVouchers);
  }

  @FXML
  private void handleFilterMonthClick(MouseEvent me) {
    filteredVouchers = FilterService.filterLastMonth(vouchers);
    updateChart(filteredVouchers);
  }

  @FXML
  private void handleFilterYearClick(MouseEvent me) {
    filteredVouchers = FilterService.filterLastYear(vouchers);
    updateChart(filteredVouchers);
  }

  @FXML
  private void handleFilterAllTimeClick(MouseEvent me) {
    updateChart(vouchers);
  }

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
}
