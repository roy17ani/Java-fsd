package com.ecommerce.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.function.Executable;

@RunWith(JUnitPlatform.class)
public class DynamicTests {

    @TestFactory
    Collection<org.junit.jupiter.api.DynamicTest> dynamicTests() {
        return Arrays.asList(
            dynamicTest("simple dynamic test", () -> assertTrue(true)),
            dynamicTest("My Executable Class", new MyExecutable()),
            dynamicTest("Exception Executable", () -> {throw new Exception("Exception Example");}),
            dynamicTest("simple dynamic test-2", () -> assertTrue(true))
        );
    }
}

class MyExecutable implements Executable {

    @Override
    public void execute() throws Throwable {
        System.out.println("Hello World!");
    }
}

