package Assignment_4;

import Assignment_4.observer.Observer;
import Assignment_4.subject.ConcreteWeatherStation;

public class Main {
    public static void main(String[] args) {
        // create concrete station
        ConcreteWeatherStation weatherStation = new ConcreteWeatherStation();
        Thread thread = new Thread(weatherStation);

        //observers
        Observer observer1 = new Observer("Eka");
        Observer observer2 = new Observer("Toka");
        Observer observer3 = new Observer("Kolmas");

        //add observers
        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);
        weatherStation.addObserver(observer3);

        //start thread
        thread.start();

        // run for a while
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Poistetaan " + observer2.getName());
        weatherStation.removeObserver(observer2);

        // run for a while
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // stop thread
        thread.interrupt();

    }
}
