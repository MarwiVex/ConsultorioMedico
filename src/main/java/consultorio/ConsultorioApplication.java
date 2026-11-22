package consultorio;

import atlantafx.base.theme.CupertinoLight;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ConsultorioApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());
        FXMLLoader fxmlLoader = new FXMLLoader(ConsultorioApplication.class.getResource("/fxml/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Iniciar sesion");
        stage.setScene(scene);
        stage.show();
    }
}
