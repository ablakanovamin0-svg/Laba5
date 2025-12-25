package org.example;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;

/**
 * Класс, реализующий поиск полей с
 * созданной аннотацией и создание экземпляров
 * классов, получая информацию из файла конфигурации
 * @param <T> тип объекта
 * @author ablakanovamin0-svg
 * @version 1.0
 */
public class Injector<T> {
    public T inject(T object) {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(inputStream);
        }
        catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        Class<?> classOfObject = object.getClass();
        Field[] fields = classOfObject.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(AutoInjectable.class)) {
                    String implementation = properties.getProperty(field.getType().getName());
                    try {
                        Class<?> implementationClass = Class.forName(implementation);
                        Object instance = implementationClass.getDeclaredConstructor().newInstance();
                        field.setAccessible(true);
                        field.set(object, instance);
                    }
                    catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException exception) {
                        throw new RuntimeException(exception);
                    }
                }
            }
        }
        return object;
    }
}
