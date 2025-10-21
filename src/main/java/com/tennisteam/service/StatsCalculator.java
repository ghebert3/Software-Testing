package com.tennisteam.service;

import com.tennisteam.model.Match;
import com.tennisteam.util.ScoreParser;
import java.util.*;

public class StatsCalculator {

    public static Map<String, Integer> calculateTeamWins(List<Match> matches) {
        Map<String, Integer> wins = new HashMap<>();
        for (Match m : matches) {
            int setsWonA = ScoreParser.countSetsWon(m.getScoreA());
            int setsWonB = ScoreParser.countSetsWon(m.getScoreB());
            String winner = setsWonA > setsWonB ? m.getTeamA() : m.getTeamB();
            wins.put(winner, wins.getOrDefault(winner, 0) + 1);
        }
        return wins;
    }

    public static Map<String, Integer> calculatePlayerWins(List<Match> matches) {
        Map<String, Integer> wins = new HashMap<>();
        for (Match m : matches) {
            int setsWonA = ScoreParser.countSetsWon(m.getScoreA());
            int setsWonB = ScoreParser.countSetsWon(m.getScoreB());
            String winner = setsWonA > setsWonB ? m.getPlayerA() : m.getPlayerB();
            wins.put(winner, wins.getOrDefault(winner, 0) + 1);
        }
        return wins;
    }
}
