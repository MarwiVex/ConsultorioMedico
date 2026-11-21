module com.example.consultoriomedico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens consultorio.modelo to javafx.fxml;
    exports consultorio.modelo;

    opens consultorio.modelo.enums to javafx.fxml;
    exports consultorio.modelo.enums;

    opens consultorio.admon to javafx.fxml;
    exports consultorio.admon;

    opens consultorio.configuracion to javafx.fxml;
    exports consultorio.configuracion;

    opens consultorio.servicios to javafx.fxml;
    exports consultorio.servicios;
}
