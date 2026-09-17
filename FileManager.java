package codevault;
//create the package 
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//we make the class called filemanger 
public class FileManager {

    private static final String USERS_FILE = "users.dat";
    private static final String PROBLEMS_FILE = "problems.dat";

    public static void saveUsers(ArrayList<User> users) {
        saveObject(USERS_FILE, users);
    }
//creatred the array 
    public static ArrayList<User> loadUsers() {
        Object value = loadObject(USERS_FILE);
        if (value instanceof ArrayList<?>) {
            ArrayList<User> users = new ArrayList<>();
            for (Object item : (ArrayList<?>) value) {
                if (item instanceof User) {
                    users.add((User) item);
                }
            }
            return users;
        }
        return new ArrayList<>();
    }
//method banaya to save the probelem 
    public static void saveProblems(String username, ArrayList<Problem> problems) {
        Map<String, ArrayList<Problem>> allProblems = loadAllProblems();
        allProblems.put(username.toLowerCase(), problems);
        saveObject(PROBLEMS_FILE, allProblems);
    }
//method banaya to load the problem
    public static ArrayList<Problem> loadProblems(String username) {
        ArrayList<Problem> problems = loadAllProblems().get(username.toLowerCase());
        return problems == null ? new ArrayList<Problem>() : problems;
    }
//method banaya to load all the problem
    @SuppressWarnings("unchecked")
    private static Map<String, ArrayList<Problem>> loadAllProblems() {
        Object value = loadObject(PROBLEMS_FILE);
        if (value instanceof Map<?, ?>) {
            return (Map<String, ArrayList<Problem>>) value;
        }
        return new HashMap<>();
    }
//method banaya to save the object
    private static void saveObject(String fileName, Object value) {
        File parent = new File(fileName).getAbsoluteFile().getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
// try catch block use kiya to handle the exception
        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(fileName))) {
            output.writeObject(value);

        } catch (IOException e) {
            System.out.println("Unable to save CodeVault data: " + e.getMessage());
        }
    }
//method banaya to load the object
    private static Object loadObject(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            return null;
        }
// try catch block use kiya to handle the exception
        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(file))) {
            return input.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Unable to load " + fileName + ". Starting with empty data.");
            return null;
        }
    }
}