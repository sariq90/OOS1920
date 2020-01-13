public class PascalsD {

  public static void main(String[] args) {

    // Konstante für Tiefe des Dreiecks:
    final int tiefe = 10;
    // Init Zeilenanzahl in Abhängigkeit der Tiefe:
    int[][] pascal = new int[tiefe][];
    // Init Einträge in Zeilen:
    for (int i = 0; i<tiefe; ++i) {
      pascal[i] = new int[i+1];
    }
    // Berechnung des Dreiecks:
    for (int i = 0; i<tiefe; ++i) {
      for (int j = 0; j<i+1; ++j) {
        if (j == 0 || j == i) {
          pascal[i][j] = 1;
        } else {
          pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
        }
      }
    }
    // Ausgabe Dreieck:
    for (int i = 0; i<tiefe; ++i) {
      for (int j = 0; j<i+1; ++j) {
        if (j != 0) {
          System.out.print(" ");
        }
        System.out.print(pascal[i][j]);
      }
      System.out.println();
    }
//    for (int[] pascalZ: pascal) {
//      for (int wert: pascalZ) {
//        System.out.print(wert+" ");
//      }
//      System.out.println();
//    }
  }
}
