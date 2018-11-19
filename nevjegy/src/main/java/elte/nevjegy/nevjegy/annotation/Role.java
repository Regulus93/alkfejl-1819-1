package elte.nevjegy.nevjegy.annotation;


import elte.nevjegy.nevjegy.enumtype.UserRole;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Role {
    UserRole[] value() default {UserRole.ROLE_GUEST};
}
