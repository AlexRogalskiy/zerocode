package org.jsmart.zerocode.core.runner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import org.jsmart.zerocode.core.domain.Scenario;
import org.jsmart.zerocode.core.domain.ScenarioSpec;
import org.jsmart.zerocode.core.domain.Scenarios;
import org.jsmart.zerocode.core.domain.TestPackageRoot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Description;

public class ZeroCodePackageRunnerScenariosTest {

  ZeroCodePackageRunner zeroCodePackageRunner;

  @Scenarios({
    @Scenario("unit_tests/folder_a/test_case_1.json"), // any valid path
    @Scenario("unit_tests/folder_b/test_case_2.json"), // any valid path
  })
  public static class ScenarioTestFlowExampleSelectedTest {}

  @TestPackageRoot("03_test_one_multi_steps")
  public static class ScenarioTestFlowSelectedExampleTest {}

  @Before
  public void initializeRunner() throws Exception {
    zeroCodePackageRunner = new ZeroCodePackageRunner(ScenarioTestFlowExampleSelectedTest.class);
  }

  @Test
  public void willHaveListOf_TestCases_Here() throws Exception {
    List<ScenarioSpec> children = zeroCodePackageRunner.getChildren();
    assertThat(children.size(), is(2));
  }

  @Test
  public void testDescribeAChild() throws Exception {
    List<ScenarioSpec> children = zeroCodePackageRunner.getChildren();
    Description childDescription = zeroCodePackageRunner.describeChild(children.get(0));

    assertThat(childDescription.getDisplayName(), containsString("test scenario 1"));
  }
}
