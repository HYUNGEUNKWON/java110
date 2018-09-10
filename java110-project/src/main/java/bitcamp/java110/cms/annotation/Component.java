package bitcamp.java110.cms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * 애노테이션 유지 정책
 * CLASS : 컴파일한 후에도 .class 파일에 남겨둔다. 단, 실행할 때는 참조할 수 없다.
 *         Reflection API로 클래스 파일에서 애노테이션 정보를 추출할 수 없다.
 *         애노테이션 유지청책을 지정하지 않으면 CLASS가 기본값이다.
 * SOURCE : 컴파일할 때 제거된다. 즉 .class 파일에 남겨두지 않는다.
 * RUNTIME : 컴파일한 후에도 .class 파일에 남겨둔다. 실행할 때도 참조할 수 있다.
 *           Reflection API로 클래스에서 애노테이션 정보를 추출할 수 있다.
 */

@Retention(value=RetentionPolicy.RUNTIME) // 컴파일한 후 .class 파일에 남겨 둔다.
public @interface Component {
    String value() default "";
}
