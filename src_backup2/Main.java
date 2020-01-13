import benutzer.BenutzerVerwaltungAdmin;

public class Main {
  public static void main(String[] args) {

    BenutzerVerwaltungAdmin v = new BenutzerVerwaltungAdmin();
    v.dbInitialisieren();



//
//    benutzer.BenutzerVerwaltungAdmin v = new benutzer.BenutzerVerwaltungAdmin();
//
//    prak4gemklassen.Benutzer b1 = new prak4gemklassen.Benutzer("Heinz","OOSistSuper".toCharArray());
//    prak4gemklassen.Benutzer b2 = new prak4gemklassen.Benutzer("Michi","booleistcool".toCharArray());
//    prak4gemklassen.Benutzer b3 = new prak4gemklassen.Benutzer("Georg","matheisttoll".toCharArray());
//    prak4gemklassen.Benutzer b4 = new prak4gemklassen.Benutzer();
//    prak4gemklassen.Benutzer b5 = new prak4gemklassen.Benutzer();
//    prak4gemklassen.Benutzer b6 = null;
//
//    try {
//      v.benutzerEintragen(b1);
//      v.benutzerEintragen(b2);
//      v.benutzerEintragen(b3);
//    } catch (prak4gemklassen.BenutzerBereitsInListeException e) {
//      e.printStackTrace();
//    }
//
//    // TEST1: Einfügen von Duplikaten
//    try {
//      v.benutzerEintragen(b4);
//      v.benutzerEintragen(b5);
//    } catch (prak4gemklassen.BenutzerBereitsInListeException e) {
//      e.printStackTrace();
//    }
//
//    // TEST2: Löschen von nicht vorhandenen Benutzern
//    try {
//      v.benutzerLöschen(b2);
//      v.benutzerLöschen(b2);
//    } catch (benutzer.BenutzerNichtInListeException e) {
//      e.printStackTrace();
//    }
//
//    // TEST3: Manipulieren von NULL-Benutzern
//    try {
//      v.benutzerEintragen(b6);
//      v.benutzerLöschen(b6);
//    } catch (prak4gemklassen.BenutzerBereitsInListeException e) {
//      e.printStackTrace();
//    } catch (benutzer.BenutzerNichtInListeException e) {
//      e.printStackTrace();
//    }
//
//    System.out.println(v);
//

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
