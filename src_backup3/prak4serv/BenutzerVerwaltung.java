package prak4serv;

import prak4gemklassen.Benutzer;
import prak4gemklassen.BenutzerBereitsInListeException;

/**
 * <p>Struktur von benutzer.BenutzerVerwaltung</p>
 * <p>Dieses Interface stellt Methoden zur Manipulation von Benutzern zur Verfügung. Es deklariert die Methoden
 * benutzerEintragen und benutzerOk, mit denen ein neuer prak4gemklassen.Benutzer angelegt und seine Validität überprüft werden kann.</p>
 */
public interface BenutzerVerwaltung {

  /**
   * benutzerEintragen-Methode:
   * @param benutzer erwartet einen prak4gemklassen.Benutzer zum Eintragen in die benutzerListe.
   * @throws BenutzerBereitsInListeException wenn der prak4gemklassen.Benutzer bereits in der benutzerListe drin ist.
   */
  void benutzerEintragen(Benutzer benutzer) throws BenutzerBereitsInListeException;

  /**
   * benutzerOk-Methode:
   * @param benutzer erwartet einen prak4gemklassen.Benutzer um zu überprüfen, ob dieser in der benutzerListe auftaucht.
   * @return liefert True, wenn der prak4gemklassen.Benutzer in der Liste ist, sonst False.
   */
  boolean benutzerOk(Benutzer benutzer);
}
