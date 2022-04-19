package Main.Abstract;

public interface IEyleyici {
    boolean SogutucuAc();
    boolean SogutucuKapat();
    boolean SogutucuAcikmi(ISicaklikAlgilayici sicaklikAlgilayici);
    boolean SogutucuKapalimi(ISicaklikAlgilayici sicaklikAlgilayici);
}
