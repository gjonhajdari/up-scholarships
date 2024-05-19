package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamicPieChart extends DynamicChart {
  private PieChart pieChart;

  public DynamicPieChart() {
    pieChart = new PieChart();
    pieChart.setLegendVisible(false);
  }

  @Override
  protected void loadData() {
    pieChart.getData().clear();
    pieChart.getData().addAll(generatePieChartData());
  }

  private List<PieChart.Data> generatePieChartData() {
    Map<String, Long> statusCounts = data.stream()
          .collect(Collectors.groupingBy(VoucherApplied::getCategory, Collectors.counting()));

    long total = statusCounts.values().stream().mapToLong(Long::longValue).sum();

    return statusCounts.entrySet().stream()
          .map(entry -> new PieChart.Data(entry.getKey(), (double) entry.getValue() / total * 100))
          .collect(Collectors.toList());
  }

  public PieChart getChart() {
    return pieChart;
  }
}
