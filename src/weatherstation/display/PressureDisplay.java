package weatherstation.display;

import weatherstation.observer.Observer;
import weatherstation.observer.DisplayElement;
import weatherstation.subject.Subject;

public class PressureDisplay implements Observer, DisplayElement {

    private float pressure;
    private Subject weatherData;

    public PressureDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Presión atmosférica: " + pressure + " hPa");
    }
}

