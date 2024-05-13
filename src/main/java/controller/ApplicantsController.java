package controller;

import controller.interfaces.InitialisableController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.ApplicantWithData;
import model.Voucher;
import service.*;
import utils.Formatter;

import java.time.LocalDate;
import java.util.List;

public class ApplicantsController implements InitialisableController {
  @FXML
  private Text txtVoucherId;
  @FXML
  private Text txtTitle;
  @FXML
  private Text txtAmount;
  @FXML
  private Text txtDeadline;
  @FXML
  private Text txtDescription;

  @FXML
  private TableView<ApplicantWithData> tblApplicationsAdmin;
  @FXML
  private TableColumn<ApplicantWithData, String> colStudentId;
  @FXML
  private TableColumn<ApplicantWithData, String> colFirstName;
  @FXML
  private TableColumn<ApplicantWithData, String> colLastName;
  @FXML
  private TableColumn<ApplicantWithData, String> colStatus;
  @FXML
  private TableColumn<ApplicantWithData, LocalDate> colDateApplied;

  private int voucherId;

  public void initData(int id) {
    voucherId = id;
    txtVoucherId.setText("Voucher #" + String.valueOf(voucherId));

    Voucher voucher = VoucherService.getVoucherById(id);

    txtTitle.setText(voucher.getTitle());
    txtAmount.setText(Formatter.formatCurrency(voucher.getAmount()) + " EUR");
    txtDeadline.setText(Formatter.formatDate(voucher.getDeadline()));
    txtDescription.setText(voucher.getDescription());

    List<ApplicantWithData> applications = VoucherService.getApplicants(voucherId);
    ObservableList<ApplicantWithData> observableApplicants = FXCollections.observableArrayList(applications);
    tblApplicationsAdmin.setItems(observableApplicants);
  }

  public void initialize() {
    colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
    colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    colDateApplied.setCellValueFactory(new PropertyValueFactory<>("applicationDate"));


    TableColumn<ApplicantWithData, Void> colButtonAccept = new TableColumn<>("Accept");
    Callback<TableColumn<ApplicantWithData, Void>, TableCell<ApplicantWithData, Void>> cellFactoryAccept = new Callback<>() {
      @Override
      public TableCell<ApplicantWithData, Void> call(final TableColumn<ApplicantWithData, Void> param) {
        final TableCell<ApplicantWithData, Void> cell = new TableCell<>() {
          private final Button btn = new Button("Accept");

          {
            btn.setStyle("-fx-background-color: #2dd4bf; -fx-border-color: #14b8a6; -fx-text-fill: #ffffff; -fx-border-radius: 6px; -fx-background-radius: 6px");
            btn.setOnAction((ActionEvent event) -> {
              ApplicantWithData data = getTableView().getItems().get(getIndex());
              // Call the service to update the status to ACCEPTED
              boolean updated = ApplicationService.updateStatus(data.getId(), "ACCEPTED");

              if (updated) {
                data.setStatus("ACCEPTED");
                tblApplicationsAdmin.refresh();
              }
            });
          }

          @Override
          public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(btn);
            }
          }
        };
        return cell;
      }
    };
    colButtonAccept.setCellFactory(cellFactoryAccept);
    colButtonAccept.setPrefWidth(95);
    tblApplicationsAdmin.getColumns().add(colButtonAccept);

    // Add a new column for the Reject button
    TableColumn<ApplicantWithData, Void> colButtonReject = new TableColumn<>("Reject");
    Callback<TableColumn<ApplicantWithData, Void>, TableCell<ApplicantWithData, Void>> cellFactoryReject = new Callback<>() {
      @Override
      public TableCell<ApplicantWithData, Void> call(final TableColumn<ApplicantWithData, Void> param) {
        final TableCell<ApplicantWithData, Void> cell = new TableCell<>() {
          private final Button btn = new Button("Reject");

          {
            btn.setStyle("-fx-background-color: #f87171; -fx-border-color: #ef4444; -fx-text-fill: #ffffff; -fx-border-radius: 6px; -fx-background-radius: 6px");
            btn.setOnAction((ActionEvent event) -> {
              ApplicantWithData data = getTableView().getItems().get(getIndex());
              // Call the service to update the status to REJECTED
              boolean updated = ApplicationService.updateStatus(data.getId(), "REJECTED");

              if (updated) {
                data.setStatus("REJECTED");
                tblApplicationsAdmin.refresh();
              }
            });
          }

          @Override
          public void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(btn);
            }
          }
        };
        return cell;
      }
    };
    colButtonReject.setCellFactory(cellFactoryReject);
    colButtonReject.setPrefWidth(95);
    tblApplicationsAdmin.getColumns().add(colButtonReject);
  }

  @FXML
  private void handleBackClick(MouseEvent me) { Navigator.back(me); }
  @FXML
  private void handleDashboardClick(MouseEvent me) { Navigator.navigate(me, Navigator.DASHBOARD_ADMIN); }
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
