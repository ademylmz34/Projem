package Ultilities.Concrete;

import Ultilities.Abstract.IEkran;

public class Ekran implements IEkran {
    @Override
    public void mesajGoruntule(String mesaj) {
        System.out.println(mesaj);
    }

    @Override
    public void ekranTemizle() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
