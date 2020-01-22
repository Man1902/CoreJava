package com.learning.designpattern;

interface State {
	public void doAction();
}

class TVStartState implements State {
	public void doAction() {
		System.out.println("TV is turned ON");
	}
}

class TVStopState implements State {
	public void doAction() {
		System.out.println("TV is turned OFF");
	}
}

class TVContext implements State {
	private State tvState; // state reference

	public void setState(State state) {
		this.tvState = state;
	}

	public State getState() {
		return this.tvState;
	}

	public void doAction() {
		this.tvState.doAction();
	}
}

public class B06StatePattern {

	public static void main(String[] args) {
		TVContext context = new TVContext();
		State tvStartState = new TVStartState();
		State tvStopState = new TVStopState();

		context.setState(tvStartState);
		context.doAction();

		context.setState(tvStopState);
		context.doAction();
	}

}
