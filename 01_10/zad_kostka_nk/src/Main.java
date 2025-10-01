import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int kosci;
        do {
            System.out.println("Ile kostek chcesz rzucić(3-10)");
            kosci = input.nextInt();
        }while(kosci < 3 || kosci > 10);

        int[] liczby = new int[kosci];
        int punkty = 0;
        for(int i = 0; i < kosci; i++){
            int r = rand.nextInt(5)+1;
            System.out.println("Kostka: " + (i+1) + ": " + r);
            liczby[i] = r;
//            for(int j = 0; j < 1; j++){
//                for(int k = 0; k < liczby.length; k++){}
//            }


        }
        System.out.println("Liczba uzyskanych punktów: " + punkty);
    }
    public int[] LiczPunkty(int[] a) {
        int punkty = 0;
        ;
        return punkty;
    }
}