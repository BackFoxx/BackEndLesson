package hello.aop.pointcut;

import hello.aop.order.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;
@Slf4j
public class WithinTest {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMethod() {
        //public java.lang.String hello.aop.order.aop.member.MemberServiceImpl.hello(java.lang.String)
        log.info("helloMethod = {}", this.helloMethod);
    }

    @Test
    void withinExact() {
        pointcut.setExpression("within(hello.aop.order.aop.member.MemberServiceImpl)");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void withinStar() {
        pointcut.setExpression("within(hello.aop.order.aop.member.*Service*)");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void withinSubPackage() {
        pointcut.setExpression("within(hello.aop.order.aop..*)");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void withinSupertypeFalse() {
        pointcut.setExpression("within(hello.aop.order.aop.member.MemberService)");
        Assertions.assertThat(this.pointcut.matches(this.helloMethod, MemberServiceImpl.class)).isFalse();
    }
}
