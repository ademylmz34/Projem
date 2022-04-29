package Operations.Concrete;

import Operations.Abstract.Islem;
import Ultilities.Concrete.Araclar;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.SicaklikUretici;

public class SicaklikGörüntüleme implements Islem {
    @Override
    public void islemYap() {
        Ekran.mesajGoruntule("Sicaklik görüntüleme islemini sectiniz.");
        Ekran.mesajGoruntule("Sicaklik görüntüleme islemi baslatiliyor...");
        Araclar.bekle(2000);
        Ekran.mesajGoruntule("Algilayici'dan sicaklik degeri aliniyor...");
        Araclar.bekle(2000);
        Ekran.mesajGoruntule("Ortalama sicaklik degeri: "+ SicaklikUretici.getSicaklikDegeri());
    }
}
