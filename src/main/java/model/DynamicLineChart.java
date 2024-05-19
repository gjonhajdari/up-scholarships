package model;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.util.StringConverter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamicLineChart extends DynamicChart {
  private LineChart<Number, Number> lineChart;

  public DynamicLineChart() {
    NumberAxis yAxis = new NumberAxis();
    NumberAxis xAxis = new NumberAxis();
    xAxis.setAutoRanging(false);
    // Set the tick unit to 1 day
    xAxis.setTickUnit(24 * 60 * 60 * 1000);

    xAxis.setTickLabelFormatter(new StringConverter<>() {
      private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

      @Override
      public String toString(Number object) {
        return format.format(new Date(object.longValue()));
      }

      @Override
      public Number fromString(String string) {
        return null;
      }
    });

    lineChart = new LineChart<>(xAxis, yAxis);
    lineChart.setLegendVisible(false);

    setLabels();
  }

  private void setLabels() {
    lineChart.getXAxis().setLabel("Date");
    lineChart.getYAxis().setLabel("Number of Applications");
  }

  @Override
  protected void loadData() {
    lineChart.getData().clear();
    lineChart.getData().addAll(generateLineChartData());

    // Set the lower and upper bounds of the x-axis to the min and max dates in the data
    NumberAxis xAxis = (NumberAxis) lineChart.getXAxis();
    LocalDate minDate = data.stream().map(VoucherApplied::getApplicationDate).min(LocalDate::compareTo).orElse(LocalDate.now());
    LocalDate maxDate = data.stream().map(VoucherApplied::getApplicationDate).max(LocalDate::compareTo).orElse(LocalDate.now());
    xAxis.setLowerBound(minDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
    xAxis.setUpperBound(maxDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
  }

  private XYChart.Series<Number, Number> generateLineChartData() {
    Map<Date, Long> applicationCounts = data.stream()
            .collect(Collectors.groupingBy(voucher -> Date.from(voucher.getApplicationDate().atStartOfDay(ZoneId.systemDefault()).toInstant()), Collectors.counting()));

    XYChart.Series<Number, Number> series = new XYChart.Series<>();
    applicationCounts.forEach((date, count) -> {
      XYChart.Data<Number, Number> data = new XYChart.Data<>(date.getTime(), count);
      series.getData().add(data);
    });

    return series;
  }

  public LineChart<Number, Number> getChart() {
    return lineChart;
  }
}