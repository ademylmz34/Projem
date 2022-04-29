package Main.Concrete;

import Main.Abstract.IEyleyici;
import Main.Abstract.ISicaklikAlgilayici;
import Operations.Abstract.Islem;
import Operations.Abstract.Observable;
import Operations.Concrete.SogutucuAcma;
import Operations.Concrete.SogutucuKapatma;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.SicaklikUretici;

public class Eyleyici extends Observable implements IEyleyici {

    private Islem sogutucuAcma;
    private Islem sogutucuKapatma;
    public Eyleyici(Islem sogutucuAcma, Islem sogutucuKapatma){
        this.sogutucuAcma=sogutucuAcma;
        this.sogutucuKapatma=sogutucuKapatma;
    }

    @Override
    public void SogutucuAc() {
        if(SogutucuKapalimi()){
            sogutucuAcma.islemYap();
            haberVer("sicaklikdüsür");
        }
        else{
            Ekran.mesajGoruntule("Soğutucu zaten açık..");
        }
        Ekran.mesajGoruntule("Ortalama sicaklik degeri: "+SicaklikUretici.getSicaklikDegeri());
    }

    @Override
    public void SogutucuKapat() {
        if(SogutucuAcikmi()){
            sogutucuKapatma.islemYap();
            haberVer("odasicakligi");
        }
        else{
            Ekran.mesajGoruntule("Soğtucu zaten kapalı..");
        }
        Ekran.mesajGoruntule("Ortalama sicaklik degeri: "+SicaklikUretici.getSicaklikDegeri());
    }

    public void observerEkle(SicaklikUretici sicaklikUretici){
        ekle(sicaklikUretici);
    }

    private boolean SogutucuAcikmi(){
        if (SicaklikUretici.getSicaklikDegeri()<0)
            return true;
        return false;
    }

    private boolean SogutucuKapalimi() {
        if(SicaklikUretici.getSicaklikDegeri()>0)
            return true;
        return false;
    }

}
