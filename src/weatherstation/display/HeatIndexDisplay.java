package weatherstation.display;

import weatherstation.observer.Observer;
import weatherstation.observer.DisplayElement;
import weatherstation.subject.Subject;

public class HeatIndexDisplay implements Observer, DisplayElement {

    private float heatIndex;
    private Subject weatherData;

    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        heatIndex = computeHeatIndex(temperature, humidity);
        display();
    }

    private float computeHeatIndex(float t, float rh) {
        return (float)(
            16.923 + (0.185212 * t) + (5.37941 * rh)
            - (0.100254 * t * rh)
        );
    }

    @Override
    public void display() {
        System.out.println("Índice de calor: " + heatIndex);
    }
}