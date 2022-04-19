package DataAccess.Abstract;

public interface IVeritabaniRepository {
    public boolean kullaniciAdiDogrula(String kullaniciAdi);
    public boolean kullaniciDogrula(String kullaniciAdi,String sifre);
}
