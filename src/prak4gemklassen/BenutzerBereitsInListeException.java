package prak4gemklassen;

/**
 * Exception für Benutzer-Duplikate in Listen
 */
public class BenutzerBereitsInListeException extends Exception {

  public BenutzerBereitsInListeException(String meldung) {
    super(meldung);
  }
}
