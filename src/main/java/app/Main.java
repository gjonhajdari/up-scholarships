package app;

import javafx.application.Application;
import javafx.stage.Stage;
import service.Navigator;

public class Main extends Application {
  public void start(Stage primaryStage) {
    primaryStage.setTitle("UP Scholarships");
    Navigator.setCurrentStage(primaryStage);
    Navigator.navigate(primaryStage, Navigator.HOME_PAGE);
  }
}