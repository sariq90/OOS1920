public class Point {
  // Attribute:
  /**
   * x-Koordinate des Punktes:
   */
  int x;
  /**
   * y-Koordinate des Punktes:
   */
  int y;

  // Konstruktoren:
  /**
   * Default-Konstruktor:
   */
  Point() {
  }
  /**
   * Copy-Konstruktor via Point-Referenz:
   */
  Point(Point p) {
    this.x = p.x;
    this.y = p.y;
  }
  /**
   * Konstruktor via Koordinaten:
   */
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // Methoden:
  /**
   * Liefert neues Objekt mit gleichen Koordinaten wie dieses:
   */
  Point getLocation() {
    return new Point(this);
  }
  /**
   * Setzt die Koordinaten dieses Objekts auf die eines Referenzobjekts:
   */
  void setLocation(Point p) {
    this.x = p.x;
    this.y = p.y;
  }
  /**
   * Setzt die Koordinaten dieses Objekts auf übergebene Koordinaten:
   */
  void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Verschiebt Koordinaten dieses Objekts um übergebene Werte:
   * @param dx: Verschiebung in x-Richtung.
   * @param dy: Verschiebung un y-Richtung.
   */
  void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }
  /**
   * Vergleicht zwei Objekte auf Gleichheit (ihrer Koordinaten):
   */
  public boolean equals(Point p) {
    return (this.x == p.x && this.y == p.y);
  }

  /**
   * Stellt den Punkt dar als (x,y):
   */
  public String toString() {
    return "("+this.x+","+this.y+")";
  }
}
