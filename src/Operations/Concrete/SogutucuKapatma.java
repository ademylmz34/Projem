package Operations.Concrete;

import Operations.Abstract.Islem;
import Ultilities.Concrete.Araclar;
import Main.Abstract.ISicaklikAlgilayici;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.SicaklikUretici;

public class SogutucuKapatma implements Islem {
    @Override
    public void islemYap() {
            Ekran.mesajGoruntule("Sogutucu kapama islemini sectiniz.");
            Ekran.mesajGoruntule("Sogutucu kapama islemi baslatiliyor...");
            Araclar.bekle(2000);
            Ekran.mesajGoruntule("Sicaklik oda sicakligina yükseltiliyor...");
            Araclar.bekle(2000);
            Ekran.mesajGoruntule("Sogutucu Devrededışı !!!");
            Araclar.bekle();
        }

    }


