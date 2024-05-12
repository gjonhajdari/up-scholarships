package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Voucher;
import service.*;

import java.time.LocalDate;
import java.util.List;

public class VouchersAdminController {

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
    private TableView<Voucher> tblDashboardStudent;
    @FXML
    private TableColumn<Voucher, String> colTitle;
    @FXML
    private TableColumn<Voucher, Float> colAmount;
    @FXML
    private TableColumn<Voucher, LocalDate> colDeadline;

    private int voucherId;

    public void initData(int id) {
        voucherId = id;
        txtVoucherId.setText("Voucher #" + String.valueOf(voucherId));

        Voucher voucher = VoucherService.getVoucherById(id);

        txtTitle.setText(voucher.getTitle());
        txtAmount.setText(Formatter.formatCurrency(voucher.getAmount()) + " EUR");
        txtDeadline.setText(Formatter.formatDate(voucher.getDeadline()));
        txtDescription.setText(voucher.getDescription());
    }
    public void initialize() {


        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDeadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));

        List<Voucher> vouchers = VoucherService.getAllVouchers();
        ObservableList<Voucher> observableVouchers = FXCollections.observableArrayList(vouchers);
        tblDashboardStudent.setItems(observableVouchers);

        // Listening for a click on a row to navigate to the dynamic voucher page
        tblDashboardStudent.setRowFactory(tv -> {
            TableRow<Voucher> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    Voucher clickedRow = row.getItem();
                    Navigator.navigate(event, Navigator.APPLICATIONS_PER_VOUCHER, clickedRow.getId());
                }
            });

            return row;
        });
    }
    @FXML
    private void handleAddNewClick(MouseEvent me){
        Navigator.navigate(me,Navigator.CREATE_VOUCHER);
    }
    @FXML
    private void handleDashboardClick(MouseEvent me) { Navigator.navigate(me, Navigator.DASHBOARD_ADMIN); }
    @FXML
    private void handleCreateClick(MouseEvent me) { Navigator.navigate(me, Navigator.CREATE_VOUCHER); }
    @FXML
    private void handleProfileClick(MouseEvent me) { Navigator.navigate(me, Navigator.PROFILE_ADMIN); }
    @FXML
    private void handleLogoutClick(MouseEvent me) {
      AdminSession.getInstance(null).cleanAdminSession();
      Navigator.navigate(me, Navigator.LOGIN_PAGE_ADMIN);
    }
}
