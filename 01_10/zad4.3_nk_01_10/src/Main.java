import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {

        File myFile = new File("C:\\Users\\student\\Desktop\\Dane_2205\\przyklad.txt");

        List<Integer> liczby =  new ArrayList<>();



        try {

            Scanner sc = new Scanner(myFile);
            while (sc.hasNextInt()) {
                liczby.add(sc.nextInt());
            }

            int counter = 0;

                int rozmiar = liczby.size();
                for (int i = 0; i < rozmiar; i++) {
                    int u = liczby.get(i);
                    for (int j = 0; j < rozmiar; j++) {
                        int w = liczby.get(j);
                        if (w % u == 0 && w != u) {
                            for (int k = 0; k < rozmiar; k++) {
                                int x = liczby.get(k);
                                if (x != u && x != w && x % w == 0) {
                                    for (int l = 0; l < rozmiar; l++) {
                                        int y =  liczby.get(l);
                                        if (y != u && y != w && y != x && y % x == 0) {
                                            for (int m = 0; m < rozmiar; m++) {
                                                int z =  liczby.get(m);
                                                if(z != u && z != w && z != x && z != y && z % y == 0) {
                                                    counter++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                System.out.println("\nLiczba dobrych piątek: " + counter);

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
