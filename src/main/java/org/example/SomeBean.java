package org.example;

/**
 * Класс, содержащий объявление полей field1 и field2
 * @author ablakanovamin0-svg
 * @version 1.0
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;
    public void foo() {
        field1.doSomething();
        field2.doSomething();
    }
}
