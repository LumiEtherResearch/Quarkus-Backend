package com.example;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class MainApplication implements QuarkusApplication {

	@Override
	public int run(String... args) {
		System.out.println("Hello World from Quarkus");
		Quarkus.waitForExit();
		return 0;
	}
}
