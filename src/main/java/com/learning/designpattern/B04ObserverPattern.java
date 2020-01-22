package com.learning.designpattern;

import java.util.ArrayList;
import java.util.List;

interface IObserver {
	void update(int i);
}

class Observer1 implements IObserver {
	public void update(int i) {
		System.out.println("Observer1: Value in Subject is now : " + i);
	}
}

class Observer2 implements IObserver {
	public void update(int i) {
		System.out.println("Observer2: Value in Subject is now : " + i);
	}
}

interface ISubject {
	void register(IObserver o);

	void unregister(IObserver o);

	void notifyObservers(int i);
}

class Subject implements ISubject {
	List<IObserver> observerList = new ArrayList<IObserver>();
	private int flag;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
		notifyObservers(flag);
	}

	public void register(IObserver o) {
		observerList.add(o);
	}

	public void unregister(IObserver o) {
		observerList.remove(o);
	}

	public void notifyObservers(int updatedValue) {
		for (IObserver observer : observerList) {
			observer.update(updatedValue);
		}
	}
}

public class B04ObserverPattern {

}
