package Ultilities.Concrete;

import Operations.Abstract.Observer;

import java.util.Random;

public class SicaklikUretici implements Observer {

    Random rnd = new Random();
    private static int sicaklikDegeri;

    public SicaklikUretici(){
        setSicaklikDegeri(sicaklikUret(10,25));
    }
    public static int getSicaklikDegeri() {
        return sicaklikDegeri;
    }
    private void setSicaklikDegeri(int sicaklikDegeri) {
        this.sicaklikDegeri = sicaklikDegeri;
    }

    private void odaSicakliginaAyarla(){
        setSicaklikDegeri(sicaklikUret(10,35));
    }

    private void sicaklikDusur(){
        setSicaklikDegeri(sicaklikUret(-10,0));
    }

    private int sicaklikUret(int maxvalue) {
        return rnd.nextInt(maxvalue);
    }
    private int sicaklikUret(int minvalue,int maxvalue)
    {
        return rnd.nextInt(minvalue,maxvalue);
    }

    @Override
    public void update(String deger) {
        if (deger.equalsIgnoreCase("sicaklikdüsür"))
            sicaklikDusur();
        else if (deger.equalsIgnoreCase("odasicakligi"))
            odaSicakliginaAyarla();
    }
}
