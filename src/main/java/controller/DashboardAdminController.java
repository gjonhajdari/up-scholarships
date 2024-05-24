package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import model.DynamicLineChart;
import model.DynamicPieChart;
import model.VoucherApplied;
import model.filter.VoucherAppliedFilter;
import model.filter.VoucherAppliedFilter.Duration;
import service.AdminSession;
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
  private DynamicPieChart pieChart;
  private DynamicLineChart lineChart;
  private List<VoucherApplied> vouchers;
  private VoucherAppliedFilter filter;

  public void initialize() {
    barChart = new DynamicBarChart();
    pieChart = new DynamicPieChart();
    lineChart = new DynamicLineChart();

    barchartPane.getChildren().add(barChart.getChart());
    piechartPane.getChildren().add(pieChart.getChart());
    linechartPane.getChildren().add(lineChart.getChart());

    filter = new VoucherAppliedFilter(Duration.ALL);

    vouchers = VoucherService.getAllAppliedVouchers(filter);
    updateChart(vouchers);
    setActive(btnAllTime);
  }

  public void updateChart(List<VoucherApplied> voucherAppliedList) {
    barChart.updateData(voucherAppliedList);
    pieChart.updateData(voucherAppliedList);
    lineChart.updateData(voucherAppliedList);
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
    filter.setDuration(Duration.WEEK);
    vouchers = VoucherService.getAllAppliedVouchers(filter);

    updateChart(vouchers);
    setActive(btnWeek);
  }

  @FXML
  private void handleFilterMonthClick(MouseEvent me) {
    filter.setDuration(Duration.MONTH);
    vouchers = VoucherService.getAllAppliedVouchers(filter);

    updateChart(vouchers);
    setActive(btnMonth);
  }

  @FXML
  private void handleFilterYearClick(MouseEvent me) {
    filter.setDuration(Duration.YEAR);
    vouchers = VoucherService.getAllAppliedVouchers(filter);

    updateChart(vouchers);
    setActive(btnYear);
  }

  @FXML
  private void handleFilterAllTimeClick(MouseEvent me) {
    filter.setDuration(Duration.ALL);
    vouchers = VoucherService.getAllAppliedVouchers(filter);

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
  private void handleHelpClick(MouseEvent me) {Navigator.navigate(me,Navigator.HELP_ADMIN);};
  @FXML
  private void handleLogoutClick(MouseEvent me) {
    AdminSession.clearAdminSession();
    Navigator.navigate(me, Navigator.HOME_PAGE);
  }
}
