package weatherstation.app;

import weatherstation.subject.WeatherData;
import weatherstation.display.*;

public class WeatherStation {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        new CurrentConditionsDisplay(weatherData);
        new StatisticsDisplay(weatherData);
        new ForecastDisplay(weatherData);
        new HeatIndexDisplay(weatherData);
        new PressureDisplay(weatherData);

        weatherData.setMeasurements(27, 65, 1013);
        weatherData.setMeasurements(27, 65, 1013); 
        weatherData.setMeasurements(28, 70, 1012); 
        weatherData.setMeasurements(26, 90, 1009); 
    }
}
