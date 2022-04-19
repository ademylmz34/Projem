package Operations.Abstract;

import Operations.Abstract.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observerList;

    public Observable() {
        observerList = new ArrayList<>();
    }

    public void ekle(Observer observer){
        observerList.add(observer);
    }

    public void cikar(Observer observer){
        observerList.remove(observer);
    }

    public void haberVer(String deger){
        for (Observer observer : observerList) {
            observer.update(deger);
        }
    }
}
