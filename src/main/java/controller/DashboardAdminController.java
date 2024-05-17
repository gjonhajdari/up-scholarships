package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import model.VoucherApplied;
import service.AdminSession;
import service.FilterService;
import service.Navigator;
import service.VoucherService;
import model.DynamicBarChart;

import java.util.List;

public class DashboardAdminController {
  @FXML
  private StackPane barchartPane;
  @FXML
  private StackPane piechartPane;
  @FXML
  private StackPane linechartPane;
  @FXML
  private Button btnWeek;
  @FXML
  private Button btnMonth;
  @FXML
  private Button btnYear;
  @FXML
  private Button btnAllTime;

  private DynamicBarChart barChart;
  private List<VoucherApplied> vouchers;
  private List<VoucherApplied> filteredVouchers;

  public void initialize() {
    barChart = new DynamicBarChart();
    barchartPane.getChildren().add(barChart);

    vouchers = VoucherService.getAllAppliedVouchers();
    updateChart(vouchers);
    setActive(btnAllTime);
  }

  public void updateChart(List<VoucherApplied> voucherAppliedList) {
    barChart.updateData(voucherAppliedList);
  }

  private void setActive(Button activeButton) {
    btnWeek.getStyleClass().remove("button-active");
    btnMonth.getStyleClass().remove("button-active");
    btnYear.getStyleClass().remove("button-active");
    btnAllTime.getStyleClass().remove("button-active");

    activeButton.getStyleClass().add("button-active");
  }

  @FXML
  private void handleFilterWeekClick(MouseEvent me) {
    filteredVouchers = FilterService.filterLastWeek(vouchers);
    updateChart(filteredVouchers);
    setActive(btnWeek);
  }

  @FXML
  private void handleFilterMonthClick(MouseEvent me) {
    filteredVouchers = FilterService.filterLastMonth(vouchers);
    updateChart(filteredVouchers);
    setActive(btnMonth);
  }

  @FXML
  private void handleFilterYearClick(MouseEvent me) {
    filteredVouchers = FilterService.filterLastYear(vouchers);
    updateChart(filteredVouchers);
    setActive(btnYear);
  }

  @FXML
  private void handleFilterAllTimeClick(MouseEvent me) {
    updateChart(vouchers);
    setActive(btnAllTime);
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
