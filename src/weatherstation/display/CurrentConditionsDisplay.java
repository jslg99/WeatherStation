package weatherstation.display;

import weatherstation.observer.Observer;
import weatherstation.observer.DisplayElement;
import weatherstation.subject.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Condiciones actuales: " +
                temperature + "°C y " +
                humidity + "% de humedad");
    }
}
