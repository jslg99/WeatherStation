package weatherstation.subject;

import java.util.ArrayList;
import weatherstation.observer.Observer;

public class WeatherData implements Subject {
	
	 private ArrayList<Observer> observers;
	    private float temperature;
	    private float humidity;
	    private float pressure;

	    public WeatherData() {
	        observers = new ArrayList<>();
	    }

	    @Override
	    public void registerObserver(Observer o) {
	        observers.add(o);
	    }

	    @Override
	    public void removeObserver(Observer o) {
	        observers.remove(o);
	    }

	    @Override
	    public void notifyObservers() {
	        System.out.println("Notificando a los observadores...\n");
	        for (Observer observer : observers) {
	            observer.update(temperature, humidity, pressure);
	        }
	    }

	    public void setMeasurements(float temperature, float humidity, float pressure) {

	        if (this.temperature != temperature ||
	            this.humidity != humidity ||
	            this.pressure != pressure) {

	            this.temperature = temperature;
	            this.humidity = humidity;
	            this.pressure = pressure;

	            measurementsChanged();
	        } else {
	            System.out.println("No hay cambios en las condiciones, no se notifica.\n");
	        }
	    }

	    private void measurementsChanged() {
	        notifyObservers();
	    }
	}


