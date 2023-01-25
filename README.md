# GH-3334
https://github.com/reactor/reactor-core/issues/3334

# How to run the example
- Specify `JAVA_HOME` to `graalvm`
- Execute `mvn -Pnative package`
- Go to `./target` folder
- Execute `./GH-3334`

The current version of this project has a dependency to `io.projectreactor:reactor-core` version `3.5.2`,
which has a fix for https://github.com/reactor/reactor-core/issues/3321.

If the version for `io.projectreactor:reactor-core` is downgraded to `3.5.1`,
one can see that the application fails with:

```
Exception in thread "main" java.lang.ExceptionInInitializerError
	at reactor.core.publisher.Flux.onAssembly(Flux.java:10722)
	at reactor.core.publisher.Flux.range(Flux.java:2013)
	at org.example.Application.main(Application.java:11)
Caused by: java.lang.IllegalStateException: Valid strategy not found
	at reactor.core.publisher.Traces.lambda$static$1(Traces.java:81)
	at java.base@17.0.5/java.util.Optional.orElseThrow(Optional.java:403)
	at reactor.core.publisher.Traces.<clinit>(Traces.java:81)
	... 3 more
```
