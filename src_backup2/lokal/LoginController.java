package lokal;

import benutzer.Benutzer;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.Stage;

/**
 * LoginController gibt ein Fenster zum Login mit Benutzername und -passwort aus.
 */
public class LoginController {

  private boolean neuAnmeldung = false;

  @FXML
  TextField textUserID;
  @FXML
  PasswordField textPasswort;
  @FXML
  CheckBox checkboxNeuAnmeldung;
  @FXML
  Button buttonExecute;
  @FXML
  Label labelError;

  MainApplication mainApplicationRef;

  /**
   * Setter-Methode für die MainApplication-Referenz.
   * @param mainApplication nimmt die Referenz der MainApplication an.
   */
  public void setMainApp(MainApplication mainApplication) {
    mainApplicationRef = mainApplication;
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
   * Erzeugt beim Drücken des Ausführen-Buttons ein Benutzerobjekt und gibt es auf der Konsole aus.
   */
  @FXML
  public void onButtonExecuteClick(Event event) {
    if(neuAnmeldung) {
      mainApplicationRef.neuAnmeldung();
    } else {
      Benutzer benutzer = new Benutzer(textUserID.getText(),textPasswort.getText().toCharArray());
      mainApplicationRef.benutzerLogin(benutzer);
    }
  }

}
