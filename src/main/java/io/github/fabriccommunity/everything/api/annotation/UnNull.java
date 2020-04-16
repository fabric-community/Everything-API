package io.github.fabriccommunity.everything.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * I am unnullius.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target
		(
				{
						ElementType.ANNOTATION_TYPE,
						ElementType.CONSTRUCTOR,
						ElementType.FIELD,
						ElementType.LOCAL_VARIABLE,
						ElementType.METHOD,
						ElementType.PACKAGE,
						ElementType.PARAMETER,
						ElementType.TYPE,
						ElementType.TYPE_USE
				}
		)
public @interface UnNull {
}
