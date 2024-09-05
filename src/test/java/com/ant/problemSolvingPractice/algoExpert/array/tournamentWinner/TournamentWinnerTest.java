package com.ant.problemSolvingPractice.algoExpert.array.tournamentWinner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TournamentWinnerTest {
    @Test
    public void TestCase1() {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        String expected = "Python";
        var actual = new TournamentWinner().tournamentWinner(competitions, results);
        System.out.println("===" + expected);
        assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();

        // Add each competition to the list
        competitions.add(new ArrayList<String>() {{
            add("HTML");
            add("Java");
        }});
        competitions.add(new ArrayList<String>() {{
            add("Java");
            add("Python");
        }});
        competitions.add(new ArrayList<String>() {{
            add("Python");
            add("HTML");
        }});
        competitions.add(new ArrayList<String>() {{
            add("C#");
            add("Python");
        }});
        competitions.add(new ArrayList<String>() {{
            add("Java");
            add("C#");
        }});
        competitions.add(new ArrayList<String>() {{
            add("C#");
            add("HTML");
        }});
        competitions.add(new ArrayList<String>() {{
            add("SQL");
            add("C#");
        }});
        competitions.add(new ArrayList<String>() {{
            add("HTML");
            add("SQL");
        }});
        competitions.add(new ArrayList<String>() {{
            add("SQL");
            add("Python");
        }});
        competitions.add(new ArrayList<String>() {{
            add("SQL");add("Java");
        }});
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 1, 0, 1, 1));
        String expected = "SQL";
        var actual = new TournamentWinner().tournamentWinner(competitions, results);
        System.out.println("===" + actual);
        assertTrue(expected == actual);
    }
}