package com.example;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;

public class MainApplication implements QuarkusApplication {

	@Override
	public int run(String... args) throws Exception {
		System.out.println("Hello World from Quarkus");
		Quarkus.waitForExit();
		return 0;
	}
}
