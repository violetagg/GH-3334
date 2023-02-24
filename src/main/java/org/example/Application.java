package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.scheduler.Schedulers;

public class Application {

	public static void main(String[] args) {
		Hooks.onOperatorDebug();
		Hooks.enableAutomaticContextPropagation();
		TestThreadLocalHolder.value("something");
		System.out.println(Thread.currentThread().getName() + " " + TestThreadLocalHolder.value());

		Flux.range(0, 10)
				.doOnNext(x ->
						System.out.println(Thread.currentThread().getName() + " " + TestThreadLocalHolder.value() + " " + x))
				.subscribeOn(Schedulers.boundedElastic())
				.blockLast();
	}
}
