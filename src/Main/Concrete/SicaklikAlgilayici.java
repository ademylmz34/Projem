package Main.Concrete;

import Main.Abstract.ISicaklikAlgilayici;
import Operations.Abstract.Observer;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici,Observer {
    Random rnd = new Random();
    private int sicaklikDegeri;

    public SicaklikAlgilayici(){
        setSicaklikDegeri(rnd.nextInt(10,25));
    }
    public int getSicaklikDegeri() {
        return sicaklikDegeri;
    }

    private void setSicaklikDegeri(int sicaklikDegeri) {
        this.sicaklikDegeri = sicaklikDegeri;
    }

    private void odaSicakliginaAyarla(){
        setSicaklikDegeri(rnd.nextInt(10,35));
    }

    private void sicaklikDusur(){
        setSicaklikDegeri(rnd.nextInt(-10,0));
    }

    @Override
    public boolean SicaklikOkut() {
        return true;
    }

    @Override
    public void update(String ifade) {
        if (ifade.equalsIgnoreCase("sicaklikdüsür"))
            sicaklikDusur();
        else if (ifade.equalsIgnoreCase("odasicakligi"))
            odaSicakliginaAyarla();
    }
}
