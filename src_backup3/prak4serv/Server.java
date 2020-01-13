package prak4serv;

import java.io.IOException;

/**
 * <p>Struktur von Server</p>
 * <p>Diese Klasse fungiert als Endpunkt, wo die Remote-Benutzerverwaltung liegt. Der Server stellt diese dem
 * ServerOrb zur verfügung.</p>
 */
public class Server {

  /**
   * Startet einen Server, der dem ServerOrb eine Remote-Benutzerverwaltung bereitstellt.
   */
  public Server() {
    BenutzerVerwaltungAdmin bv = new BenutzerVerwaltungAdmin();
    try {
      ServerOrb so = new ServerOrb(bv);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Server server = new Server();
  }

}
