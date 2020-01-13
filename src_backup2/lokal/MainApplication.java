package lokal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import benutzer.Benutzer;
import benutzer.BenutzerVerwaltungAdmin;
import benutzer.BenutzerBereitsInListeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication extends Application {

  public BenutzerVerwaltungAdmin bv = new BenutzerVerwaltungAdmin();
  private Stage stageRef;
  private LoginController loginCtrl;
  private AnmeldungsController anmeldungsCtrl;
  private AnwendungsController anwendungsCtrl;

  @Override
  public void start(Stage primaryStage) {

    stageRef = primaryStage;
    System.out.println("Datenhaltung initialisieren? 1 -> Ja, Any -> Nein: ");
    BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
    try {
      int dbInitialisieren = Integer.parseInt(din.readLine());
      if (dbInitialisieren == 1) {
        // init, else skip
        bv.dbInitialisieren();
      }
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    }
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/login.fxml"));
      Parent root = loader.load();
      loginCtrl = loader.getController();
      loginCtrl.setMainApp(this);
      stageRef.setTitle("Benutzerverwaltung: Login");
      stageRef.setScene(new Scene(root));
      stageRef.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Die Scene wird durch die Anmeldungs-Scene ersetzt und Controller-Referenzen werden ausgetauscht.
   */
  void neuAnmeldung() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/anmeldung.fxml"));
      Parent root = loader.load();
      anmeldungsCtrl = loader.getController();
      anmeldungsCtrl.setMainApp(this);
      stageRef.setTitle("Benutzerverwaltung: Anmeldung");
      stageRef.setScene(new Scene(root));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Es wird versucht, einen Benutzer in die Benutzerverwaltung einzutragen. Bei erfolgreichem Eintragen wird der User
   * zur Login-Scene weitergeleitet. Bei Misserfolg wird ein Fehler angezeigt.
   * @param benutzer nimmt den einzutragenden Benutzer entgegen.
   */
  void neuerBenutzer(Benutzer benutzer) {
    try {
      bv.benutzerEintragen(benutzer);
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/login.fxml"));
        Parent root = loader.load();
        loginCtrl = loader.getController();
        loginCtrl.setMainApp(this);
        stageRef.setTitle("Benutzerverwaltung: Login");
        stageRef.setScene(new Scene(root));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (BenutzerBereitsInListeException e) {
      e.printStackTrace();
      anmeldungsCtrl.showError("Dieser Benutzer existiert bereits.");
    }
  }

  /**
   * Es wird versucht, einen User in die Anwendung einzuloggen. Bei erfolgreichem Einloggen wird der User zur
   * Anwendungs-Scene weitergeleitet. Bei Misserfolg wird ein Fehler angezeigt.
   * @param benutzer nimmt den einzuloggenden Benutzer entgegen.
   */
  void benutzerLogin(Benutzer benutzer) {
    if (bv.benutzerOk(benutzer)) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/anwendung.fxml"));
        Parent root = loader.load();
        anwendungsCtrl = loader.getController();
        anwendungsCtrl.setMainApp(this);
        stageRef.setTitle("Benutzerverwaltung: Anwendung");
        stageRef.setScene(new Scene(root));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      loginCtrl.showError("Diese Benutzer/PW-Kombo existiert nicht.");
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
