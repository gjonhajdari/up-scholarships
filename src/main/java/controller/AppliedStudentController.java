package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.VoucherApplied;
import service.Navigator;
import service.UserSession;
import service.VoucherService;

import java.time.LocalDate;
import java.util.List;

public class AppliedStudentController {
  @FXML
  private TableView<VoucherApplied> tblAppliedStudent;
  @FXML
  private TableColumn<VoucherApplied, String> colTitle;
  @FXML
  private TableColumn<VoucherApplied, Float> colAmount;
  @FXML
  private TableColumn<VoucherApplied, LocalDate> colDeadline;
  @FXML
  private TableColumn<VoucherApplied, String> colStatus;

  public void initialize(){
    colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    colDeadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));
    colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

    List<VoucherApplied> appliedVouchers = VoucherService.getApplied();
    ObservableList<VoucherApplied> observableVouchers = FXCollections.observableArrayList(appliedVouchers);
    tblAppliedStudent.setItems(observableVouchers);

    tblAppliedStudent.setRowFactory(tv -> {
      TableRow<VoucherApplied> row = new TableRow<>();

      row.setOnMouseClicked(event -> {
        if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
          VoucherApplied clickedRow = row.getItem();
          Navigator.navigate(event, Navigator.VOUCHER_APPLIED, clickedRow.getApplicationId());
        }
      });

      return row;
    });
  }

  @FXML
  private void handleDashboardClick(MouseEvent me) { Navigator.navigate( me, Navigator.DASHBOARD_STUDENT); }
  @FXML
  private void handleProfileClick(MouseEvent me) { Navigator.navigate( me, Navigator.PROFILE_STUDENT); }
  @FXML
  private void handleHelpClick(MouseEvent me) { Navigator.navigate( me, Navigator.HELP_STUDENT); }
  @FXML
  private void handleLogoutClick(MouseEvent me) {
    UserSession.getInstance(null).cleanUserSession();
    Navigator.navigate(me, Navigator.HOME_PAGE);
  }
}
