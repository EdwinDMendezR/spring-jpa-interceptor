package spring;


import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringInterceptorApplication {

    @Bean
    public CustomizableTraceInterceptor interceptor() {
        CustomizableTraceInterceptor interceptor = new CustomizableTraceInterceptor();
        interceptor.setEnterMessage(
                "\n setEnterMessage \n" +
                " 1. $[methodName]\n" +
                " 2. $[targetClassName]\n" +
                " 3. $[targetClassShortName]\n" +
                " 4. $[argumentTypes]\n" +
                " 5. $[arguments]\n"
        );

        interceptor.setExitMessage(
                "\n setExitMessage \n" +
                " 1. $[methodName]\n" +
                " 2. $[returnValue]\n" +
                " 3. $[invocationTime]ms."
        );

        return interceptor;
    }

    @Bean
    public Advisor traceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * org.springframework.data.repository.Repository+.*(..))");
        return new DefaultPointcutAdvisor(pointcut, interceptor());
    }


}
