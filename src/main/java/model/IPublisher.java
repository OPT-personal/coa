package model;

public interface IPublisher {
    void registerObserver(IObserver o);
    void removeObserver(IObserver o);
    void notifyObservers(AZC bestemming,AZC herkomst,Asielzoeker asielzoeker);
}
