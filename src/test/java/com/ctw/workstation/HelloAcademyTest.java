package com.ctw.workstation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HelloAcademyTest {

    @ParameterizedTest
    @MethodSource("helloArguments")
    void hello(String expected, String name) {
        //given
        HelloAcademy helloAcademy = new HelloAcademy();

        //when
        String result = helloAcademy.sayHello(name);

        //then
        assertEquals(expected, result, "Validate if application could say hello properly");
    }

    static Stream<Arguments> helloArguments() {
        return Stream.of(
                arguments("Hello xbox academy", "xbox academy"),
                arguments("Hello ", ""),
                arguments("Hello   ", "  ")
        );
    }

    @Test
    void sayHello() {
        //given
        HelloAcademy helloAcademy = new HelloAcademy();
        String name = "André";

        //when
        String result = helloAcademy.sayHello(name);

        //then
        assertEquals("Hello " + name, result);
    }

    @Test
    void sayHelloNull() {
        //given
        HelloAcademy helloAcademy = new HelloAcademy();
        String name = "André";

        //when
        String result = helloAcademy.sayHello(name);

        //then
        assertEquals("Hello " + name, result);
    }
}