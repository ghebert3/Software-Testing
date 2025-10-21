package com.tennisteam.service;

import com.tennisteam.model.Match;
import java.util.*;
import java.util.stream.Collectors;

public class Scheduler {
    public static Set<String> getTeams(List<Match> matches) {
        Set<String> teams = new HashSet<>();
        for (Match m : matches) {
            teams.add(m.getTeamA());
            teams.add(m.getTeamB());
        }
        return teams;
    }

    public static List<String> suggestNextOpponents(String team, List<Match> matches) {
        Set<String> allTeams = getTeams(matches);
        Set<String> playedTeams = matches.stream()
                .filter(m -> m.getTeamA().equals(team) || m.getTeamB().equals(team))
                .map(m -> m.getTeamA().equals(team) ? m.getTeamB() : m.getTeamA())
                .collect(Collectors.toSet());

        return allTeams.stream()
                .filter(t -> !t.equals(team) && !playedTeams.contains(t))
                .collect(Collectors.toList());
    }
}
