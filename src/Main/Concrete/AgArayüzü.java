package Main.Concrete;

import Main.Abstract.IAgArayüzü;
import Main.Abstract.IEyleyici;
import Main.Abstract.ISicaklikAlgilayici;
import Operations.Abstract.Islem;
import Operations.Concrete.SicaklikGörüntüleme;
import Operations.Concrete.SogutucuAcma;
import Operations.Concrete.SogutucuKapatma;
import Ultilities.Abstract.IEkran;
import Ultilities.Abstract.ITusTakimi;
import Ultilities.Concrete.Araclar;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.TusTakimi;

public class AgArayüzü implements IAgArayüzü {
    private final IEkran ekran;
    private final ITusTakimi tusTakimi;
    private IEyleyici eyleyici;
    private ISicaklikAlgilayici sicaklikAlgilayici;

    private static final int sogutucuAcma = 1;
    private static final int sogutucuKapama = 2;
    private static final int sicaklikGörüntüleme = 3;
    private static final int cikis = 4;

    public AgArayüzü (IEyleyici eyleyici,ISicaklikAlgilayici sicaklikAlgilayici){
        ekran=new Ekran();
        tusTakimi=new TusTakimi();
        this.eyleyici=eyleyici;
        this.sicaklikAlgilayici=sicaklikAlgilayici;
    }

    public void islemSecimi(){
        int secim,menu;
        do{
            secim=anaMenüyüGöster();
            switch (secim){
                case sogutucuAcma:
                    if(eyleyici.SogutucuAc()){
                        Islem sogutucuAcma = new SogutucuAcma(ekran,eyleyici,sicaklikAlgilayici);
                        sogutucuAcma.islemYap();
                        break;
                    }
                case sogutucuKapama:
                    if(eyleyici.SogutucuKapat())
                    {
                        Islem sogutucuKapama= new SogutucuKapatma(ekran,eyleyici,sicaklikAlgilayici);
                        sogutucuKapama.islemYap();
                        break;
                    }
                case sicaklikGörüntüleme:
                    if(sicaklikAlgilayici.SicaklikOkut())
                    {
                        Islem sicaklikGörüntüleme=new SicaklikGörüntüleme(ekran,sicaklikAlgilayici);
                        sicaklikGörüntüleme.islemYap();
                        break;
                    }
                case cikis:
                    ekran.mesajGoruntule("Cikis yapiliyor...");
                    Araclar.bekle();
                    System.exit(0);
                default:
                    ekran.mesajGoruntule("1-4 arasında bir sayi girmelisiniz.");
            }
            ekran.mesajGoruntule("Ana Menüye Dönmek için '5' i tuşlayınız. ");
            menu=tusTakimi.secimVerisiAl();
        }while (menu==5);


        if(menu==5)
            islemSecimi();
    }
    @Override
    public int anaMenüyüGöster() {
        ekran.mesajGoruntule("**********************************************");
        ekran.mesajGoruntule("Ana Menu");
        ekran.mesajGoruntule("1-Sogutucu Ac");
        ekran.mesajGoruntule("2-Sogutucu Kapat");
        ekran.mesajGoruntule("3-Sicaklik Görüntüle");
        ekran.mesajGoruntule("4-Cikis Yap");
        ekran.mesajGoruntule("Seciminiz:");
        ekran.mesajGoruntule("**********************************************");
        return tusTakimi.secimVerisiAl();
    }
}
