//
//package service;
//
//import controller.interfaces.InitialisableController;
//import javafx.event.Event;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.Locale;
//import java.util.ResourceBundle;
//import java.util.Stack;
//
//public class Navigator {
//  public final static String HOME_PAGE          = "home_page.fxml";
//  public final static String LOGIN_PAGE_STUDENT = "login_page_student.fxml";
//  public final static String DASHBOARD_STUDENT  = "dashboard_page_student.fxml";
//  public final static String VOUCHER_STUDENT    = "voucher_page_student.fxml";
//  public final static String APPLIED_STUDENT    = "applied_page_student.fxml";
//  public final static String VOUCHER_APPLIED    = "applied_voucher_page_student.fxml";
//  public final static String PROFILE_STUDENT    = "profile_page_student.fxml";
//  public final static String HELP_STUDENT       = "help_page_student.fxml";
//  public final static String LOGIN_PAGE_ADMIN   = "login_page_admin.fxml";
//  public final static String DASHBOARD_ADMIN    = "dashboard_page_admin.fxml";
//  public final static String VOUCHERS_ADMIN     = "vouchers_page_admin.fxml";
//  public final static String CREATE_VOUCHER     = "create_voucher_admin.fxml";
//  public final static String PROFILE_ADMIN      = "profile_page_admin.fxml";
//  public final static String APPLICANTS_PAGE    = "applicants_page.fxml";
//  public final static String UP_EXTERNAL_PAGE = "https://uni-pr.edu/";
//  public final static String MFPT_EXTERNAL_PAGE = "https://mfpt.rks-gov.net/";
//  public final static String MASHT_EXTERNAL_PAGE = "https://masht.rks-gov.net/";
//  public final static String KosovoGovernment_EXTERNAL_PAGE = "https://kryeministri.rks-gov.net/";
//
//  private static Stack<String> history = new Stack<>();
//
//  public static void navigate(Event event, String path) {
//    // Check if the path is a web URL
//    if (path.startsWith("http://") || path.startsWith("https://")) {
//      navigateToExternalLink(path);
//    } else {
//      // Navigate -> event -> from current scene to new scene
//      Node eventNode = (Node) event.getSource();
//      Stage stage = (Stage) eventNode.getScene().getWindow();
//
//      navigate(stage, path);
//    }
//  }
//
//  public static void navigate(Stage stage, String path) {
//    try {
//      Pane newPane = loadPane("/app/" + path);
//
//      if (newPane != null) {
//        Scene newScene = new Scene(newPane);
//        stage.setScene(newScene);
//        stage.show();
//
//        // Adding the navigated page to the history stack
//        if (history.isEmpty() || !history.peek().equals(path)) {
//          history.push(path);
//        }
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void navigate(Event event, String path, int id) {
//    Node eventNode = (Node) event.getSource();
//    Stage stage = (Stage) eventNode.getScene().getWindow();
//
//    navigate(stage, path, id);
//  }
//
//  public static void navigate(Stage stage, String path, int id) {
//    try {
//      Pane newPane = loadPane("/app/" + path);
//
//      if (newPane != null) {
//        Scene newScene = new Scene(newPane);
//        stage.setScene(newScene);
//        stage.show();
//
//        FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/app/" + path));
//        loader.setResources(ResourceBundle.getBundle("translations.content", Locale.getDefault()));
//        loader.load();
//
//        InitialisableController controller = loader.getController();
//        controller.initData(id);
//
//        // Adding the navigated page to the history stack
//        if (history.isEmpty() || !history.peek().equals(path)) {
//          history.push(path);
//        }
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  private static Pane loadPane(String form) {
//    ResourceBundle bundle = ResourceBundle.getBundle("translations.content", Locale.getDefault());
//    FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(form), bundle);
//    try {
//      return loader.load();
//    } catch (IOException ioe) {
//      ioe.printStackTrace();
//      return null;
//    }
//  }
//
//  private static void navigateToExternalLink(String url) {
//    try {
//      java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void back(Event event) {
//    Node eventNode = (Node) event.getSource();
//    Stage stage = (Stage) eventNode.getScene().getWindow();
//
//    if (!history.isEmpty()) {
//      history.pop();
//
//      if (!history.isEmpty()) {
//        String previousPath = history.peek();
//        navigate(stage, previousPath);
//      }
//    }
//  }
//}

//package service;
//
//import controller.interfaces.InitialisableController;
//import javafx.event.Event;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.Locale;
//import java.util.ResourceBundle;
//import java.util.Stack;
//
//public class Navigator {
//  public final static String HOME_PAGE          = "home_page.fxml";
//  public final static String LOGIN_PAGE_STUDENT = "login_page_student.fxml";
//  public final static String DASHBOARD_STUDENT  = "dashboard_page_student.fxml";
//  public final static String VOUCHER_STUDENT    = "voucher_page_student.fxml";
//  public final static String APPLIED_STUDENT    = "applied_page_student.fxml";
//  public final static String VOUCHER_APPLIED    = "applied_voucher_page_student.fxml";
//  public final static String PROFILE_STUDENT    = "profile_page_student.fxml";
//  public final static String HELP_STUDENT       = "help_page_student.fxml";
//  public final static String LOGIN_PAGE_ADMIN   = "login_page_admin.fxml";
//  public final static String DASHBOARD_ADMIN    = "dashboard_page_admin.fxml";
//  public final static String VOUCHERS_ADMIN     = "vouchers_page_admin.fxml";
//  public final static String CREATE_VOUCHER     = "create_voucher_admin.fxml";
//  public final static String PROFILE_ADMIN      = "profile_page_admin.fxml";
//  public final static String APPLICANTS_PAGE    = "applicants_page.fxml";
//  public final static String UP_EXTERNAL_PAGE = "https://uni-pr.edu/";
//  public final static String MFPT_EXTERNAL_PAGE = "https://mfpt.rks-gov.net/";
//  public final static String MASHT_EXTERNAL_PAGE = "https://masht.rks-gov.net/";
//  public final static String KosovoGovernment_EXTERNAL_PAGE = "https://kryeministri.rks-gov.net/";
//
//  private static Stack<String> history = new Stack<>();
//
//
//  public static void navigate(Event event, String path) {
//    // Check if the path is a web URL
//    if (path.startsWith("http://") || path.startsWith("https://")) {
//      navigateToExternalLink(path);
//    } else {
//      // Navigate -> event -> from current scene to new scene
//      Node eventNode = (Node) event.getSource();
//      Stage stage = (Stage) eventNode.getScene().getWindow();
//
//      navigate(stage, path);
//    }
//  }
//
//
//  public static void navigate(Stage stage, String path) {
//    FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/app/" + path));
//
//    try {
//        Pane newPane = loadPane("/app/"+path);
//      if (newPane != null) {
//        Scene newScene = new Scene(loader.load());
//        stage.setScene(newScene);
//        stage.show();
//      }
//
//
//      // Adding the navigated page to the history stack
//      if (history.isEmpty() || !history.peek().equals(path)) {
//        history.push(path);
//      }
//    } catch (Exception ioe) {
//      ioe.printStackTrace();
//    }
//  }
//
//
//  public static void navigate(Event event, String path, int id) {
//    Node eventNode = (Node) event.getSource();
//    Stage stage = (Stage) eventNode.getScene().getWindow();
//
//    navigate(stage, path, id);
//  }
//
//
//  public static void navigate(Stage stage, String path, int id) {
//    FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/app/" + path));
//
//    try {
//      Pane newPane=loadPane("/app/"+path);
//      if(newPane !=null){
//        Scene newScene = new Scene(loader.load());
//        stage.setScene(newScene);
//        stage.show();
//      }
//
//
//      InitialisableController controller = loader.getController();
//      controller.initData(id);
//
//      // Adding the navigated page to the history stack
//      if (history.isEmpty() || !history.peek().equals(path)) {
//        history.push(path);
//      }
//    } catch (IOException ioe) {
//      ioe.printStackTrace();
//    }
//  }
//
//  private static Pane loadPane(String form){
//
//    ResourceBundle bundle = ResourceBundle.getBundle(
//            "translations.content", Locale.getDefault()
//    );
//    FXMLLoader loader = new FXMLLoader(
//            Navigator.class.getResource(form), bundle
//    );
//    try {
//      return loader.load();
//    }catch (IOException ioe){
//      return null;
//    }
//  }
//
//  private static void navigateToExternalLink(String url) {
//    try {
//      java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//
//  public static void back(Event event) {
//    Node eventNode = (Node) event.getSource();
//    Stage stage = (Stage) eventNode.getScene().getWindow();
//
//    if (!history.isEmpty()) {
//      history.pop();
//
//      if (!history.isEmpty()) {
//        String previousPath = history.peek();
//        navigate(stage, previousPath);
//      }
//    }
//  }
//}



package service;

import controller.interfaces.InitialisableController;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Stack;

public class Navigator {
  public final static String HOME_PAGE = "home_page.fxml";
  public final static String LOGIN_PAGE_STUDENT = "login_page_student.fxml";
  public final static String DASHBOARD_STUDENT = "dashboard_page_student.fxml";
  public final static String VOUCHER_STUDENT = "voucher_page_student.fxml";
  public final static String APPLIED_STUDENT = "applied_page_student.fxml";
  public final static String VOUCHER_APPLIED = "applied_voucher_page_student.fxml";
  public final static String PROFILE_STUDENT = "profile_page_student.fxml";
  public final static String HELP_STUDENT = "help_page_student.fxml";
  public final static String HELP_ADMIN = "help_page_admin.fxml";
  public final static String LOGIN_PAGE_ADMIN = "login_page_admin.fxml";
  public final static String DASHBOARD_ADMIN = "dashboard_page_admin.fxml";
  public final static String VOUCHERS_ADMIN = "vouchers_page_admin.fxml";
  public final static String CREATE_VOUCHER = "create_voucher_admin.fxml";
  public final static String PROFILE_ADMIN = "profile_page_admin.fxml";
  public final static String APPLICANTS_PAGE = "applicants_page.fxml";
  public final static String UP_EXTERNAL_PAGE = "https://uni-pr.edu/";
  public final static String MFPT_EXTERNAL_PAGE = "https://mfpt.rks-gov.net/";
  public final static String MASHT_EXTERNAL_PAGE = "https://masht.rks-gov.net/";
  public final static String KosovoGovernment_EXTERNAL_PAGE = "https://kryeministri.rks-gov.net/";

  private static Stack<String> history = new Stack<>();
  private static Stage currentStage;

  public static void setCurrentStage(Stage stage) {
    currentStage = stage;
  }

  private static Stage getCurrentStage() {
    return currentStage;
  }

  public static void navigate(Event event, String path) {
    if (path.startsWith("http://") || path.startsWith("https://")) {
      navigateToExternalLink(path);
    } else {
      Node eventNode = (Node) event.getSource();
      Stage stage = (Stage) eventNode.getScene().getWindow();
      setCurrentStage(stage);
      navigate(stage, path);
    }
  }

  public static void navigate(Stage stage, String path) {
    try {
      Pane newPane = loadPane("/app/" + path);
      if (newPane != null) {
        Scene newScene = new Scene(newPane);
        stage.setScene(newScene);
        stage.show();

        if (history.isEmpty() || !history.peek().equals(path)) {
          history.push(path);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void navigate(Event event, String path, int id) {
    Node eventNode = (Node) event.getSource();
    Stage stage = (Stage) eventNode.getScene().getWindow();
    setCurrentStage(stage);
    navigate(stage, path, id);
  }

  public static void navigate(Stage stage, String path, int id) {
    try {
      FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/app/" + path));
      loader.setResources(ResourceBundle.getBundle("translations.content", Locale.getDefault()));
      Pane newPane = loader.load();

      if (newPane != null) {
        Scene newScene = new Scene(newPane);
        stage.setScene(newScene);
        stage.show();

        InitialisableController controller = loader.getController();
        controller.initData(id);

        if (history.isEmpty() || !history.peek().equals(path)) {
          history.push(path);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void reloadCurrentScene(ResourceBundle bundle) {
    if (!history.isEmpty()) {
      String currentPath = history.peek();
      Stage stage = getCurrentStage();
      reloadScene(stage, currentPath, bundle);
    }
  }

  private static void reloadScene(Stage stage, String path, ResourceBundle bundle) {
    try {
      FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/app/" + path));
      loader.setResources(bundle);
      Pane newPane = loader.load();
      Scene newScene = new Scene(newPane);
      stage.setScene(newScene);
      stage.show();

      if (!history.isEmpty() && history.peek().equals(path)) {
        history.pop();
      }
      history.push(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static Pane loadPane(String form) {
    ResourceBundle bundle = ResourceBundle.getBundle("translations.content", Locale.getDefault());
    FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(form), bundle);
    try {
      return loader.load();
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return null;
    }
  }

  private static void navigateToExternalLink(String url) {
    try {
      java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void back(Event event) {
    Node eventNode = (Node) event.getSource();
    Stage stage = (Stage) eventNode.getScene().getWindow();

    if (!history.isEmpty()) {
      history.pop();

      if (!history.isEmpty()) {
        String previousPath = history.peek();
        navigate(stage, previousPath);
      }
    }
  }

  public static void goBack(Event event) {
    if (history.size() > 1) {
      history.pop();
      navigate(event, history.peek());
    }
  }
}
