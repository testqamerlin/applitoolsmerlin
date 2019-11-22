package com.applitoolsqamerlin.runnerTest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.applitoolsqamerlin.login")
public class RunnerTest {
  public static void main(String[] args){
    JUnitCore.main(RunnerTest.class.getName());
  }
}
