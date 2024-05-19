package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public abstract class DynamicChart {
  protected ObservableList<VoucherApplied> data = FXCollections.observableArrayList();

  public void updateData(List<VoucherApplied> voucherAppliedList) {
    data.setAll(voucherAppliedList);
    loadData();
  }

  protected abstract void loadData();
}
