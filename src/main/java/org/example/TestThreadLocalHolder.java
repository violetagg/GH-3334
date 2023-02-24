package org.example;

public final class TestThreadLocalHolder {

	static final ThreadLocal<String> holder = new ThreadLocal<>();

	static void reset() {
		holder.remove();
	}

	static String value() {
		return holder.get();
	}

	static void value(String value) {
		holder.set(value);
	}
}
