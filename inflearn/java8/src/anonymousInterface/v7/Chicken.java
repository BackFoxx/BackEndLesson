package anonymousInterface.v7;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    // 제너릭 타입 파라미터
    String value();
}
