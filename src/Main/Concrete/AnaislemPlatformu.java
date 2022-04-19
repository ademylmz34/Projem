package Main.Concrete;

import Main.Abstract.IAgArayüzü;
import Main.Abstract.IEyleyici;
import Main.Abstract.ISicaklikAlgilayici;
import Operations.Concrete.KullaniciDogrulama;

import java.io.IOException;

public class AnaislemPlatformu {
    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici sicaklikAlgilayici;
    private final IAgArayüzü agArayüzü;

    public AnaislemPlatformu() {
        eyleyici =new Eyleyici();
        sicaklikAlgilayici=new SicaklikAlgilayici();
        agArayüzü=new AgArayüzü(eyleyici,sicaklikAlgilayici);
    }

    public void basla() throws IOException {
        KullaniciDogrulama dogrulama =new KullaniciDogrulama(agArayüzü);
        dogrulama.dogrula();
    }

}
