package com.designmodel.struct.proxy.mbatispluginproxy;


import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Intercepts {
    String[] methods();
}
