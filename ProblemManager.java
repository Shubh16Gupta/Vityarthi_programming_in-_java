package codevault;
import java.util.ArrayList;
import java.util.function.Predicate;
//we make the class called problemmanager
public class ProblemManager {
    private final ArrayList<Problem> problems;
    private final String username;
    public ProblemManager(String username) {
        this.username = username;
        this.problems = FileManager.loadProblems(username);
    }
    public void addProblem(String title, String topic, String difficulty) {
        int id = 1;
        for (Problem problem : problems) {
            id = Math.max(id, problem.getId() + 1);
        }
        problems.add(new Problem(id, title, topic, difficulty));
        save();
        System.out.println("\nProblem added successfully! Problem ID: " + id);
    }

    public void displayAllProblems() {
        if (problems.isEmpty()) {
            System.out.println("\nNo problems found.");
            return;
        }
        printHeader();
        for (Problem problem : problems) {
            System.out.println(problem);
        }
    }
    public void searchProblem(String keyword) {
        filter(problem -> problem.getTitle().toLowerCase().contains(keyword.toLowerCase()), "matching problem");
    }
//filterByTopic method banaya to filter the problem by topic
    public void filterByTopic(String topic) {
        filter(problem -> problem.getTopic().equalsIgnoreCase(topic), "topic");
    }
//filterByDifficulty method banaya to filter the problem by difficulty
    public void filterByDifficulty(String difficulty) {
        filter(problem -> problem.getDifficulty().equalsIgnoreCase(difficulty), "difficulty");
    }
    private void filter(Predicate<Problem> condition, String label) {
        boolean found = false;
        for (Problem problem : problems) {
            if (condition.test(problem)) {
                if (!found) {
                    printHeader();
                }
                System.out.println(problem);
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nNo " + label + " found.");
        }
    }
//markSolved method banaya to mark the problem as solved
    public void markSolved(int id) {
        Problem problem = findById(id);
        if (problem == null) {
            System.out.println("\nProblem not found.");
            return;
        }
        problem.markSolved();
        save();
        System.out.println("\nProblem marked as solved. Congratulations!");
    }
    public void markUnsolved(int id) {
        Problem problem = findById(id);
        if (problem == null) {
            System.out.println("\nProblem not found.");
            return;
        }
        problem.markUnsolved();
        save();
        System.out.println("\nProblem marked as unsolved.");
    }
    public void addAttempt(int id) {
        Problem problem = findById(id);
        if (problem == null) {
            System.out.println("\nProblem not found.");
            return;
        }
        problem.addAttempt();
        save();
        System.out.println("\nAttempt recorded. Total attempts: " + problem.getAttempts());
    }
    public Problem findById(int id) {
        for (Problem problem : problems) {
            if (problem.getId() == id) {
                return problem;
            }
        }
        return null;
    }
    public ArrayList<Problem> getProblems() {
        return problems;
    }
    public void save() {
        FileManager.saveProblems(username, problems);
    }
//printHeader method banaya to print the header of the problem list
    private void printHeader() {
        System.out.println("\nID   TITLE                     TOPIC           DIFFICULTY  STATUS     ATTEMPTS");
        System.out.println("-------------------------------------------------------------------------------");
    }
}
