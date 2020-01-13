package prak4client;

import prak4gemklassen.Benutzer;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;

/**
 * LoginController gibt ein Fenster zum Login mit Benutzername und -passwort aus.
 */
public class LoginController {

  private boolean neuAnmeldung = false;

  private boolean remote = false;

  @FXML
  TextField textUserID;
  @FXML
  PasswordField textPasswort;
  @FXML
  CheckBox checkboxNeuAnmeldung;
  @FXML
  CheckBox checkboxRemoteAnmeldung;
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
   * schreibt den aktuellen Zustand der Variable neuAnmeldung auf die Konsole, sobald die Checkbox gedrückt wird.
   */
  @FXML
  public void onCheckboxNeuAnmeldungClick(Event event) {
    neuAnmeldung = checkboxNeuAnmeldung.isSelected();
    System.out.println("Wert von neuAnmeldung: "+neuAnmeldung);
  }

  /**
   * Checkbox, ob Remote-Verbindung genutzt werden soll.
   */
  @FXML
  public void onCheckboxRemoteAnmeldungClick(Event event) {
    remote = checkboxRemoteAnmeldung.isSelected();
    System.out.println("Wert von remote: "+remote);
  }

  /**
   * Erzeugt beim Drücken des Ausführen-Buttons ein Benutzerobjekt und gibt es auf der Konsole aus.
   */
  @FXML
  public void onButtonExecuteClick(Event event) {

    if(neuAnmeldung) {
      if(remote) {
        clientRef.setRemote(true);
      } else {
        clientRef.setRemote(false);
      }
      clientRef.neuAnmeldung();
    } else {
      if(remote) {
        clientRef.setRemote(true);
      } else {
        clientRef.setRemote(false);
      }
      Benutzer benutzer = new Benutzer(textUserID.getText(),textPasswort.getText().toCharArray());
      clientRef.benutzerLogin(benutzer);
    }
  }

}
