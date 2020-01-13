package benutzer;

/**
 * Exception für Benutzer-Duplikate in Listen
 */
public class BenutzerBereitsInListeException extends Exception {

  BenutzerBereitsInListeException(String meldung) {
    super(meldung);
  }
}
