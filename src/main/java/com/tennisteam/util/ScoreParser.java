package com.tennisteam.util;

public class ScoreParser {
    public static int countSetsWon(String score) {
        String[] sets = score.split(" ");
        int count = 0;
        for (String set : sets) {
            String[] games = set.split("-");
            if (games.length == 2 && Integer.parseInt(games[0]) > Integer.parseInt(games[1])) {
                count++;
            }
        }
        return count;
    }
}
