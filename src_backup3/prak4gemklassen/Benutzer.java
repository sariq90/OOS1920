package prak4gemklassen;

import java.io.Serializable;

/**
 * <p>Struktur von prak4gemklassen.Benutzer</p>
 * <p>Diese Klasse definiert die grundlegende Struktur von Benutzern. Sie setzt sich aus den Attributen userId und
 * passWort zusammen und implementiert die Standardmethoden equals und toString.</p>
 */
public class Benutzer implements Serializable {

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
   * Getter-Methode für userId:
   * @return liefert userId-Attribut als String.
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Getter-Methode für passWort:
   * @return liefert passWort-Attribut als Char-Array.
   */
  public char[] getPassWort() {
    return passWort;
  }

  /**
   * Setter-Methode für userId:
   * @param newUserId erwartet einen String.
   */
  public void setUserId(String newUserId) {
    userId = newUserId;
  }

  /**
   * Setter-Methode für passWort:
   * @param newPassWort erwartet ein Char-Array.
   */
  public void setPassWort(char[] newPassWort) {
    passWort = newPassWort;
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
   * @return liefert einen Wahrheitswert, ob die verglichenen prak4gemklassen.Benutzer (d.h. ob ihre Attribute) gleich sind.
   */
  @Override
  public boolean equals(Object benutzer) {
    return (benutzer instanceof Benutzer
      && this.userId.equals(((Benutzer) benutzer).userId)
      && String.copyValueOf(this.passWort).equals(String.copyValueOf(((Benutzer) benutzer).passWort)));
  }
}
