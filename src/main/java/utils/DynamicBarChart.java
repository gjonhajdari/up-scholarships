package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.VoucherApplied;
import java.util.List;

public class DynamicBarChart extends BarChart<String, Number> {

    private ObservableList<VoucherApplied> data = FXCollections.observableArrayList();

    public DynamicBarChart() {
        super(new CategoryAxis(), new NumberAxis());
        ((CategoryAxis)getXAxis()).setLabel("Status");
        ((NumberAxis)getYAxis()).setLabel("Number");
    }

    public void updateData(List<VoucherApplied> voucherAppliedList) {
        data.setAll(voucherAppliedList);
        updateChart();
    }

    private void updateChart() {
        // Clear previous data
        getData().clear();

        // Create new series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (VoucherApplied voucherApplied : data) {
            series.getData().add(new XYChart.Data<>(voucherApplied.getStatus(), 1)); // Assuming each application counts as 1
        }

        // Add series to chart
        getData().add(series);
    }
}