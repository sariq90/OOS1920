import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * lokal.AnmeldungsController gibt ein Fenster zum Registrieren mit Benutzername, Passwort und -wiederholung aus.
 */
public class AnmeldungsController {

  @FXML
  TextField textUserID;
  @FXML
  PasswordField textPasswort;
  @FXML
  PasswordField textPasswortWdh;
  @FXML
  Label labelMismatch;
  @FXML
  Button buttonExecute;

  /**
   * Legt mit einem Drück auf Ausführen einen neuen Benutzer an und gibt diesen auf der Konsole aus. Zeigt eine
   * Fehlermeldung an, falls die Passwörter nicht übereinstimmen.
   */
  @FXML
  public void onButtonExecuteClick(Event event) {
    if(textPasswort.getText().equals(textPasswortWdh.getText())) {
      Benutzer benutzer = new Benutzer(textUserID.getText(),textPasswort.getText().toCharArray());
      System.out.println(benutzer);
      Stage fenster = (Stage)buttonExecute.getScene().getWindow();
      fenster.close();
    } else {
      labelMismatch.setVisible(true);
    }
  }

}
