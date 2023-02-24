package org.example;

import io.micrometer.context.ThreadLocalAccessor;

public final class TestThreadLocalAccessor implements ThreadLocalAccessor<String> {

	static final String KEY = "testContextPropagation";

	@Override
	public Object key() {
		return KEY;
	}

	@Override
	public String getValue() {
		return TestThreadLocalHolder.value();
	}

	@Override
	public void setValue(String value) {
		TestThreadLocalHolder.value(value);
	}

	@Override
	public void reset() {
		TestThreadLocalHolder.reset();
	}
}
