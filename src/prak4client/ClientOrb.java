package prak4client;

import prak4gemklassen.Benutzer;
import prak4gemklassen.BenutzerBereitsInListeException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <p>Struktur von ClientOrb</p>
 * <p>Diese Klasse fungiert als Vermittlungsschicht zwischen Client und ServerOrb, nimmt Requests entgegen und leitet
 * diese weiter.</p>
 */
public class ClientOrb implements BenutzerVerwaltung {

  /**
   * Host-Adresse
   */
  private String host = "localhost";

  /**
   * Host-Port
   */
  private int port = 4711;

  /**
   * Kommuniziert mit ServerOrb, um abzufragen, ob Benutzer in Remote-Haltung vorkommt.
   * @param benutzer erwartet einen Benutzer um zu überprüfen, ob dieser in der benutzerListe auftaucht.
   * @return liefert, ob Benutzer in Liste vorkommt.
   */
  public boolean benutzerOk(Benutzer benutzer) {
    Socket socket = null;
    ObjectOutputStream os = null;
    ObjectInputStream is = null;
    boolean result = false;
    try {
      socket = new Socket(host,port);
      os = new ObjectOutputStream(socket.getOutputStream());
      is = new ObjectInputStream(socket.getInputStream());

      os.writeInt(1);
      os.writeObject(benutzer);
      os.flush();
      result = is.readBoolean();

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (is != null) {
          is.close();
        }
        if (os != null) {
          os.close();
        }
        if (socket != null) {
          socket.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return result;
  }

  /**
   * Kommuniziert mit ServerOrb, um einen Benutzer in die Remote-Liste einzutragen.
   * @param benutzer erwartet einen Benutzer zum Eintragen in die benutzerListe.
   */
  public void benutzerEintragen(Benutzer benutzer) throws BenutzerBereitsInListeException {
    Socket socket = null;
    ObjectOutputStream os = null;
    ObjectInputStream is = null;
    int result = 0;
    try {
      socket = new Socket(host,port);
      os = new ObjectOutputStream(socket.getOutputStream());
      is = new ObjectInputStream(socket.getInputStream());

      os.writeInt(2);
      os.writeObject(benutzer);
      os.flush();
      result = is.readInt();

      //Benutzer existiert
      if (result == 1) {
        throw new BenutzerBereitsInListeException("Benutzer existiert bereits.");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (is != null) {
          is.close();
        }
        if (os != null) {
          os.close();
        }
        if (socket != null) {
          socket.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
