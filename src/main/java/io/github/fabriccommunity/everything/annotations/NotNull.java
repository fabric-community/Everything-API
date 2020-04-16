package io.github.fabriccommunity.everything.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

/**
 * Target will not be or return null.
 */
@Target({FIELD,METHOD,PARAMETER})
@Retention(RetentionPolicy.CLASS)
public @interface NotNull {
    
}