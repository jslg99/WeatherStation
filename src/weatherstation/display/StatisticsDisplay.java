package weatherstation.display;

import weatherstation.observer.Observer;
import weatherstation.observer.DisplayElement;
import weatherstation.subject.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemp = Float.MIN_VALUE;
    private float minTemp = Float.MAX_VALUE;
    private float tempSum = 0.0f;
    private int numReadings;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) maxTemp = temperature;
        if (temperature < minTemp) minTemp = temperature;

        display();
    }

    @Override
    public void display() {
        System.out.println("📊 Promedio/Máx/Mín temperatura = " +
                (tempSum / numReadings) + "/" +
                maxTemp + "/" +
                minTemp);
    }
}