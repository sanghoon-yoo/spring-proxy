package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class CacheInvocationHandler implements InvocationHandler {

    private final Object target;
    private Object cache = null;

    public CacheInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (this.cache != null) {
            result = this.cache;
        } else {
            result = method.invoke(target, args);
            this.cache = result;
        }

        return result;
    }
}
