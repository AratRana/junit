package com.ut;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class TestBlock4Runner extends BlockJUnit4ClassRunner {

	@SuppressWarnings({ "unused", "rawtypes" })
	private Class testClass;

	public TestBlock4Runner(Class<?> testClass) throws InitializationError {
		super(testClass);
		this.testClass = testClass;
	}
	
	@Override
	public void run(RunNotifier runNotifier) {
		super.run(runNotifier);
	}

}
