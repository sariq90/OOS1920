

public class Main {
  public static void main(String[] args) {

    BenutzerVerwaltungAdmin v = new BenutzerVerwaltungAdmin();

    Benutzer b1 = new Benutzer("Heinz","OOSistSuper".toCharArray());
    Benutzer b2 = new Benutzer("Michi","booleistcool".toCharArray());
    Benutzer b3 = new Benutzer("Georg","matheisttoll".toCharArray());
    Benutzer b4 = new Benutzer();
    Benutzer b5 = new Benutzer();
    Benutzer b6 = null;

    try {
      v.benutzerEintragen(b1);
      v.benutzerEintragen(b2);
      v.benutzerEintragen(b3);
    } catch (BenutzerBereitsInListeException e) {
      e.printStackTrace();
    }

    // TEST1: Einfügen von Duplikaten
    try {
      v.benutzerEintragen(b4);
      v.benutzerEintragen(b5);
    } catch (BenutzerBereitsInListeException e) {
      e.printStackTrace();
    }

    // TEST2: Löschen von nicht vorhandenen Benutzern
    try {
      v.benutzerLöschen(b2);
      v.benutzerLöschen(b2);
    } catch (BenutzerNichtInListeException e) {
      e.printStackTrace();
    }

    // TEST3: Manipulieren von NULL-Benutzern
    try {
      v.benutzerEintragen(b6);
      v.benutzerLöschen(b6);
    } catch (BenutzerBereitsInListeException e) {
      e.printStackTrace();
    } catch (BenutzerNichtInListeException e) {
      e.printStackTrace();
    }

    System.out.println(v);


//    /* P1 d+e) */
//    Figur[] array = new Figur[4];
//    Point p = new Point(0,0);
//    array[0] = new Rechteck(p,2,3);
//    array[1] = new Rechteck(p,2,2);
//    array[2] = new KreisAgg(p,2);
//    array[3] = new KreisAgg(p,1);
//
//    double fläche = 0;
//
//    for (int i = 0; i<array.length;++i) {
//      fläche += array[i].flächenInhalt();
//    }
//    System.out.println("Berechneter Flächeninhalt: "+fläche);
  }
}
