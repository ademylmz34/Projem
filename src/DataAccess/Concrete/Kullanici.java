package DataAccess.Concrete;

public class Kullanici {
    private String kullaniciAdi;
    private String sifre;

    public Kullanici(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "kullaniciAdi='" + kullaniciAdi + '\'' +
                '}';
    }
}
