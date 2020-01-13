package benutzer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>benutzer.BenutzerVerwaltungAdmin-Testklasse</p>
 * <p>Diese Klasse testet die Klasse benutzer.BenutzerVerwaltungAdmin</p>
 */
class BenutzerVerwaltungAdminTest {
  Benutzer benutzer1;
  Benutzer benutzer2;
  BenutzerVerwaltungAdmin verwaltung;

  @BeforeEach
  void setUp() {
    benutzer1 = new Benutzer("user1","pw1".toCharArray());
    benutzer2 = new Benutzer("user2","pw2".toCharArray());
    verwaltung = new BenutzerVerwaltungAdmin();
    verwaltung.dbInitialisieren();
  }

  @AfterEach
  void tearDown() {
  }

  // Eintragen
  @Test
  void benutzerEintragen() {
    assertFalse(verwaltung.benutzerOk(benutzer1));
    try {
      verwaltung.benutzerEintragen(benutzer1);
    } catch (BenutzerBereitsInListeException e) {
      fail("benutzer.Benutzer noch nicht in Liste.");
    }
    assertTrue(verwaltung.benutzerOk(benutzer1));
    try {
      verwaltung.benutzerEintragen(benutzer1);
      fail("benutzer.Benutzer doppelt eingetragen.");
    } catch (BenutzerBereitsInListeException e) {
    }
  }

  // BenutzerOk
  @Test
  void benutzerOk() {
    assertFalse(verwaltung.benutzerOk(benutzer1));
    try {
      verwaltung.benutzerEintragen(benutzer1);
    } catch (BenutzerBereitsInListeException e) {
    }
    assertTrue(verwaltung.benutzerOk(benutzer1));
  }

  // Löschen
  @Test
  void benutzerLöschen() {
    try {
      verwaltung.benutzerLöschen(benutzer1);
      fail("Leere Liste.");
    } catch (BenutzerNichtInListeException e) {
    }
    try {
      verwaltung.benutzerEintragen(benutzer1);
      verwaltung.benutzerEintragen(benutzer2);
    } catch (BenutzerBereitsInListeException e) {
      fail("Keine Duplikate.");
    }
    try {
      verwaltung.benutzerLöschen(benutzer2);
    } catch (BenutzerNichtInListeException e) {
      fail("benutzer.Benutzer ist in Liste.");
    }
    try {
      verwaltung.benutzerLöschen(benutzer2);
      fail("benutzer.Benutzer nicht in Liste.");
    } catch (BenutzerNichtInListeException e) {
    }
  }

  // Init-Test
  @Test
  void benutzerEintragenInit() {
    assertFalse(verwaltung.benutzerOk(benutzer1));
    try {
      verwaltung.benutzerEintragen(benutzer1);
    } catch (BenutzerBereitsInListeException e) {
      fail("benutzer.Benutzer noch nicht in Liste.");
    }
    assertTrue(verwaltung.benutzerOk(benutzer1));
    verwaltung.dbInitialisieren();
    assertFalse(verwaltung.benutzerOk(benutzer1));
    try {
      verwaltung.benutzerEintragen(benutzer1);
    } catch (BenutzerBereitsInListeException e) {
      fail("benutzer.Benutzer noch nicht in Liste.");
    }
  }

  // Init-Test
  @Test
  void benutzerLöschenInit() {
    assertFalse(verwaltung.benutzerOk(benutzer1));
    try {
      verwaltung.benutzerEintragen(benutzer1);
    } catch (BenutzerBereitsInListeException e) {
      fail("benutzer.Benutzer noch nicht in Liste.");
    }
    verwaltung.dbInitialisieren();
    assertThrows(BenutzerNichtInListeException.class, ()->verwaltung.benutzerLöschen(benutzer1));
    try {
      verwaltung.benutzerLöschen(benutzer1);
      fail("benutzer.Benutzer nicht in Liste, da initialisiert.");
    } catch (BenutzerNichtInListeException e) {
    }
  }
}