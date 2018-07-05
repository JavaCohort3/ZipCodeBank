package com.example.javacohort3.ZipCodeBank.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public class Burn {
    public static Boolean isCollection(Object object) {
        return object != null && Collection.class.isAssignableFrom(object.getClass());
    }

    public static Boolean isMap(Object object) {
        return object != null && Map.class.isAssignableFrom(object.getClass());
    }

    public static Object updateObjectFields(Object newObject, Object oldObject) {
        Field[] fields = oldObject.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);

                Object oldValue = field.get(oldObject);
                Object newValue = field.get(newObject);

                System.out.printf("- (new value) %s : %s\n", field.getName(), newValue);

                Boolean isEmptyCollection = isCollection(newValue) && ((Collection) newValue).isEmpty();
                Boolean isEmptyMap = isMap(newValue) && ((Map) newValue).isEmpty();
                Boolean isNull = (newValue == null);

                if (isEmptyCollection || isEmptyMap || isNull) field.set(newObject, oldValue);
            }
        } catch (IllegalAccessException iae) {
            return "An error occurred trying to transfer field values.";
        }

        return newObject;
    }
}
