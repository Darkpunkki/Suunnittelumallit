package Assignment_4.subject;

import Assignment_4.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteWeatherStation implements WeatherStation, Runnable{
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public ConcreteWeatherStation() {
        this.temperature = (int) (Math.random() * 100);
        System.out.println("Alkulämmöt: " + temperature);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public void run() {
        while (true) {

            int change = (Math.random() > 0.5) ? 1 : -1;
            temperature = Math.max(0, Math.min(100, temperature + change)); // lämpötila aina välillä 0-100

            setTemperature(temperature);

            // odotetaan 1-5 sekuntia ennen seuraavaa lämpötilan muutosta
            int sleepTime = 1000 + (int)(Math.random() * 4000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
