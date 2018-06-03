package com.designmodel.proxy.config;


import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Intercepts {
    String[] methods();
}
