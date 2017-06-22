package main;

/**
 * Created by Administrator on 2017/6/22.
 */
public class Hangman {
    private String solution;
    private String used = "AEIOU";
    private String problem = "A___E";
    private int triesTime = 12;
    public void start(String solution) {
        this.solution = solution;
    }
    public int tries() {
        return triesTime;
    }
    public int length() {
        return solution.length();
    }
    public String used() {
        return used;
    }
    public String problem() {
        return problem;
    }
    public boolean tryChar(char inputChar) {
        boolean matched = false;
        char[] chars = solution.toCharArray();
        char[] problemChars = problem.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == inputChar) {
                problemChars[i] = inputChar;
                matched = true;
            }
        }
        problem = String.valueOf(problemChars);
        if(!matched) {
            triesTime--;
        }
        used += inputChar;
        return matched;
    }
    public boolean hasWon() {
        return !problem.contains("_");
    }
    public boolean gameOver() {
        return triesTime <= 0;

    }

}
