package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamicBarChart extends BarChart<String, Number> {

    private Group parentGroup;
    private ObservableList<VoucherApplied> data = FXCollections.observableArrayList();

    public DynamicBarChart() {
        super(new CategoryAxis(), new NumberAxis());
        parentGroup = new Group();
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
            data.nodeProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    displayLabelForData(data);
                }
            });
            series.getData().add(data);
        });

        return series;
    }

    private void displayLabelForData(XYChart.Data<String, Number> data) {
        final Node node = data.getNode();
        final Text dataText = new Text(data.getYValue() + "");

        data.extraValueProperty().setValue(dataText);

        node.parentProperty().addListener((ov, oldParent, parent) -> {
            Group parentGroup = (Group) parent;
            if (parentGroup != null) {
                parentGroup.getChildren().add(dataText);
            }
        });

        node.boundsInParentProperty().addListener((ov, oldBounds, bounds) -> {
            dataText.setLayoutX(Math.round(bounds.getMinX() + bounds.getWidth() / 2 - dataText.prefWidth(-1) / 2));
            dataText.setLayoutY(Math.round(bounds.getMinY() - dataText.prefHeight(-1) * 0.5));
        });

        // Remove the old Text node when the data changes
        data.YValueProperty().addListener((ov, oldVal, newVal) -> {
            Group parentGroup = (Group) node.getParent();
            if (parentGroup != null) {
                Text oldDataText = (Text) data.extraValueProperty().getValue();
                parentGroup.getChildren().remove(oldDataText);
                dataText.setText(newVal + "");
            }
        });
    }
}