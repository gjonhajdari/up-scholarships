package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import service.Navigator;
import service.UserSession;

public class HelpAdminController {
        @FXML
        private void handleKosovoGovernmentButton(MouseEvent me) { Navigator.navigate(me, Navigator.KosovoGovernment_EXTERNAL_PAGE); }
        @FXML
        private void handleMASHTExternalButton(MouseEvent me) { Navigator.navigate(me, Navigator.MASHT_EXTERNAL_PAGE); }
        @FXML
        private void handleMFPTButtonClick(MouseEvent me) { Navigator.navigate(me, Navigator.MFPT_EXTERNAL_PAGE); }
        @FXML
        private void handleUPExternalButtonClick(MouseEvent me) { Navigator.navigate(me, Navigator.UP_EXTERNAL_PAGE); }


        @FXML
        private void handleDashboardClick(MouseEvent me) { Navigator.navigate(me, Navigator.DASHBOARD_ADMIN); }
        @FXML
        private void handleVouchersClick(MouseEvent me) { Navigator.navigate(me, Navigator.VOUCHERS_ADMIN); }
        @FXML
        private void handleCreateClick(MouseEvent me) { Navigator.navigate(me, Navigator.CREATE_VOUCHER); }
        @FXML
        private void handleProfileClick(MouseEvent me) { Navigator.navigate(me, Navigator.PROFILE_ADMIN); }
        @FXML
        private void handleHelpClick(MouseEvent me) {Navigator.navigate(me,Navigator.HELP_ADMIN);};
        @FXML
        private void handleLogoutClick(MouseEvent me) {
            UserSession.clearUserSession();
            Navigator.navigate(me, Navigator.HOME_PAGE);
        }
}

