module com.example.consultoriomedico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires atlantafx.base;

    opens consultorio to javafx.fxml, javafx.graphics;
    exports consultorio;

    opens consultorio.controller to javafx.fxml;
    exports consultorio.controller;

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
    exports consultorio.controller.admin;
    opens consultorio.controller.admin to javafx.fxml;

    exports consultorio.controller.asistente;
    opens consultorio.controller.asistente to javafx.fxml;
}
