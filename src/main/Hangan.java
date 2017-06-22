package main;

/**
 * Created by Administrator on 2017/6/22.
 */
public class Hangan {
    private String solution;
    private String problem;
    private int triesTime = 12;
    public String generateSolution(){
        for (int i =  0; i < solution.length(); i++) {
            problem += "_";
        }
        return problem;
    }
    public void start(String solution) {
        this.solution = solution;
        generateSolution();
    }
    public int tries() {
        return triesTime;
    }
    public int length() {
        return solution.length();
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
        return matched;
    }
    public boolean hasWon() {
        return !problem.contains("_");
    }
    public boolean gameOver() {
        return triesTime <= 0;

    }

}
