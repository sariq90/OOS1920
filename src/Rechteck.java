public class Rechteck extends Figur {

  // Attribute:
  /**
   * linker oberer Punkt des Rechtecks als Point-Objekt:
   */
  Point linksOben;

  /**
   * Länge der x-Kante:
   */
  double xKante;

  /**
   * Länge der y-Kante:
   */
  double yKante;

  // Konstruktoren:
  /**
   * Default-Konstruktor:
   */
  Rechteck() {
  }

  /**
   * Copy-Konstruktor:
   * @param r: Rechteck.
   */
  Rechteck(Rechteck r) {
    this.linksOben = r.linksOben;
    this.xKante = r.xKante;
    this.yKante = r.yKante;
  }

  /**
   * Konstruktor mit Point-Referenz sowie Übergabe der Kantenlängen:
   * @param p: Point-Referenz.
   * @param xK: Länge der x-Kante.
   * @param yK: Länge der y-Kante.
   */
  Rechteck(Point p, double xK, double yK) {
    this.linksOben = p;
    this.xKante = xK;
    this.yKante = yK;
  }

  /**
   * Konstruktor mit Übergabe elementarer Koordinaten und Längen:
   * @param x: x-Koordinate der oberen linken Ecke.
   * @param y: y-Koordinate der oberen linken Ecke.
   * @param xK: Länge der x-Kante.
   * @param yK: Länge der y-Kante.
   */
  Rechteck(int x, int y, double xK, double yK) {
    this.linksOben = new Point(x,y);
    this.xKante = xK;
    this.yKante = yK;
  }

  // Methoden:
  /**
   * Flächenberechnung eines Rechtecks:
   * @return : Liefert x-Kante * y-Kante.
   */
  public double flächenInhalt() {
    return xKante*yKante;
  }

  /**
   * Überprüfung auf Gleichheit:
   * @param r: Referenz auf zu vergleichendes Rechteck.
   * @return : Liefert true wenn identisch, false sonst.
   */
  public boolean equals(Rechteck r) {
    return r.xKante == this.xKante && r.yKante == this.yKante && r.linksOben == this.linksOben;
  }

  /**
   * Erzeugt neues, identisches Rechteck.
   */
  public Rechteck clone() {
    return new Rechteck(this);
  }

  /**
   * toString mit Format ((x,y),[x-Kante,y-Kante]):
   */
  public String toString() {
    return "("+linksOben+",["+xKante+","+yKante+"])";
  }

  /**
   * getter für obere linke Ecke:
   */
  public Point getLinksOben() {
    return linksOben;
  }

  /**
   * setter für obere linke Ecke:
   */
  public void setLinksOben(Point p) {
    linksOben = p;
  }

  /**
   * getter für x-Kante:
   */
  public double getxKante() {
    return xKante;
  }

  /**
   * setter für x-Kante:
   */
  public void setxKante(double x) {
    xKante = x;
  }

  /**
   * getter für y-Kante:
   */
  public double getyKante() {
    return yKante;
  }

  /**
   * setter für y-Kante:
   */
  public void setyKante(double y) {
    yKante = y;
  }

}
