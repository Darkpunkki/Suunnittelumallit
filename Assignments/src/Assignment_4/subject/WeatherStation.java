package Assignment_4.subject;

import Assignment_4.observer.Observer;

public interface WeatherStation {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    int getTemperature();
}
