module com.srohter.styper {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.srohter.styper to javafx.fxml;
    exports com.srohter.styper;
}