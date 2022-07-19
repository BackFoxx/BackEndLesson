package hello.aop.pointcut;

import hello.aop.order.aop.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class ArgsTest {
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    private AspectJExpressionPointcut pointcut(String expression) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        return pointcut;
    }

    @Test
    void args() {
        assertThat(this.pointcut("args(String)")
                .matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
        assertThat(this.pointcut("args(Object)")
                .matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
        assertThat(this.pointcut("args()")
                .matches(this.helloMethod, MemberServiceImpl.class)).isFalse();
    }
}
