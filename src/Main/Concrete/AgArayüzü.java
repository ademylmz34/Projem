package Main.Concrete;

import Main.Abstract.IAgArayüzü;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.TusTakimi;

public class AgArayüzü implements IAgArayüzü {

    public AgArayüzü (){

    }
    @Override
    public int anaMenüyüGöster() {
        Ekran.mesajGoruntule("**********************************************");
        Ekran.mesajGoruntule("Ana Menu");
        Ekran.mesajGoruntule("1-Sogutucu Ac");
        Ekran.mesajGoruntule("2-Sogutucu Kapat");
        Ekran.mesajGoruntule("3-Sicaklik Görüntüle");
        Ekran.mesajGoruntule("4-Cikis Yap");
        Ekran.mesajGoruntule("Seciminiz:");
        Ekran.mesajGoruntule("**********************************************");
        return TusTakimi.secimVerisiAl();
    }
}
