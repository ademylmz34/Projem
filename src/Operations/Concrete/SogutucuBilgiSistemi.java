package Operations.Concrete;

import DataAccess.Abstract.IVeritabaniRepository;
import Operations.Abstract.ISogutucuBilgiSistemi;

public class SogutucuBilgiSistemi implements ISogutucuBilgiSistemi {
    private IVeritabaniRepository veritabaniRepository;
    public SogutucuBilgiSistemi(IVeritabaniRepository veritabaniRepository){
        this.veritabaniRepository=veritabaniRepository;
    }

    @Override
    public boolean kullaniciAdiDogrula(String kullaniciAdi) {
        if(veritabaniRepository.kullaniciAdiDogrula(kullaniciAdi)) { return true; }
        return false;
    }

    @Override
    public boolean kullaniciDogrula(String kullaniciAdi, String sifre) {
        if(veritabaniRepository.kullaniciDogrula(kullaniciAdi,sifre)){ return true; }
        return false;

    }
}
