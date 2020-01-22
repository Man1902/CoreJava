package com.learning.designpattern;

import java.io.Serializable;

//Only one instance per application.State can be modify
class SingletonWithEgarInit { // 01
	private static final SingletonWithEgarInit INSTANCE = new SingletonWithEgarInit();

	private SingletonWithEgarInit() {
	}

	public static SingletonWithEgarInit getInstance() {
		return INSTANCE;
	}
}

class SingletonWithStaticBlock { // 02
	private static final SingletonWithStaticBlock INSTANCE;

	private SingletonWithStaticBlock() {
	}

	static {
		INSTANCE = new SingletonWithStaticBlock();
	}

	public static SingletonWithStaticBlock getInstance() {
		return INSTANCE;
	}
}

class SingletonWithLazyInit { // 03
	private static SingletonWithLazyInit obj;

	private SingletonWithLazyInit() {
	}

	public static SingletonWithLazyInit getInstance() {
		if (obj == null) {
			obj = new SingletonWithLazyInit();
		}
		return obj;
	}
}

class SingletonWithSynchronization { // 04
	private static SingletonWithSynchronization obj;

	private SingletonWithSynchronization() {
	}

	public static SingletonWithSynchronization getInstance() {
		if (obj == null) {
			synchronized (obj) {
				if (obj == null) { // DOUBLE CHECK
					obj = new SingletonWithSynchronization();
				}
			}
		}
		return obj;
	}
}

class SingletonWithBillPughImpl { // 05 thread safe
	private SingletonWithBillPughImpl() {
	}

	private static class SingletonHelper {
		private static final SingletonWithBillPughImpl INSTANCE = new SingletonWithBillPughImpl();
	}

	public static SingletonWithBillPughImpl getInstance() {
		return SingletonHelper.INSTANCE;
	}
}

enum EnumSingletonClass { // 06 to avoid reflection problem
	OBJ;
	public void doTask() {
		System.out.println("My stuff");
	}
}

class SingletonWithReflectionHandling { // 07
	private static SingletonWithReflectionHandling INSTANCE;

	private SingletonWithReflectionHandling() throws Exception {
		throw new Exception("Reflection not allowed");
	}

	static {
		try {
			INSTANCE = new SingletonWithReflectionHandling();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SingletonWithReflectionHandling getInstance() {
		return INSTANCE;
	}
}

class SingletonWithSeriealizationHandling implements Serializable { // 08
	private static final long serialVersionUID = 1L;
	private static final SingletonWithSeriealizationHandling INSTANCE = new SingletonWithSeriealizationHandling();

	private SingletonWithSeriealizationHandling() {
	}

	public static SingletonWithSeriealizationHandling getInstance() {
		return INSTANCE;
	}

	private Object readResolve() {
		return INSTANCE;
	}
}

class SingletonWithCloneHandling implements Cloneable { // 09
	private static final SingletonWithCloneHandling INSTANCE = new SingletonWithCloneHandling();

	private SingletonWithCloneHandling() {
	}

	public static SingletonWithCloneHandling getInstance() {
		return INSTANCE;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}

public class C01SingletonPattern {

}
