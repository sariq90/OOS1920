public class Rechteck {

  // Attribute:

  Point linksOben;
  double xKante;
  double yKante;

  // Konstruktoren:

  Rechteck() {
  }

  Rechteck(Rechteck r) {
    this.linksOben = r.linksOben;
    this.xKante = r.xKante;
    this.yKante = r.yKante;
  }

  Rechteck(Point p, double xK, double yK) {
    this.linksOben = p;
    this.xKante = xK;
    this.yKante = yK;
  }

  Rechteck(int x, int y, double xK, double yK) {
    this.linksOben = new Point(x,y);
    this.xKante = xK;
    this.yKante = yK;
  }

  // Methoden:

  public double flächenInhalt() {
    return xKante*yKante;
  }

  public boolean equals(Rechteck r) {
    return r.xKante == this.xKante && r.yKante == this.yKante && r.linksOben == this.linksOben;
  }

  public Rechteck clone() {
    return new Rechteck(this);
  }

  public String toString() {
    return "("+linksOben+",["+xKante+","+yKante+"])";
  }

  public Point getLinksOben() {
    return linksOben;
  }

  public void setLinksOben(Point p) {
    linksOben = p;
  }

  public double getxKante() {
    return xKante;
  }

  public void setxKante(double x) {
    xKante = x;
  }

  public double getyKante() {
    return yKante;
  }

  public void setyKante(double y) {
    yKante = y;
  }

}
