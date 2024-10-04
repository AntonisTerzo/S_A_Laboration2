package interceptor;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@LogInfo
public class LoggingInterceptor {
    @AroundInvoke
    public Object logMethodInfo(InvocationContext ctx) throws Exception {
        Class<?> targetClass = getTargetClass(ctx.getTarget());
        Logger logger = LoggerFactory.getLogger(targetClass);

        logger.info("Entering method: {} and parameters {}", ctx.getMethod(), ctx.getParameters());
        return ctx.proceed();
    }

    private Class<?> getTargetClass(Object proxy) {
        Class<?> proxyClass = proxy.getClass();
        if (proxyClass.getName().contains("$$")) {
            return proxyClass.getSuperclass();
        }
        return proxyClass;
    }
}
