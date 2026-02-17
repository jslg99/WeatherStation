package weatherstation.subject;

import weatherstation.observer.Observer;

public interface Subject {
	void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}
