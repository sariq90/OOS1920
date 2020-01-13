import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.Stage;

/**
 * lokal.LoginController gibt ein Fenster zum Login mit Benutzername und -passwort aus.
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
    Benutzer benutzer = new Benutzer(textUserID.getText(),textPasswort.getText().toCharArray());
    System.out.println(benutzer);
    Stage fenster = (Stage)buttonExecute.getScene().getWindow();
    fenster.close();
  }
}
