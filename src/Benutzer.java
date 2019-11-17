/**
 * <p>Struktur von Benutzer</p>
 * <p>Diese Klasse definiert die grundlegende Struktur von Benutzern. Sie setzt sich aus den Attributen userId und
 * passWort zusammen und implementiert die Standardmethoden equals und toString.</p>
 */
public class Benutzer {

  /**
   * Attribut zur Speicherung der User-ID:
   */
  public String userId;

  /**
   * Attribut zur Speicherung des User-Passworts:
   */
  public char[] passWort;

  /**
   * Default-Konstruktor:
   */
  public Benutzer() {
    this.userId = "default";
    this.passWort = "default".toCharArray();
  }

  /**
   * Konstruktor mit Übergabe einer userId und eines passWorts:
   */
  public Benutzer(String userId, char[] passWort) {
    this.userId = userId;
    this.passWort = passWort;
  }

  /**
   * toString-Methode:
   * @return liefert die Stringrepräsentation (userId;passWort).
   */
  public String toString() {
    return "("+userId+";"+String.copyValueOf(passWort)+")";
  }

  /**
   * equals-Methode:
   * @param benutzer erwartet ein Objekt zum Vergleichen mit dem aktuellen Objekt.
   * @return liefert einen Wahrheitswert, ob die verglichenen Benutzer (d.h. ob ihre Attribute) gleich sind.
   */
  @Override
  public boolean equals(Object benutzer) {
    return (benutzer instanceof Benutzer && benutzer != null //dadurch abgedeckt
      && this.userId.equals(((Benutzer) benutzer).userId)
      && String.copyValueOf(this.passWort).equals(String.copyValueOf(((Benutzer) benutzer).passWort)));
  }
}
