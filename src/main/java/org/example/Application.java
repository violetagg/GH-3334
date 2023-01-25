package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;

public class Application {

	public static void main(String[] args) {
		Hooks.onOperatorDebug();

		Flux.range(0, 10)
				.doOnNext(System.out::println)
				.blockLast();
	}
}
