package net.ugolok.generation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Generate {
	Class<?> provider();

	int quantity() default 0;

	long min() default 0;

	long max() default Integer.MAX_VALUE;

	String minStr() default "";

	String maxStr() default "";

	boolean unique() default false;

	String source() default "";

	String[] params() default {};
}
