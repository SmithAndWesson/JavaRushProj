package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods origObj;

    public CustomInvocationHandler(SomeInterfaceWithMethods origObj) {
        this.origObj = origObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object object = method.invoke(origObj, args);
        System.out.println(method.getName() + " out");
        return object;
    }
}
