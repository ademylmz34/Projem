package Main;

import Factory.AgArayüzFactory;
import Factory.EyleyiciFactory;
import Factory.KullaniciDogrulamaFactory;
import Factory.SicaklikAlgilayiciFactory;
import Main.Concrete.AnaislemPlatformu;

import java.io.IOException;

public class SogutucuUygulamasi {
    public static void main(String[] args) throws IOException {
        AnaislemPlatformu anaislemPlatformu =new AnaislemPlatformu(new SicaklikAlgilayiciFactory(),new EyleyiciFactory(),
                new AgArayüzFactory(),new KullaniciDogrulamaFactory());
        anaislemPlatformu.basla();
    }
}
