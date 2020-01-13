package prak4client;

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

  Client clientRef;

  /**
   * Setter-Methode für die MainApplication-Referenz.
   * @param client nimmt die Referenz der MainApplication an.
   */
  public void setMainApp(Client client) {
    clientRef = client;
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
