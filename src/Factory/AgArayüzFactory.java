package Factory;

import Main.Abstract.IAgArayüzü;
import Main.Concrete.AgArayüzü;

public class AgArayüzFactory {

    public IAgArayüzü factoryMethod() {
        return new AgArayüzü();
    }
}
