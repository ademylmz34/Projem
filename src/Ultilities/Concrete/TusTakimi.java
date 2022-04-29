package Ultilities.Concrete;

import java.util.Scanner;

public class TusTakimi {

    public static int secimVerisiAl() {
        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }


    public static String kullaniciVerisiAl() {
        Scanner input=new Scanner(System.in);
        return input.nextLine();
    }

}
