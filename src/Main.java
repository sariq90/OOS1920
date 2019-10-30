public class Main {
  public static void main(String[] args) {

    // P1 d+e)
    Figur[] array = new Figur[4];
    Point p = new Point(0,0);
    array[0] = new Rechteck(p,2,3);
    array[1] = new Rechteck(p,2,2);
    array[2] = new KreisAgg(p,2);
    array[3] = new KreisAgg(p,1);

    double fläche = 0;

    for (int i = 0; i<array.length;++i) {
      fläche += array[i].flächenInhalt();
    }
    System.out.println("Berechneter Flächeninhalt: "+fläche);
  }
}
