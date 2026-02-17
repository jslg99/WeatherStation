package weatherstation.display;

import weatherstation.observer.Observer;
import weatherstation.observer.DisplayElement;
import weatherstation.subject.Subject;

public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 1013f;
    private float lastPressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.print("🌦️  Pronóstico: ");
        if (currentPressure > lastPressure) {
            System.out.println("Mejorando el clima.");
        } else if (currentPressure == lastPressure) {
            System.out.println("Sin cambios.");
        } else {
            System.out.println("Posible lluvia o clima frío.");
        }
    }
}