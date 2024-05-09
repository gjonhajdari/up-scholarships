package service;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigator {
  public final static String HOME_PAGE = "home_page.fxml";
  public final static String LOGIN_PAGE_STUDENT = "login_page_student.fxml";
  public final static String DASHBOARD_STUDENT = "dashboard_page_student.fxml";
  public final static String PROFILE_STUDENT = "profile_page_student.fxml";
  public final static String LOGIN_PAGE_ADMIN = "login_page_admin.fxml";
  public final static String DASHBOARD_ADMIN = "dashboard_page_admin.fxml";
  public final static String CREATE_VOUCHER = "create_voucher_page.fxml";

  public static void navigate(Event event, String path) {
    // Navigate -> event -> from current scene to new scene
    Node eventNode = (Node) event.getSource();
    Stage stage = (Stage) eventNode.getScene().getWindow();

    navigate(stage, path);
  }

  public static void navigate(Stage stage, String path) {
    FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/app/" + path));

    try {
      Scene newScene = new Scene(loader.load());
      stage.setScene(newScene);
      stage.show();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}