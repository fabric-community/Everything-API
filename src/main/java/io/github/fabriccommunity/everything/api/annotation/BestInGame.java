package io.github.fabriccommunity.everything.api.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Target is best in game.
 */
@Target({FIELD,METHOD,PARAMETER,PACKAGE,CONSTRUCTOR,LOCAL_VARIABLE,TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface BestInGame {
    
}