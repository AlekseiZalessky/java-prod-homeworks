import annotations.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Params implements InvocationHandler {
    private final Object target;

    private Params(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public static <T> T wrap(T target, Class<T> iface) {
        if (!iface.isInterface()) {
            throw new IllegalArgumentException(iface + " is not an interface");
        }
        return (T) Proxy.newProxyInstance(
                iface.getClassLoader(),
                new Class<?>[]{iface},
                new Params(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method impl = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (!impl.isAnnotationPresent(Log.class)) {
            return impl.invoke(target, args);
        }
        StringBuilder result = new StringBuilder();
        result.append("execute method: ").append(method.getName());
        for (Object arg : args) {
            result.append(", param: ").append(arg);
        }
        System.out.println(result);
        return impl.invoke(target, args);
    }
}
