import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {

        File myFile = new File("C:\\Users\\student\\Desktop\\Dane_2205\\liczby.txt");
        String outputFile = "C:\\Users\\student\\Desktop\\trojki.txt";

        List<Integer> liczby =  new ArrayList<>();



        try {

            Scanner sc = new Scanner(myFile);
            while (sc.hasNextInt()) {
                liczby.add(sc.nextInt());
            }

            int counter = 0;
            try(PrintWriter pw = new PrintWriter(new File(outputFile))) {
                int rozmiar = liczby.size();
                for (int i = 0; i < rozmiar; i++) {
                    int x = liczby.get(i);
                    for (int j = 0; j < rozmiar; j++) {
                        int y = liczby.get(j);
                        if (y % x == 0 && y != x) {
                            for (int k = 0; k < rozmiar; k++) {
                                int z = liczby.get(k);
                                if (z != x && z != y && z % y == 0) {
                                    pw.println(x + " " + y + " " + z);
                                    counter++;
                                }
                            }
                        }
                    }
                }

                pw.println("\nLiczba dobrych trójek: " + counter);
            }

            System.out.println(counter);


            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
