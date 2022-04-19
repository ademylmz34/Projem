package Main.Concrete;

import Main.Abstract.IEyleyici;
import Main.Abstract.ISicaklikAlgilayici;

public class Eyleyici implements IEyleyici {

    @Override
    public boolean SogutucuAc() {
        return true;
    }

    @Override
    public boolean SogutucuKapat() {
        return true;
    }

    @Override
    public boolean SogutucuAcikmi(ISicaklikAlgilayici sicaklikAlgilayici){
        if (sicaklikAlgilayici.getSicaklikDegeri()<0)
            return true;
        return false;
    }

    @Override
    public boolean SogutucuKapalimi(ISicaklikAlgilayici sicaklikAlgilayici) {
        if(sicaklikAlgilayici.getSicaklikDegeri()>0)
            return true;
        return false;
    }
}
