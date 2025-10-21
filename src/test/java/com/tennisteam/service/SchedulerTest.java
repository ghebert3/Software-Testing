package com.tennisteam.service;
import java.util.Set;

import com.tennisteam.model.Match;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.descriptor.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchedulerTest {

    @Test
    void suggestNextOpponents_onlySuggestsUnplayedTeams() {
        // setup
        Match m1 = new Match("Lions", "Tigers");
        Match m2 = new Match("Lions", "Bears");
        Match m3 = new Match("Tigers", "Wolves");
        List<Match> matches = List.of(m1, m2, m3);

        // do the thing
        List<String> result = Scheduler.suggestNextOpponents("Lions", matches);

        // assertion
        assertEquals(Set.of("Wolves"), Set.copyOf(result));
    }
    @MethodSource("teamData")
    @ParameterizedTest
    void suggestNextOpponents_parameterized(String team, Set<String> expectedOpponents) {
        // setup
        List<Match> matches = List.of(
                mkMatch("Lions", "Tigers"),
                mkMatch("Lions", "Bears"),
                mkMatch("Tigers", "Wolves")
        );

        // do the thing
        List<String> actual = Scheduler.suggestNextOpponents(team, matches);

        // assertion
        assertEquals(expectedOpponents, Set.copyOf(actual),
                "Expected " + team + " to be able to play " + expectedOpponents);
    }
}
