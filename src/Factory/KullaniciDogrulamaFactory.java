package Factory;

import DataAccess.Concrete.PostreSqlSunucu;
import Operations.Abstract.IKullaniciDogrulama;
import Operations.Concrete.KullaniciDogrulama;
import Operations.Concrete.SogutucuBilgiSistemi;

public class KullaniciDogrulamaFactory {

    public IKullaniciDogrulama factoryMethod() {
        SogutucuBilgiSistemi sogutucuBilgiSistemi=new SogutucuBilgiSistemi(new PostreSqlSunucu());
        IKullaniciDogrulama kullaniciDogrulama = new KullaniciDogrulama(sogutucuBilgiSistemi);
        return kullaniciDogrulama;
    }
}
