import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Parent root;
    try {
      root = FXMLLoader.load(getClass().getResource("resources/anmeldung.fxml"));
      primaryStage.setTitle("Benutzerverwaltung");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
