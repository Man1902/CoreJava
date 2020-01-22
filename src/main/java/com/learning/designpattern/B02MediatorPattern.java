package com.learning.designpattern;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
	void addUser(User user);

	void sendMessage(String msg, User fromUser);
}

abstract class User {
	protected ChatMediator mediator;
	protected String name;

	public User(ChatMediator med, String name) {
		this.mediator = med;
		this.name = name;
	}

	public abstract void send(String msg);

	public abstract void receive(String msg);
}

class ChatMediatorImpl implements ChatMediator {
	private List<User> users;

	public ChatMediatorImpl() {
		this.users = new ArrayList<>();
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

	@Override
	public void sendMessage(String msg, User fromUser) {
		for (User user : this.users) {
			// message should not be received by the user sending it
			if (user != fromUser) {
				user.receive(msg);
			}
		}
	}

}

class UserImpl extends User {

	public UserImpl(ChatMediator med, String name) {
		super(med, name);
	}

	@Override
	public void send(String msg) {
		System.out.println(this.name + ": Sending Message=" + msg);
		mediator.sendMessage(msg, this);
	}

	@Override
	public void receive(String msg) {
		System.out.println(this.name + ": Received Message:" + msg);
	}

}

public class B02MediatorPattern {

	public static void main(String[] args) {
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);

		user1.send("Hi All");
	}
}
