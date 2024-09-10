package Assignment_4.observer;

public class Observer implements WeatherObserver {

        private int temperature;
        private String name;

        public Observer(String name) {
            this.name = name;
            this.temperature = 0;
        }


        @Override
        public void update(int temperature) {
            this.temperature = temperature;
            System.out.println(this.name + " kertoo että lämpötila on nyt: " + temperature);
        }


    public String getName() {
        return name;
    }
}
