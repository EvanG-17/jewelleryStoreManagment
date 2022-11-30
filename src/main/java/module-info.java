module com.example.jewellerystoremanagement1_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;
    requires org.junit.jupiter.api;


    opens com.example.jewellerystoremanagement1_1 to javafx.fxml,xstream;
    exports com.example.jewellerystoremanagement1_1;
    exports com.example.jewellerystoremanagement1_1.Controllers;
    opens com.example.jewellerystoremanagement1_1.Controllers to javafx.fxml;
    exports com.example.jewellerystoremanagement1_1.Models;
    opens com.example.jewellerystoremanagement1_1.Models to javafx.fxml,xstream;

}