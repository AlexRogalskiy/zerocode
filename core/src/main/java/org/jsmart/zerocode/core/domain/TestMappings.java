package org.jsmart.zerocode.core.domain;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestMappings {
  public TestMapping[] value() default {};
}
