package Main.Concrete;

import Main.Abstract.ISicaklikAlgilayici;
import Operations.Abstract.Islem;
import Operations.Abstract.Observer;
import Operations.Concrete.SicaklikGörüntüleme;
import Ultilities.Concrete.Ekran;
import Ultilities.Concrete.SicaklikUretici;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private Islem sicaklikGörüntüleme;

    public SicaklikAlgilayici(Islem sicaklikGörüntüleme){
        this.sicaklikGörüntüleme=sicaklikGörüntüleme;
    }

    public void SicaklikOkut() {
        sicaklikGörüntüleme.islemYap();
    }
}
