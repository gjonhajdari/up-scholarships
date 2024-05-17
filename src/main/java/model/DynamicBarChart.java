package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamicBarChart extends BarChart<String, Number> {

    private ObservableList<VoucherApplied> data = FXCollections.observableArrayList();

    public DynamicBarChart() {
        super(new CategoryAxis(), new NumberAxis());
        setLabels();
    }

    private void setLabels() {
        ((CategoryAxis)getXAxis()).setLabel("Status");
        ((NumberAxis)getYAxis()).setLabel("Number");
    }

    public void updateData(List<VoucherApplied> voucherAppliedList) {
        data.setAll(voucherAppliedList);
        loadData();
    }

    private void loadData() {
        getData().clear();
        getData().add(generateSeriesFromData());
    }

    private XYChart.Series<String, Number> generateSeriesFromData() {
        Map<String, Long> statusCounts = data.stream()
                .collect(Collectors.groupingBy(VoucherApplied::getStatus, Collectors.counting()));

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        statusCounts.forEach((status, count) -> {
            XYChart.Data<String, Number> data = new XYChart.Data<>(status, count);
            series.getData().add(data);
        });

        return series;
    }
}