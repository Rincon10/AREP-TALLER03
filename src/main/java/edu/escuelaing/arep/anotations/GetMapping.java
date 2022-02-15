package edu.escuelaing.arep.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/15/2022
 * @project App
 * @Retention to check the annotation on RUNTIME
 * @Target Indicates the contexts in which an annotation type is applicable
 *
 * Class that denotes an annotation type definition, in this case denotes the method GetMapping on runtime
 */
@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD)
public @interface GetMapping {
    public String value();
}
