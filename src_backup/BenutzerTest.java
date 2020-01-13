import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>Benutzer-Testklasse</p>
 * <p>Diese Klasse testet die Klasse Benutzer.</p>
 */
class BenutzerTest {

  @BeforeEach
  void setUp() throws Exception {
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  // Konstruktor, Setter, Getter
  @Test
  public void testBenutzer() {
    String testUserId = "TestUserId";
    char[] testPassWort = "TestPassWort".toCharArray();
    Benutzer testBenutzer1 = new Benutzer(testUserId,testPassWort);
    Benutzer testBenutzer2 = new Benutzer();
    assertNotEquals(testBenutzer1,testBenutzer2);
    testUserId = "andereTestUserId";
    testPassWort = "anderesTestPassWort".toCharArray();
    testBenutzer1.setUserId(testUserId);
    testBenutzer1.setPassWort(testPassWort);
    assertNotEquals(testBenutzer1,testBenutzer2);
    assertEquals(testBenutzer2.getUserId(),"default");
    assertArrayEquals(testBenutzer2.getPassWort(),"default".toCharArray());
  }

  // ToString
  @Test
  void testToString() {
    Benutzer testBenutzer = new Benutzer("TestUserId","TestPassWort".toCharArray());
    assertEquals("("+testBenutzer.getUserId()+";"+String.copyValueOf(testBenutzer.getPassWort())+")",testBenutzer.toString());
  }

  // Equals
  @Test
  void testEquals() {
    String testUserId1 = "TestUserId1";
    char[] testPassWort1 = "TestPassWort1".toCharArray();
    String testUserId2 = "TestUserId2";
    char[] testPassWort2 = "TestPassWort2".toCharArray();
    Benutzer testBenutzer1 = new Benutzer(testUserId1,testPassWort1);
    Benutzer testBenutzer2 = new Benutzer(testUserId1,testPassWort1);
    Benutzer testBenutzer3 = new Benutzer(testUserId2,testPassWort2);
    assertEquals(testBenutzer1,testBenutzer2);
    assertNotSame(testBenutzer1,testBenutzer2);
    assertNotEquals(testBenutzer1, testBenutzer3);
    testBenutzer1.setPassWort(testBenutzer3.getPassWort());
    testBenutzer1.setUserId(testBenutzer3.getUserId());
    assertEquals(testBenutzer1,testBenutzer3);
    assertNotSame(testBenutzer1,testBenutzer3);
    assertNotEquals(testBenutzer1,testBenutzer2);
  }
}