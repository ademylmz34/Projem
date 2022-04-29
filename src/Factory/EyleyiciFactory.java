package Factory;

import Main.Abstract.IEyleyici;
import Main.Concrete.Eyleyici;
import Operations.Abstract.Islem;
import Operations.Abstract.Observable;
import Operations.Concrete.SogutucuAcma;
import Operations.Concrete.SogutucuKapatma;
import Ultilities.Concrete.SicaklikUretici;

public class EyleyiciFactory {

    public IEyleyici factoryMethod() {
        SicaklikUretici sicaklikUretici = new SicaklikUretici();
        Islem sogutucuAcma = new SogutucuAcma();
        Islem sogutucuKapatma=new SogutucuKapatma();
        IEyleyici eyleyici=new Eyleyici(sogutucuAcma,sogutucuKapatma);
        eyleyici.observerEkle(sicaklikUretici);
        return eyleyici;
    }
}
