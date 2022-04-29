package Operations.Concrete;

import DataAccess.Concrete.PostreSqlSunucu;
import Operations.Abstract.IKullaniciDogrulama;
import Operations.Abstract.ISogutucuBilgiSistemi;
import Ultilities.Concrete.Araclar;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.TusTakimi;

import java.io.IOException;

public class KullaniciDogrulama implements IKullaniciDogrulama {

    private ISogutucuBilgiSistemi sogutucuBilgiSistemi;
    private String kullaniciAdi;

    public KullaniciDogrulama(ISogutucuBilgiSistemi sogutucuBilgiSistemi){
        this.sogutucuBilgiSistemi=sogutucuBilgiSistemi;
    }
    public boolean dogrula() throws IOException {
        Ekran.mesajGoruntule("Kullanici Adinizi giriniz: ");
        kullaniciAdi= TusTakimi.kullaniciVerisiAl();

        if(kullaniciAdiDogrula(kullaniciAdi)){
            if(sifreKontrol()){
                return true;
            }
        }
        else{
            int sayac=1;
            do{
                Ekran.mesajGoruntule("Girdiginiz kullanıcı adi hatali..");
                Ekran.mesajGoruntule("Tekrar Kullanici Adi Giriniz: ");
                kullaniciAdi=TusTakimi.kullaniciVerisiAl();
                if(kullaniciAdiDogrula(kullaniciAdi)){
                    if(sifreKontrol())
                        return true;
                }

                sayac++;
            }while (sayac<3);
            Ekran.mesajGoruntule("3 den fazla hatali kullanici adi girdiniz.Cikis yapiliyor...");
            Araclar.bekle();
            System.exit(0);
        }
        return false;
    }
    private boolean sifreKontrol() throws IOException {
        Ekran.mesajGoruntule("Sifre giriniz: ");
        String sifre = TusTakimi.kullaniciVerisiAl();

        if(kullaniciDogrula(kullaniciAdi,sifre)){
            Ekran.mesajGoruntule("Giriş Başarılı..."+ kullaniciAdi);
            return true;
        }
        else{

            int sayac=1;
            do{
                Ekran.mesajGoruntule("Girdiginiz Sifre Hatali..");
                Ekran.mesajGoruntule("Tekrar Sifre Giriniz: ");
                sifre=TusTakimi.kullaniciVerisiAl();
                if(kullaniciDogrula(kullaniciAdi,sifre)){
                    Ekran.mesajGoruntule("Giris Basarılı..."+ kullaniciAdi);
                    return true;
                }
                sayac++;
            }while (sayac<3);
            Ekran.mesajGoruntule("3 den fazla hatali sifre girdiniz.Cikis yapiliyor...");
            Araclar.bekle();
            System.exit(0);
        }
        return false;
    }
    private boolean kullaniciAdiDogrula(String kullaniciAdi) {
        Ekran.mesajGoruntule("Kullanici Adi Dogrulaniyor...");
        Araclar.bekle(2000);
        if(sogutucuBilgiSistemi.kullaniciAdiDogrula(kullaniciAdi)){
            Ekran.mesajGoruntule("Kullanici Adi Doğrulama Başarılı...");
            Araclar.bekle();
            return true;
        }
        return false;
    }

    private boolean kullaniciDogrula(String kullaniciAdi,String sifre){
        Ekran.mesajGoruntule("Sifre Dogrulanıyor...");
        Araclar.bekle(2000);
        if(sogutucuBilgiSistemi.kullaniciDogrula(kullaniciAdi,sifre)){
            Ekran.mesajGoruntule("Şifre Doğrulama Başarılı...");
            Araclar.bekle();
            return true;
        }
        return false;
    }
}
