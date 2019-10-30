public class KreisAgg {

  // Attribute:

  Point mittelPunkt;
  double radius;

  // Konstruktoren:

  KreisAgg() {
  }

  KreisAgg(KreisAgg k) {
    this.mittelPunkt = k.mittelPunkt;
    this.radius = k.radius;
  }

  KreisAgg(Point p, double r) {
    this.mittelPunkt = p;
    this.radius = r;
  }

  KreisAgg(int x, int y, double r) {
    this.mittelPunkt = new Point(x,y);
    this.radius = r;
  }

  // Methoden:

  public double flächenInhalt() {
    return Math.PI*radius*radius;
  }

  public boolean equals(KreisAgg k) {
    return k.mittelPunkt.equals(this.mittelPunkt) && k.radius == this.radius;
  }

  public KreisAgg clone() {
    return new KreisAgg(this);
  }

  public String toString() {
    return "("+mittelPunkt.toString()+","+this.radius+")";
  }

  public Point getMittelPunkt() {
    return this.mittelPunkt;
  }

  public void setMittelPunkt(Point p) {
    this.mittelPunkt = p;
  }

  public double getRadius() {
    return this.radius;
  }

  public void setRadius(double r) {
    this.radius = r;
  }

}
