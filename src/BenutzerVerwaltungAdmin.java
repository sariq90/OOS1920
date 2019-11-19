import java.util.ArrayList;

/**
 * <p>Struktur von BenutzerVerwaltungAdmin</p>
 * <p>Diese Klasse implementiert das Interface BenutzerVerwaltung und seine Methoden benutzerEintragen sowie
 * benutzerOk, mit denen ein neuer Benutzer angelegt und seine Validität überprüft werden kann.</p>
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

  /**
   * Attribut zur Speicherung von Benutzern:
   */
  private ArrayList<Benutzer> benutzerListe;

  /**
   * Default-Konstruktor:
   */
  public BenutzerVerwaltungAdmin () {
    benutzerListe = new ArrayList<Benutzer>();
  }

  /**
   * benutzerEintragen-Methode:
   * @param benutzer erwartet einen Benutzer zum Eintragen in die benutzerListe.
   * @throws BenutzerBereitsInListeException wenn der Benutzer bereits in der benutzerListe drin ist.
   */
  @Override
  public void benutzerEintragen(Benutzer benutzer) throws BenutzerBereitsInListeException {
    if (benutzerOk(benutzer)) {
      throw new BenutzerBereitsInListeException("Dieser Benutzer ist bereits in der Liste.");
    } else if (benutzer != null) {
      benutzerListe.add(benutzer);
    }
  }

  /**
   * benutzerOk-Methode:
   * @param benutzer erwartet einen Benutzer um zu überprüfen, ob dieser in der benutzerListe auftaucht.
   * @return liefert True, wenn der Benutzer in der Liste ist, sonst False.
   */
  @Override
  public boolean benutzerOk(Benutzer benutzer) {
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
    }
  }

  public String toString() {
    String s = "< ";
    for (Benutzer benutzer : benutzerListe) {
      s += benutzer.toString() + " ";
    }
    return s+">";
  }
}

// Exception für Benutzer-Duplikate in Listen
class BenutzerBereitsInListeException extends Exception {

  BenutzerBereitsInListeException(String meldung) {
    super(meldung);
  }
}

// Exception für fehlende Benutzer in Listen
class BenutzerNichtInListeException extends Exception {

  BenutzerNichtInListeException(String meldung) {
    super(meldung);
  }
}