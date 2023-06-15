package cn.edu.cqut.crmservice.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 11874
 */
@Retention(RetentionPolicy.RUNTIME) // 这个注解的作用域
@Target(ElementType.METHOD) // 这个注解使用的位置
public @interface Auth {
    boolean value() default true;

    String[] roles() default "ADMIN";
}
