import annotations.After;
import annotations.Before;
import annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) throws ClassNotFoundException {
        run("TestClass");

    }

    private static void run(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);

        Method[] methods = clazz.getDeclaredMethods();

        List<Method> beforeMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Before.class)) {
                beforeMethods.add(method);
            }
            if (method.isAnnotationPresent(After.class)) {
                afterMethods.add(method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }

        int success = 0;
        int fail = 0;

        for (Method testMethod : testMethods) {
            if (runMethod(clazz, beforeMethods, testMethod, afterMethods)) {
                success++;
            } else {
                fail++;
            }
        }

        System.out.println("success: " + success);
        System.out.println("fail: " + fail);
        System.out.println("count tests: " + (testMethods.size()));
    }

    private static boolean runMethod(Class<?> clazz, List<Method> beforeMethods, Method test, List<Method> afterMethods) {
        Object instance = null;
        boolean success = true;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();

            for (Method beforeMethod : beforeMethods) {
                beforeMethod.invoke(instance);
            }

            test.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        } finally {
            if (instance != null) {
                try {
                    for (Method afterMethod : afterMethods) {
                        afterMethod.invoke(instance);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    success = false;
                }
            }
        }
        return success;
    }
}