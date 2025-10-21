package com.tennisteam.service;

import com.tennisteam.model.Match;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class CSVLoader {
    public static List<Match> loadMatches(String filePath) {
        List<Match> matches = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines.subList(1, lines.size())) {
                String[] parts = line.split(",");
                LocalDate date = LocalDate.parse(parts[0]);
                matches.add(new Match(date, parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
    }
}
