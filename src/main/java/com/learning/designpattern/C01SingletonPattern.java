package com.learning.designpattern;

import java.io.Serializable;

/**
 * Note : Creational design pattern : deal with "object creation mechanisms"
 * Only one instance per application (Define a class that has only one instance)
 * 1) Private constructor
 * 2) Private static variable of Singleton class type
 * 3) Public static getInstance method which return object of Singleton class type.
 * JDK example : Runtime
 * It can maintain state. but change in state from one reference can impact other references also (as there is only one object)
 * It can't be inherited (due to private constructor)
 * 1) Eager initialization : at the time of class loading
 * 2) Static block initialization : provides option for exception handling
 * 3) Lazy Initialization :
 * 4) Thread safe Lazy Initialization : with volatile instance variable and synchronized block with double check.
 * 5) Bill Pugh Singleton Implementation : thread-safe using private static inner class.
 * 6) Enum Singleton : to avoid Reflection problem (or throw exception from private constructor) and serialization issue(serialization of enum is taken care by JVM)
 * 7) Serialization and Singleton : We have to implement readResolve() method to avoid problem during De-Serialization
 * 8) Cloning and Singleton : Don't implement Cloneable(I) If you do than just throw Exception from clone() method.
 **/

// 01) Eager initialization : at the time of class loading
class SingletonWithEgarInit {
    private static SingletonWithEgarInit instance = new SingletonWithEgarInit();

    private SingletonWithEgarInit() {
    }

    public static SingletonWithEgarInit getInstance() {
        return instance;
    }
}

// 02) Static block initialization : provides option for exception handling
class SingletonWithStaticBlock {
    private static SingletonWithStaticBlock instance;

    private SingletonWithStaticBlock() {
    }

    static {
        try {
            instance = new SingletonWithStaticBlock();
        } catch (Exception e) {
            System.out.println("Exception occurred while creation instance" + e.getMessage());
        }

    }

    public static SingletonWithStaticBlock getInstance() {
        return instance;
    }
}

// 03) Lazy Initialization
class SingletonWithLazyInit {
    private static SingletonWithLazyInit instance;

    private SingletonWithLazyInit() {
    }

    public static SingletonWithLazyInit getInstance() {
        if (instance == null) {
            instance = new SingletonWithLazyInit();
        }
        return instance;
    }
}

// 04) Thread safe Lazy Initialization.
// Without volatile modifier it's possible for another thread in Java to see half initialized state of instance variable, but with volatile variable guaranteeing happens-before
// relationship, all the write will happen on volatile instance before any read of instance variable.
class SingletonWithSynchronization {
    private volatile static SingletonWithSynchronization instance = null;

    private SingletonWithSynchronization() {
    }

    public static SingletonWithSynchronization getInstance() {
        if (instance == null) {
            synchronized (SingletonWithSynchronization.class) {
                if (instance == null) { // DOUBLE CHECK
                    instance = new SingletonWithSynchronization();
                }
            }
        }
        return instance;
    }
}

// 05) Bill Pugh Singleton Implementation : thread-safe using private static inner class
class SingletonWithBillPughImpl {
    private SingletonWithBillPughImpl() {
    }

    private static class SingletonHelper {
        private static SingletonWithBillPughImpl instance = new SingletonWithBillPughImpl();
    }

    public static SingletonWithBillPughImpl getInstance() {
        return SingletonHelper.instance;
    }
}

// 6) Enum Singleton : to avoid Reflection issue and Serialization issue(serialization of enum is taken care by JVM)
enum EnumSingletonClass {
    OBJ;

    public void doTask() {
        System.out.println("My stuff");
    }
}

// 7) to avoid Reflection issue
class SingletonWithReflectionHandling {
    private static SingletonWithReflectionHandling instance;

    private SingletonWithReflectionHandling() throws Exception {
        throw new Exception("Reflection not allowed");
    }

    static {
        try {
            instance = new SingletonWithReflectionHandling();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SingletonWithReflectionHandling getInstance() {
        return instance;
    }
}

// 08) Serialization and Singleton : We have to implement readResolve() method to avoid problem during De-Serialization
class SingletonWithSerializationHandling implements Serializable {
    private static final long serialVersionUID = 1L;
    private static SingletonWithSerializationHandling instance = new SingletonWithSerializationHandling();

    private SingletonWithSerializationHandling() {
    }

    public static SingletonWithSerializationHandling getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}

// 09) Cloning and Singleton : Don't implement Cloneable(I) If you do than just throw Exception from clone() method
class SingletonWithCloneHandling implements Cloneable {
    private static SingletonWithCloneHandling instance = new SingletonWithCloneHandling();

    private SingletonWithCloneHandling() {
    }

    public static SingletonWithCloneHandling getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

public class C01SingletonPattern {
    public static void main(String[] args) {
        SingletonWithEgarInit obj1 = SingletonWithEgarInit.getInstance();
        SingletonWithEgarInit obj2 = SingletonWithEgarInit.getInstance();
        System.out.println("obj1 == obj2 : " + (obj1 == obj2));
        System.out.println("obj1.equals(obj2) : " + obj1.equals(obj2));

        Thread t1 = new Thread(() -> {
            SingletonWithSynchronization instance1 = SingletonWithSynchronization.getInstance();
            System.out.println("Instance 1 hash:" + instance1.hashCode());
        });
        Thread t2 = new Thread(() -> {
            SingletonWithSynchronization instance2 = SingletonWithSynchronization.getInstance();
            System.out.println("Instance 2 hash:" + instance2.hashCode());
        });
        t1.start();
        t2.start();
    }
}
