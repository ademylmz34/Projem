package Operations.Concrete;

import Operations.Abstract.Islem;
import Ultilities.Concrete.Araclar;
import Ultilities.Abstract.IEkran;
import Main.Abstract.ISicaklikAlgilayici;

public class SicaklikGörüntüleme extends Islem {
    public SicaklikGörüntüleme(IEkran ekran, ISicaklikAlgilayici sicaklikAlgilayici) {
        super(ekran, null, sicaklikAlgilayici);
    }

    @Override
    public void islemYap() {
        ekran.mesajGoruntule("Sicaklik görüntüleme islemini sectiniz.");
        ekran.mesajGoruntule("Sicaklik görüntüleme islemi baslatiliyor...");
        Araclar.bekle(2000);

        ekran.mesajGoruntule("Algilayici'dan sicaklik degeri aliniyor...");
        Araclar.bekle(2000);
        ekran.mesajGoruntule("Ortalama Sicaklik Degeri: "+ sicaklikAlgilayici.getSicaklikDegeri());
    }
}
