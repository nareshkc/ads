package com.reportModification;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class execute {
  @Test
  public void execute() throws Exception {
	  Function.move_Files("Allure_Style");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Report Execution Started");
  }

  @AfterClass
  public void afterClass() {
  }

}
