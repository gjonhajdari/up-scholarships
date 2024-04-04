module org.example.knk_projekti {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.ikonli.javafx;

  opens org.example.knk_projekti to javafx.fxml;
  exports org.example.knk_projekti;
}