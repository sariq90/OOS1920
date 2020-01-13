package lokal;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.Stage;

/**
 * AnwendungsController gibt ein Fenster mit einem Abbrechen-Button aus, welcher das Fenster schließt.
 */
public class AnwendungsController {

  @FXML
  Label labelAnwendung;
  @FXML
  Button buttonCancel;

  MainApplication mainApplicationRef;

  /**
   * Setter-Methode für die MainApplication-Referenz.
   * @param mainApplication nimmt die Referenz der MainApplication an.
   */
  public void setMainApp(MainApplication mainApplication) {
    mainApplicationRef = mainApplication;
  }
  /**
   * Schließt das Fenster Anwendung, sobald der Abbrechen-Button gedrückt wird.
   */
  @FXML
  public void onButtonCancelClick(Event event) {
    System.out.println("Vorgang abgebrochen.");
    Stage fenster = (Stage)buttonCancel.getScene().getWindow();
    fenster.close();
  }
}
