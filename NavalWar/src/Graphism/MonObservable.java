package Graphism;

import java.util.Observable;

public class MonObservable extends Observable {
	
	public void myNotify() {
		this.setChanged();
		this.notifyObservers("test");
	}
	
}
