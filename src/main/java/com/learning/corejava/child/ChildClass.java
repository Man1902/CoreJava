package com.learning.corejava.child;

import com.learning.corejava.parent.ParentClass;

public class ChildClass extends ParentClass {
    int defaultField = 20;
    protected int protectedField = 30;
    public int publicField = 40;
    public int childPublicField = 50;

    void defaultMethod() {
        System.out.println("ChildClass -> defaultMethod");
    }

    protected void protectedMethod() {
        System.out.println("ChildClass -> protectedMethod");
    }

    public void publicMethod() {
        System.out.println("ChildClass -> publicMethod");
    }
}