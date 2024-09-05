package com.ant.problemSolvingPractice.algoExpert.array.tournamentWinner;

import java.util.*;

public class TournamentWinner {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 1));
        System.out.println(tournamentWinner(competitions, results));
    }

    public static String betterSolution(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String currentTeam = "";
        HashMap<String, Integer> teams = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            String homeTeam = competitions.get(i).get(0);
            String awayTeam = competitions.get(i).get(1);
            String winnerTeam = results.get(i) == 1 ? homeTeam : awayTeam;
            teams.put(winnerTeam, teams.getOrDefault(winnerTeam, 0) + 3);
            if (teams.get(winnerTeam) > teams.get(currentTeam)) {
                currentTeam = winnerTeam;
            }
        }
        return currentTeam;
    }

    public static String tournamentWinner
            (ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        int index = 0;
        Map<String, Integer> winners = new HashMap<>();
        for (Integer a : results) {
            if (a == 1) {
                winners.merge(competitions.get(index).get(0), 3, Integer::sum);
                winners.merge(competitions.get(index).get(1), 0, Integer::sum);
            } else {
                winners.merge(competitions.get(index).get(0), 0, Integer::sum);
                winners.merge(competitions.get(index).get(1), 3, Integer::sum);
            }
            index++;
        }
        String winTeam = new String();
        int currentScore = 0;
        for (Map.Entry<String, Integer> c : winners.entrySet()) {
            if (currentScore < c.getValue()) {
                winTeam = c.getKey();
                currentScore = c.getValue();
            }
        }
        return winTeam;
    }

    //============== orignal algo
    public String tournamentWinner3(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        String currentBestTeam = "";
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put(currentBestTeam, 0);
        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            int result = results.get(i);

            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winnerTeam = result == 1 ? homeTeam : awayTeam;

            updateScores(winnerTeam, 3, scores);
            if (scores.get(winnerTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winnerTeam;
            }
        }
        return currentBestTeam;
    }

    public void updateScores(String team, int points, HashMap<String, Integer> scores) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        }
        scores.put(team, scores.get(team) + points);
    }
}
