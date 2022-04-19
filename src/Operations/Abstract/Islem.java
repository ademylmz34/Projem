package Operations.Abstract;

import Main.Abstract.IEyleyici;
import Main.Abstract.ISicaklikAlgilayici;
import Ultilities.Abstract.IEkran;

public abstract class Islem extends Observable {
    protected final IEkran ekran;
    protected final IEyleyici eyleyici;
    protected final ISicaklikAlgilayici sicaklikAlgilayici;

    protected Islem(IEkran ekran, IEyleyici eyleyici, ISicaklikAlgilayici sicaklikAlgilayici) {
        this.ekran = ekran;
        this.eyleyici = eyleyici;
        this.sicaklikAlgilayici = sicaklikAlgilayici;
    }
    public void observerEkle(){ ekle((Observer) sicaklikAlgilayici); };
    public abstract void islemYap();

}
