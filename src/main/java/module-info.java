module com.example.songmp3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.songmp3 to javafx.fxml;
    exports com.example.songmp3;
}