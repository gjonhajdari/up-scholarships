package controller;

import controller.interfaces.InitialisableController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.ApplicantWithData;
import model.Voucher;
import service.AdminSession;
import service.Formatter;
import service.Navigator;
import service.VoucherService;

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
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDateApplied.setCellValueFactory(new PropertyValueFactory<>("applicationDate"));
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
        Navigator.navigate(me, Navigator.LOGIN_PAGE_ADMIN);
    }

}
