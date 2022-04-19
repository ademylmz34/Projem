package Operations.Concrete;

import Operations.Abstract.Islem;
import Ultilities.Concrete.Araclar;
import Ultilities.Abstract.IEkran;
import Main.Abstract.IEyleyici;
import Main.Abstract.ISicaklikAlgilayici;

public class SogutucuAcma extends Islem {

    public SogutucuAcma(IEkran ekran, IEyleyici eyleyici, ISicaklikAlgilayici sicaklikAlgilayici) {
        super(ekran, eyleyici, sicaklikAlgilayici);
    }

    @Override
    public void islemYap() {
        observerEkle();
        ekran.mesajGoruntule("Sogutucu acma islemini sectiniz.");
        ekran.mesajGoruntule("Sogutucu acma islemi baslatiliyor...");
        Araclar.bekle(2000);
        if(eyleyici.SogutucuKapalimi(sicaklikAlgilayici))
        {
            ekran.mesajGoruntule("Sicaklik düsürülüyor...");
            haberVer("sicaklikdüsür");
            Araclar.bekle(2000);
            ekran.mesajGoruntule("Sogutucu Devrede !!!");
            Araclar.bekle();
        }
        else
        {
            ekran.mesajGoruntule("Sogutucu zaten acik...");
        }
        ekran.mesajGoruntule("Ortalama Sicaklik Degeri: "+ sicaklikAlgilayici.getSicaklikDegeri());

    }
}
