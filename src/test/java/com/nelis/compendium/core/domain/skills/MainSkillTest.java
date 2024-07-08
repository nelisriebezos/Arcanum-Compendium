package com.nelis.compendium.core.domain.skills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainSkillTest {
    private MainSkill testStrength;
    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @MethodSource("provideSkillModifiers")
    void calculateSkillModifier(int value, int modifier) {
        testStrength = MainSkill.builder()

                .build();
    }

    private static Stream<Arguments> provideSkillModifiers() {
        return Stream.of(
                Arguments.of(1, -5),
                Arguments.of(1, -5),
        );
    }
}