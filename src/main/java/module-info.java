module com.srohter.styper {
    requires javafx.controls;
    requires javafx.fxml;
    requires tess4j;
    requires java.desktop;
    requires org.jsoup;


    opens com.srohter.styper to javafx.fxml;
    exports com.srohter.styper;
}