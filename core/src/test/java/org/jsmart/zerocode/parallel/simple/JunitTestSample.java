package org.jsmart.zerocode.parallel.simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class JunitTestSample {

  @Test
  public void testFirstName() {
    try {
      Thread.sleep(2000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    assertThat("Albert", is("Albert"));
  }

  @Test
  public void testFirstName_fail() {
    try {
      Thread.sleep(2000L);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    assertThat("Albert", is("Albert_X"));
  }
}
