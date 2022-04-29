package Main.Concrete;

import Factory.AgArayüzFactory;
import Factory.EyleyiciFactory;
import Factory.KullaniciDogrulamaFactory;
import Factory.SicaklikAlgilayiciFactory;
import Main.Abstract.IAgArayüzü;
import Main.Abstract.IEyleyici;
import Main.Abstract.ISicaklikAlgilayici;
import Operations.Abstract.IKullaniciDogrulama;
import Operations.Concrete.*;
import Ultilities.Concrete.Araclar;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.TusTakimi;

import java.io.IOException;

public class AnaislemPlatformu {
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IEyleyici eyleyici;
    private IAgArayüzü agArayüzü;
    private IKullaniciDogrulama kullaniciDogrulama;

    private SicaklikAlgilayiciFactory sicaklikAlgilayiciFactory;
    private EyleyiciFactory eyleyiciFactory;
    private AgArayüzFactory agArayüzFactory;
    private KullaniciDogrulamaFactory kullaniciDogrulamaFactory;

    private static final int sogutucuAcma = 1;
    private static final int sogutucuKapama = 2;
    private static final int sicaklikGörüntüleme = 3;
    private static final int cikis = 4;

    public AnaislemPlatformu(SicaklikAlgilayiciFactory sicaklikAlgilayiciFactory, EyleyiciFactory eyleyiciFactory,
                             AgArayüzFactory agArayüzFactory, KullaniciDogrulamaFactory kullaniciDogrulamaFactory) {

        this.sicaklikAlgilayiciFactory=sicaklikAlgilayiciFactory;
        this.eyleyiciFactory=eyleyiciFactory;
        this.agArayüzFactory=agArayüzFactory;
        this.kullaniciDogrulamaFactory=kullaniciDogrulamaFactory;
    }

    public void basla() throws IOException {
        sicaklikAlgilayici = sicaklikAlgilayiciFactory.factoryMethod();
        eyleyici = eyleyiciFactory.factoryMethod();
        agArayüzü = agArayüzFactory.factoryMethod();
        kullaniciDogrulama = kullaniciDogrulamaFactory.factoryMethod();

        Ekran.mesajGoruntule("Hoşgeldiniz...");
        Araclar.bekle();
        if(kullaniciDogrulama.dogrula()){
            int secim,menu;
            do{
                secim=agArayüzü.anaMenüyüGöster();
                switch (secim){
                    case sogutucuAcma:
                        eyleyici.SogutucuAc();
                        break;
                    case sogutucuKapama:
                        eyleyici.SogutucuKapat();
                        break;
                    case sicaklikGörüntüleme:
                        sicaklikAlgilayici.SicaklikOkut();
                        break;
                    case cikis:
                        Ekran.mesajGoruntule("Cikis yapiliyor...");
                        Araclar.bekle();
                        System.exit(0);
                    default:
                        Ekran.mesajGoruntule("1-4 arasında bir sayi girmelisiniz.");
                }
                Ekran.mesajGoruntule("Ana Menüye Dönmek için '5' i tuşlayınız. ");
                menu=TusTakimi.secimVerisiAl();
            }while (menu==5);

            if(menu==5)
                agArayüzü.anaMenüyüGöster();
        }
    }

}
