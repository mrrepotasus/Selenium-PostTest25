package com.ujianmingguan.pageobject.utils;

public enum TestScenario {

	T1("User invalid credentials"),
	T2("User valid login"),
	T3("Dashboard User Function");
	
	private String testName;
	
	TestScenario(String value) {
		testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
	
}
