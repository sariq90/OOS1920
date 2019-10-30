public class KreisVererb extends Point {
  /* Überlegungen:
  *  Mit Point als Mittelpunkt des Kreises wird noch der Radius als zusätzliches Attribut benötigt.
  *  entsprechend müssen Methoden wie equals und toString um den Radius erweitert und überlagert, sowie Hilfsmethoden wie
  *  setRadius(); hinzugefügt werden.
  * */
  // Attribute:
  /**
   * Radius des Kreises:
   */
  double radius;

  // Konstruktoren:
  /**
   * Default-Konstruktor:
   */
  KreisVererb() {
  }

  /**
   * Konstruktor mit Koordinaten- und Radiusübergabe:
   * @param x: x-Koordinate des Kreises.
   * @param y: y-Koordinate des Kreises.
   * @param radius: Kreisradius.
   */
  KreisVererb(int x, int y, double radius) {
    super(x,y);
    this.radius = radius;
  }

  /**
   * Konstruktor mit Point-Referenz und Radiusübergabe:
   * @param p: Point-Objekt.
   * @param radius: Kreisradius.
   */
  KreisVererb(Point p, double radius) {
    super(p);
    this.radius = radius;
  }

  // Methoden:
  /**
   * equals vergleicht auf Koordinaten- und Radiusgleichheit:
   * @param k: Kreis-Objekt.
   * @return : Liefert true falls Kreise gleich, sonst false.
   */
  public boolean equals(KreisVererb k) {
    return super.equals(k) && k.radius == this.radius;
  }

  /**
   * Liefert String-Darstellung in Form ((x-Koordinate,y-Koordinate),Radius):
   * @return : ((x,y),r).
   */
  public String toString() {
    return "("+super.toString()+","+this.radius+")";
  }

  /**
   * Getter-Methode für Radius:
   * @return : Liefert double Radius.
   */
  public double getRadius() {
    return this.radius;
  }

  /**
   * Setter-Methode für Radius:
   * @param r : Setzt radius des Kreises auf r.
   */
  public void setRadius(double r) {
    this.radius = r;
  }

  // Tests:
  public static void main(String[] args) {
    KreisVererb k1 = new KreisVererb(4,2,1.1);
    KreisVererb k2 = new KreisVererb(new Point(0,2),1.2);
    KreisVererb k3 = new KreisVererb();
    System.out.println("K1: "+k1+"; K2: "+k2+"; K3: "+k3);
    k2.move(4,0);
    k2.setRadius(1.1);
    System.out.println(k1+" =? "+k2+": "+k1.equals(k2));
    System.out.println(k1+" =? "+k3+": "+k1.equals(k3));
  }
}
