package org.example;

public class Main {
    public static void main(String[] args) {
        Injector<SomeBean> injector = new Injector<>();
        SomeBean someBean = injector.inject(new SomeBean());
        Class<?> objectClass = someBean.getClass();
        System.out.println(objectClass);
        someBean.foo();
        SomeBean otherBean = (new Injector<SomeBean>()).inject(new SomeBean());
        Class<?> othetObjectClass = someBean.getClass();
        System.out.println(othetObjectClass);
        otherBean.foo();
    }
}