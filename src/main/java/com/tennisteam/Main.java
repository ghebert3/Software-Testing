package com.tennisteam;

import com.tennisteam.model.Match;
import com.tennisteam.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/matches.csv";
        List<Match> matches = CSVLoader.loadMatches(filePath);

        System.out.println("=== TEAM WIN STATS ===");
        Map<String, Integer> teamWins = StatsCalculator.calculateTeamWins(matches);
        teamWins.forEach((team, wins) -> System.out.println(team + ": " + wins + " wins"));

        System.out.println("\n=== PLAYER WIN STATS ===");
        Map<String, Integer> playerWins = StatsCalculator.calculatePlayerWins(matches);
        playerWins.forEach((player, wins) -> System.out.println(player + ": " + wins + " wins"));

        System.out.println("\n=== SCHEDULER ===");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a team name to suggest next opponents: ");
        String team = sc.nextLine();

        List<String> suggestions = Scheduler.suggestNextOpponents(team, matches);
        if (suggestions.isEmpty()) {
            System.out.println("No new opponents to schedule!");
        } else {
            System.out.println("Next possible opponents: " + suggestions);
        }
    }
}
