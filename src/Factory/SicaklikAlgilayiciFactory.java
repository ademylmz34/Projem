package Factory;

import Main.Abstract.ISicaklikAlgilayici;
import Main.Concrete.SicaklikAlgilayici;
import Operations.Abstract.Islem;
import Operations.Concrete.SicaklikGörüntüleme;

public class SicaklikAlgilayiciFactory {

    public ISicaklikAlgilayici factoryMethod() {
        Islem islem = new SicaklikGörüntüleme();
        ISicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici(islem);
        return sicaklikAlgilayici;
    }
}
