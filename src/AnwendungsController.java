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
