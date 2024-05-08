module org.example.knk_projekti {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.ikonli.javafx;
  requires java.sql;

  opens app to javafx.fxml;
  opens controller to javafx.fxml;

  exports app;
}