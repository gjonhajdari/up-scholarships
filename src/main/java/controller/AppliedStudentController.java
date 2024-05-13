package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Voucher;
import repository.VoucherRepository;
import service.AdminSession;
import service.Navigator;
import service.UserSession;
import service.VoucherService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppliedStudentController {

    @FXML
    private TableView<Voucher> tblAppliedStudent;
    @FXML
    private TableColumn<Voucher, String> colTitle;
    @FXML
    private TableColumn<Voucher, Float> colAmount;
    @FXML
    private TableColumn<Voucher, LocalDate> colDeadline;
    @FXML
    private TableColumn<Voucher, String> colStatus;


    public void initialize(){
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDeadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));

        // Using a custom Callback to fetch status dynamically
        colStatus.setCellValueFactory(cellData -> {
            Voucher voucher = cellData.getValue();
            StringProperty statusProperty = new SimpleStringProperty();
            // Assuming you have a method to fetch status by voucherId in your VoucherService
            String status = VoucherRepository.getStatusByVoucherId(voucher.getId());
            statusProperty.set(status);
            return statusProperty;
        });

        // Fetch vouchers only if they are in the application table
        List<Voucher> vouchersInApplication = new ArrayList<>();
        List<Voucher> allVouchers = VoucherService.getAllVouchers();
        for (Voucher voucher : allVouchers) {
            if (VoucherRepository.isVoucherInApplication(voucher.getId())) {
                vouchersInApplication.add(voucher);
            }
        }

        ObservableList<Voucher> observableVouchers = FXCollections.observableArrayList(vouchersInApplication);
        tblAppliedStudent.setItems(observableVouchers);

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
