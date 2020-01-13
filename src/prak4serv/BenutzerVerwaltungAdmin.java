package prak4serv;

import prak4gemklassen.Benutzer;
import prak4gemklassen.BenutzerBereitsInListeException;

import java.io.*;
import java.util.ArrayList;

/**
 * <p>Struktur von BenutzerVerwaltungAdmin</p>
 * <p>Diese Klasse implementiert das Interface BenutzerVerwaltung und seine Methoden benutzerEintragen sowie
 * benutzerOk, mit denen ein neuer Benutzer angelegt und seine Validität überprüft werden kann. Die persistente
 * Speicherung findet im der Datei "Benutzerverwaltung" im root-Verzeichnis statt.</p>
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

  /**
   * Attribut zur Speicherung von Benutzern:
   */
  private ArrayList<Benutzer> benutzerListe;

  /**
   * Attribut zur Speicherung des Dateinamen:
   */
  private String filename;

  /**
   * Default-Konstruktor:
   */
  public BenutzerVerwaltungAdmin () {
    benutzerListe = new ArrayList<Benutzer>();
    filename = "./src/remote/Benutzerverwaltung.txt";
  }

  /**
   * benutzerEintragen-Methode:
   * @param benutzer erwartet einen prak4gemklassen.Benutzer zum Eintragen in die benutzerListe.
   * @throws BenutzerBereitsInListeException wenn der Benutzer bereits in der benutzerListe drin ist.
   */
  @Override
  public void benutzerEintragen(Benutzer benutzer) throws BenutzerBereitsInListeException {
    if (benutzerOk(benutzer)) {
      throw new BenutzerBereitsInListeException("Dieser Benutzer ist bereits in der Liste.");
    } else if (benutzer != null) {
      benutzerListe.add(benutzer);
      dbSerialisieren();
    }
  }

  /**
   * benutzerOk-Methode:
   * @param benutzer erwartet einen Benutzer um zu überprüfen, ob dieser in der benutzerListe auftaucht.
   * @return liefert True, wenn der Benutzer in der Liste ist, sonst False.
   */
  @Override
  public boolean benutzerOk(Benutzer benutzer) {
    dbDeserialisieren();
    return benutzerListe.contains(benutzer);
  }

  /**
   * benutzerLöschen-Methode:
   * @param benutzer erwartet einen Benutzer, um diesen aus der benutzerListe zu entfernen.
   * @throws BenutzerNichtInListeException wenn der Benutzer nicht in der Liste auftaucht.
   */
  public void benutzerLöschen(Benutzer benutzer) throws BenutzerNichtInListeException {
    if (!benutzerOk(benutzer)) {
      throw new BenutzerNichtInListeException("Dieser Benutzer ist nicht in der Liste.");
    } else if (benutzer != null) {
      benutzerListe.remove(benutzer);
      dbSerialisieren();
    }
  }

  /**
   * dbInitialisieren-Methode:
   * Serialisiert eine neue leere benutzerListe.
   */
  public void dbInitialisieren() {
    benutzerListe = new ArrayList<Benutzer>();
    dbSerialisieren();
  }

  /**
   * Serialisiert die modifizierte benutzerListe unter "Benutzerverwaltung".
   */
  private void dbSerialisieren() {
    try {
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(filename)));
      os.writeObject(benutzerListe);
      os.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Deserialisiert die benutzerListe aus der Datei "Benutzerverwaltung" zur Modifizierung.
   */
  private void dbDeserialisieren() {
    try {
      ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File(filename)));
      benutzerListe = (ArrayList<Benutzer>) is.readObject();
      is.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}

// Exception für Benutzer-Duplikate in Listen
//class BenutzerBereitsInListeException extends Exception {
//
//  BenutzerBereitsInListeException(String meldung) {
//    super(meldung);
//  }
//}

// Exception für fehlende Benutzer in Listen
class BenutzerNichtInListeException extends Exception {

  BenutzerNichtInListeException(String meldung) {
    super(meldung);
  }
}