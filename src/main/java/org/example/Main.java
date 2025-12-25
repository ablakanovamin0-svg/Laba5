package org.example;

/**
 * Класс для показа функционала созданных классов
 * @version 1.0
 * @author ablakanovamin0-svg
 */
public class Main {
    /**
     * Показ функционала методов созданных классов
     */
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