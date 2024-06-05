package at.ac.fhcampuswien.fhmdb.observer;

public interface Observable {
    void addSubscriber(Observer observer);
    void notifyControllers(String message);
}
