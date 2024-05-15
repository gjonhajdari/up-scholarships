module org.example.knk_projekti {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.ikonli.javafx;
  requires java.sql;
    requires java.desktop;

    opens app to javafx.fxml;
  opens controller to javafx.fxml;
  opens model to javafx.base;

  exports app;
}