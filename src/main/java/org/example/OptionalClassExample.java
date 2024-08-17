package org.example;

import java.util.Optional;

public class OptionalClassExample {

    public static void main(String[] args) {

        Optional<String> valuePresent = Optional.of("Hello");

        valuePresent.ifPresentOrElse(
                v -> System.out.println("Value is present, it's: "+v.toUpperCase()),
                () -> System.out.println("Value is absent")
        );

        Optional<String> valueAbsent = Optional.empty();

        valueAbsent.ifPresentOrElse(
                v -> System.out.println("Value is present, it's: "+v.toUpperCase()),
                () -> System.out.println("Value is absent")
        );
    }

}