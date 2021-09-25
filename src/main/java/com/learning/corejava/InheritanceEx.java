package com.learning.corejava;

import com.learning.corejava.child.ChildClass;
import com.learning.corejava.parent.ParentClass;

public class InheritanceEx {
    public static void main(String[] args) {
        ParentClass obj1 = new ChildClass();
        //You can not override Base class variables in sub class.(Because variables are resolved at compile time)
        System.out.println(obj1.publicField);  // 4 not 40
        System.out.println(obj1.parentPublicField);
        //System.out.println(obj1.childPublicField);  // compilation error as not present in parent class
        //System.out.println(obj1.defaultField);        // compilation error
        //System.out.println(obj1.protectedField);
        obj1.publicMethod();

        ChildClass obj2 = new ChildClass();
        System.out.println(obj2.publicField);
        System.out.println(obj2.parentPublicField);  // through inheritance child can access field of parent
        System.out.println(obj2.childPublicField);
        obj2.publicMethod();
    }
}


