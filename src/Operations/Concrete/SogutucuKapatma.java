package Operations.Concrete;

import Operations.Abstract.Islem;
import Ultilities.Concrete.Araclar;
import Ultilities.Abstract.IEkran;
import Main.Abstract.IEyleyici;
import Main.Abstract.ISicaklikAlgilayici;

public class SogutucuKapatma extends Islem {
    public SogutucuKapatma(IEkran ekran, IEyleyici eyleyici, ISicaklikAlgilayici sicaklikAlgilayici) {
        super(ekran, eyleyici, sicaklikAlgilayici);
    }

    @Override
    public void islemYap() {
        observerEkle();
        ekran.mesajGoruntule("Sogutucu kapama islemini sectiniz.");
        ekran.mesajGoruntule("Sogutucu kapama islemi baslatiliyor...");
        Araclar.bekle(2000);
        if(eyleyici.SogutucuAcikmi(sicaklikAlgilayici))
        {
            ekran.mesajGoruntule("Sicaklik oda sicakligina yükseltiliyor...");
            haberVer("odasicakligi");
            Araclar.bekle(2000);
            ekran.mesajGoruntule("Sogutucu Devrededışı !!!");
            Araclar.bekle();
        }
        else
        {
            ekran.mesajGoruntule("Sogutucu zaten kapali...");
        }
        ekran.mesajGoruntule("Ortalama Sicaklik Degeri: "+ sicaklikAlgilayici.getSicaklikDegeri());
    }
}
