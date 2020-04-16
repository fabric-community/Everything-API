package io.github.fabriccommunity.everything.annotations;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Target maybe or return null
 */
@Target({FIELD,METHOD,PARAMETER})
@Retention(RetentionPolicy.CLASS)
public @interface MayLeadToNullPointerException {

    
}