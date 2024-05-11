package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Voucher;
import service.Navigator;
import service.UserSession;
import service.VoucherService;

import java.time.LocalDate;
import java.util.List;

public class DashboardStudentController {
    @FXML
    private Text txtWelcomeMessage;
    @FXML
    private TableView<Voucher> tblDashboardStudent;
    @FXML
    private TableColumn<Voucher, String> colTitle;
    @FXML
    private TableColumn<Voucher, Float> colAmount;
    @FXML
    private TableColumn<Voucher, LocalDate> colDeadline;

    public void initialize() {
        String firstName = UserSession.getInstance(null).getFirstName();
        txtWelcomeMessage.setText("Welcome back, " + firstName);

        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDeadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));

        List<Voucher> vouchers = VoucherService.getAllVouchers();
        ObservableList<Voucher> observableVouchers = FXCollections.observableArrayList(vouchers);
        tblDashboardStudent.setItems(observableVouchers);
    }

    @FXML
    private void handleAppliedClick(MouseEvent me) { Navigator.navigate(me, Navigator.APPLIED_STUDENT); }
    @FXML
    private void handleProfileClick(MouseEvent me) { Navigator.navigate(me, Navigator.PROFILE_STUDENT); }
    @FXML
    private void handleHelpClick(MouseEvent me) { Navigator.navigate(me, Navigator.HELP_STUDENT); }
    @FXML
    private void handleLogoutClick(MouseEvent me) {
        UserSession.getInstance(null).cleanUserSession();
        Navigator.navigate(me, Navigator.LOGIN_PAGE_STUDENT);
    }
}
