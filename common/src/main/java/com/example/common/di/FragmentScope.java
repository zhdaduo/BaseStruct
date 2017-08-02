package com.example.common.di;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Scope;

/**
 * Created by Bill on 2017/8/1.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {

}
