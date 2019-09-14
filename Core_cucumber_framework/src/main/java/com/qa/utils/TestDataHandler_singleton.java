package com.qa.utils;

public class TestDataHandler_singleton {
	
	private static TestDataHandler testdata = new TestDataHandler();
	private TestDataHandler_singleton() {
	 }
	
	public static TestDataHandler getInstance( ) {
	       return testdata;
	 }
}
