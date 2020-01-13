public class KreisAgg extends Figur {

  // Attribute:
  /**
   * Kreismittelpunkt als Point:
   */
  Point mittelPunkt;

  /**
   * Radius des Kreises:
   */
  double radius;

  // Konstruktoren:

  /**
   * Default-Konstruktor:
   */
  KreisAgg() {
  }

  /**
   * Copy-Konstruktor:
   * @param k: KreisAgg-Objekt.
   */
  KreisAgg(KreisAgg k) {
    this.mittelPunkt = k.mittelPunkt;
    this.radius = k.radius;
  }

  /**
   * Konstruktor mit Point als Referenz und double-Übergabe:
   * @param p: Point-Objekt.
   * @param r: double Radius.
   */
  KreisAgg(Point p, double r) {
    this.mittelPunkt = p;
    this.radius = r;
  }

  /**
   * Konstruktor mit Übergabe von Radius, x-, y-Koordinaten:
   * @param x: int x-Koordinate.
   * @param y: int y-Koordinate.
   * @param r: double Radius.
   */
  KreisAgg(int x, int y, double r) {
    this.mittelPunkt = new Point(x,y);
    this.radius = r;
  }

  // Methoden:

  /**
   * Berechnung des Flächeninhalts eines Kreises:
   * @return : double Fläche.
   */
  public double flächenInhalt() {
    return Math.PI*radius*radius;
  }

  /**
   * Vergleich auf Gleichheit von Koordinaten und Mittelpunkt:
   * @param k: Vergleiche diesen KreisAgg mit KreisAgg k.
   * @return : Liefert true wenn identisch, sonst false.
   */
  public boolean equals(KreisAgg k) {
    return k.mittelPunkt.equals(this.mittelPunkt) && k.radius == this.radius;
  }

  /**
   * Gibt ein neues, identisches Objekt zurück:
   * @return liefert neues KreisAgg-Objekt mit identischen Eigenschaften.
   */
  public KreisAgg clone() {
    return new KreisAgg(this);
  }

  /**
   * toString-Methode im Format ((x,y),r):
   */
  public String toString() {
    return "("+mittelPunkt.toString()+","+this.radius+")";
  }

  /**
   * getter für Mittelpunkt:
   */
  public Point getMittelPunkt() {
    return this.mittelPunkt;
  }

  /**
   * setter für Mittelpunkt:
   * @param p: Point-Objekt.
   */
  public void setMittelPunkt(Point p) {
    this.mittelPunkt = p;
  }

  /**
   * getter für Radius:
   */
  public double getRadius() {
    return this.radius;
  }

  /**
   * setter für Radius:
   * @param r: double Radius.
   */
  public void setRadius(double r) {
    this.radius = r;
  }

}
