package prak4client;

import prak4gemklassen.Benutzer;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * AnmeldungsController gibt ein Fenster zum Registrieren mit Benutzername, Passwort und -wiederholung aus.
 */
public class AnmeldungsController {

  @FXML
  TextField textUserID;
  @FXML
  PasswordField textPasswort;
  @FXML
  PasswordField textPasswortWdh;
  @FXML
  Button buttonExecute;
  @FXML
  Label labelError;

  Client clientRef;

  /**
   * Setter-Methode für die MainApplication-Referenz.
   * @param client nimmt die Referenz der MainApplication an.
   */
  public void setMainApp(Client client) {
    clientRef = client;
  }

  /**
   * Zeigt eine bestimmbare Fehlermeldung im unteren Fensterbereich an.
   * @param message ist die anzuzeigende Fehlermeldung.
   */
  public void showError(String message) {
    labelError.setText(message);
    labelError.setVisible(true);
  }
  /**
   * Legt mit einem Drück auf Ausführen einen neuen prak4gemklassen.Benutzer an und gibt diesen auf der Konsole aus. Zeigt eine
   * Fehlermeldung an, falls die Passwörter nicht übereinstimmen.
   */
  @FXML
  public void onButtonExecuteClick(Event event) {
    if(textUserID.getText().isEmpty()) {
      showError("Bitte einen Benutzer eintragen.");
    } else if(textPasswort.getText().equals(textPasswortWdh.getText())) {
      Benutzer benutzer = new Benutzer(textUserID.getText(),textPasswort.getText().toCharArray());
      clientRef.neuerBenutzer(benutzer);
    } else {
      showError("Die Passwörter stimmen nicht überein.");
    }
  }
}
