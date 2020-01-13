package prak4serv;

import prak4gemklassen.Benutzer;
import prak4gemklassen.BenutzerBereitsInListeException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>Struktur von ServerOrb</p>
 * <p>Diese Klasse fungiert als Vermittlungsschicht zwischen Clientorb und Server, nimmt Requests entgegen und leitet
 * diese weiter.</p>
 */
public class ServerOrb {

  private BenutzerVerwaltungAdmin bv;
  private ObjectOutputStream os;
  private ObjectInputStream is;

  /**
   * Öffnet einen Port und stellt die Remote-Benutzerverwaltung für den ClientOrb bereit.
   * @param bv ist die vom Server bereitgestellte Benutzerverwaltung.
   */
  public ServerOrb(BenutzerVerwaltungAdmin bv) throws IOException {
    this.bv = bv;
    ServerSocket server = new ServerSocket(4711);


    while(true) {
      Socket socket = server.accept();
      is = new ObjectInputStream(socket.getInputStream());
      os = new ObjectOutputStream(socket.getOutputStream());
      Benutzer benutzer = new Benutzer();
      int callMethod = is.readInt();
//      try {
//        callMethod = is.readInt();
//      } catch (Exception e) {
//        System.exit(-1);
//      }
      if (callMethod == 1) {
        //benutzerOk
        try {
          boolean check = bv.benutzerOk((Benutzer)is.readObject());
          os.writeBoolean(check);
          os.flush();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
      } else if (callMethod == 2) {
        //benutzerEintragen
        try {
          bv.benutzerEintragen((Benutzer)is.readObject());
          os.writeInt(0);
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } catch (BenutzerBereitsInListeException e) {
          os.writeInt(1);
        } finally {
          os.flush();
        }

      }
    }
  }

}
