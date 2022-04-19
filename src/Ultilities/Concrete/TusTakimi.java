package Ultilities.Concrete;

import Ultilities.Abstract.ITusTakimi;

import java.util.Scanner;

public class TusTakimi implements ITusTakimi {
    @Override
    public int secimVerisiAl() {
        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }

    @Override
    public String kullaniciVerisiAl() {
        Scanner input=new Scanner(System.in);
        return input.nextLine();
    }

}
