package model;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Map;
import java.util.stream.Collectors;

public class DynamicBarChart extends DynamicChart {
  private BarChart<String, Number> barChart;

  public DynamicBarChart() {
    barChart = new BarChart<>(new CategoryAxis(), new NumberAxis());
    barChart.setLegendVisible(false);

    setLabels();
  }

  private void setLabels() {
    ((CategoryAxis)barChart.getXAxis()).setLabel("Status");
    ((NumberAxis)barChart.getYAxis()).setLabel("Number");
  }

  @Override
  protected void loadData() {
    barChart.getData().clear();
    barChart.getData().add(generateSeriesFromData());
  }

  private XYChart.Series<String, Number> generateSeriesFromData() {
    Map<String, Long> statusCounts = data.stream()
            .collect(Collectors.groupingBy(VoucherApplied::getStatus, Collectors.counting()));

    XYChart.Series<String, Number> series = new XYChart.Series<>();

    statusCounts.forEach((status, count) -> {
      XYChart.Data<String, Number> data = new XYChart.Data<>(status, count);
      series.getData().add(data);
      // Set style class depending on application status
      data.nodeProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
          switch (status) {
            case "PENDING":
              newValue.setStyle("-fx-bar-fill: #94a3b8;");
              break;
            case "APPROVED":
              newValue.setStyle("-fx-bar-fill: #4ade80;");
              break;
            case "REJECTED":
              newValue.setStyle("-fx-bar-fill: #f87171;");
              break;
          }
      }
      });
    });

    return series;
  }

  public BarChart<String, Number> getChart() {
    return barChart;
  }
}