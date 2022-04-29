package Main.Abstract;

import Ultilities.Concrete.SicaklikUretici;

public interface IEyleyici {
    void SogutucuAc();
    void SogutucuKapat();
    void observerEkle(SicaklikUretici sicaklikUretici);
}
