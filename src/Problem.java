package codevault;

import java.io.Serializable;
//we make the class called problem
public class Problem implements Serializable {
    private int id;
    private String title;
    private String topic;
    private String difficulty;
    private boolean solved;
    private int attempts;
    public Problem(int id, String title, String topic, String difficulty) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.difficulty = difficulty;
        this.solved = false;
        this.attempts = 0;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getTopic() {
        return topic;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public boolean isSolved() {
        return solved;
    }
    public int getAttempts() {
        return attempts;
    }
    public void markSolved() {
        solved = true;
    }
    public void markUnsolved() {
        solved = false;
    }
    public void addAttempt() {
        attempts++;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
//toString method banaya to print the problem details
    @Override
    public String toString() {
        String status = solved ? "Solved" : "Unsolved";
        return String.format(
                "%-4d %-25s %-15s %-10s %-10s Attempts: %d",
                id,
                title,
                topic,
                difficulty,
                status,
                attempts
        );
    }
}