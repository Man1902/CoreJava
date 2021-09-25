package com.learning.corejava.parent;

public class ParentClass {
    int defaultField = 2;
    protected int protectedField = 3;
    public int publicField = 4;
    public int parentPublicField = 5;

    void defaultMethod() {
        System.out.println("ParentClass -> defaultMethod");
    }

    protected void protectedMethod() {
        System.out.println("ParentClass -> protectedMethod");
    }

    public void publicMethod() {
        System.out.println("ParentClass -> publicMethod");
    }
}