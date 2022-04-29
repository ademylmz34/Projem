package Operations.Concrete;

import Operations.Abstract.Islem;
import Ultilities.Concrete.Araclar;
import Main.Abstract.ISicaklikAlgilayici;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.SicaklikUretici;

public class SogutucuAcma implements Islem {
    @Override
    public void islemYap() {
            Ekran.mesajGoruntule("Sogutucu acma islemini sectiniz.");
            Ekran.mesajGoruntule("Sogutucu acma islemi baslatiliyor...");
            Araclar.bekle(2000);
            Ekran.mesajGoruntule("Sicaklik düsürülüyor...");
            Araclar.bekle(2000);
            Ekran.mesajGoruntule("Sogutucu Devrede !!!");
            Araclar.bekle();
        }


    }



