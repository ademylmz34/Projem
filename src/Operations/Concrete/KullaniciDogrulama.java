package Operations.Concrete;

import DataAccess.Concrete.PostreSqlSunucu;
import Main.Abstract.IAgArayüzü;
import Operations.Abstract.ISogutucuBilgiSistemi;
import Ultilities.Abstract.IEkran;
import Ultilities.Abstract.ITusTakimi;
import Ultilities.Concrete.Araclar;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.TusTakimi;

import java.io.IOException;

public class KullaniciDogrulama {
    private IEkran ekran;
    private ITusTakimi tusTakimi;
    private ISogutucuBilgiSistemi sogutucuBilgiSistemi;
    private IAgArayüzü agArayüzü;
    private String kullaniciAdi;

    public KullaniciDogrulama(IAgArayüzü agArayüzü){
        ekran = new Ekran();
        tusTakimi =new TusTakimi();
        sogutucuBilgiSistemi=new SogutucuBilgiSistemi(new PostreSqlSunucu());
        this.agArayüzü=agArayüzü;
    }
    public void dogrula() throws IOException {
        ekran.mesajGoruntule("Hoşgeldiniz...");
        ekran.mesajGoruntule("Kullanici Adinizi giriniz: ");
        kullaniciAdi= tusTakimi.kullaniciVerisiAl();

        if(kullaniciAdiDogrula(kullaniciAdi)){
            sifreKontrol();
        }
        else{
            int sayac=1;
            do{
                ekran.mesajGoruntule("Girdiginiz kullanıcı adi hatali..");
                ekran.mesajGoruntule("Tekrar Kullanici Adi Giriniz: ");
                kullaniciAdi=tusTakimi.kullaniciVerisiAl();
                if(kullaniciAdiDogrula(kullaniciAdi)){
                    sifreKontrol();
                }
                ekran.ekranTemizle();
                sayac++;
            }while (sayac<3);
            ekran.mesajGoruntule("3 den fazla hatali kullanici adi girdiniz.Cikis yapiliyor...");
            Araclar.bekle();
            System.exit(0);
        }
    }
    private void sifreKontrol() throws IOException {
        ekran.mesajGoruntule("Sifre giriniz: ");
        String sifre = tusTakimi.kullaniciVerisiAl();

        if(kullaniciDogrula(kullaniciAdi,sifre)){
            ekran.mesajGoruntule("Giriş Başarılı..."+ kullaniciAdi);
            agArayüzü.islemSecimi();
        }
        else{

            int sayac=1;
            do{
                ekran.mesajGoruntule("Girdiginiz Sifre Hatali..");
                ekran.mesajGoruntule("Tekrar Sifre Giriniz: ");
                sifre=tusTakimi.kullaniciVerisiAl();
                if(kullaniciDogrula(kullaniciAdi,sifre)){
                    ekran.mesajGoruntule("Giris Basarılı..."+ kullaniciAdi);
                    ekran.ekranTemizle();
                    agArayüzü.islemSecimi();
                }
                sayac++;
            }while (sayac<3);
            ekran.mesajGoruntule("3 den fazla hatali sifre girdiniz.Cikis yapiliyor...");
            Araclar.bekle();
            System.exit(0);
        }
    }
    private boolean kullaniciAdiDogrula(String kullaniciAdi) {
        ekran.mesajGoruntule("Kullanici Adi Dogrulaniyor...");
        Araclar.bekle(2000);
        if(sogutucuBilgiSistemi.kullaniciAdiDogrula(kullaniciAdi)){return true;}
        return false;
    }

    private boolean kullaniciDogrula(String kullaniciAdi,String sifre){
        ekran.mesajGoruntule("Sifre Dogrulanıyor...");
        Araclar.bekle(2000);
        if(sogutucuBilgiSistemi.kullaniciDogrula(kullaniciAdi,sifre)){return true;}
        return false;
    }
}
