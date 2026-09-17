package codevault;
// class used to validate the input given by the user
public class InputValidator {
// array banaya ki kitna difficulty aur topic hai
    public static final String[] TOPICS = {"Array", "String", "Linked List", "Stack", "Queue", "Tree", "Graph", "DP", "Sorting", "Searching"};
    public static final String[] DIFFICULTIES = {"Easy", "Medium", "Hard"};
// method banaya to check the difficulty is valid or not
    public static boolean isValidDifficulty(String difficulty) {
// check if the difficulty is one of the valid options
        return difficulty.equalsIgnoreCase("Easy")
                || difficulty.equalsIgnoreCase("Medium")
                || difficulty.equalsIgnoreCase("Hard");
    }
// method banaya to check the topic is valid or not
    public static boolean isValidTopic(String topic) {

        for (String t : TOPICS) {
            if (t.equalsIgnoreCase(topic)) {
                return true;
            }
        }

        return false;
    }
}