package codevault;
// Main class for the CodeVault application
import java.util.Scanner;
//created the main class and added kiya main method ko 
public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final UserManager userManager = new UserManager();
//main method banaya to run the application
	public static void main(String[] args) {
		System.out.println("Loading CodeVault data...");
		boolean running = true;
		while (running) {
			System.out.println("\n========================================");
			System.out.println("              CODEVAULT");
			System.out.println("          Track. Solve. Improve.");
			System.out.println("========================================");
			System.out.println("1. Register\n2. Login\n3. Exit");
			switch (readInt("Enter choice: ")) {
				case 1: register(); break;
				case 2: login(); break;
				case 3: running = false; break;
				default: System.out.println("Invalid choice.");
			}
		}
		System.out.println("\nSaving your progress...\nThank you for using CodeVault.");
	}
//register method banaya to register the user
	private static void register() {
		String name = readRequired("Enter name: ");
		String username = readRequired("Enter username: ");
		String password = readRequired("Enter password (minimum 4 characters): ");
		if (password.length() < 4) {
			System.out.println("Password must contain at least 4 characters.");
		} else if (userManager.register(name, username, password)) {
			System.out.println("Registration successful!");
		} else {
			System.out.println("Username already exists.");
		}
	}

	private static void login() {
		String username = readRequired("Username: ");
		String password = readRequired("Password: ");
		User user = userManager.login(username, password);
		if (user == null) {
			System.out.println("Invalid username or password.");
			return;
		}
		dashboard(user);
	}
//dashboard method banaya to show the user dashboard
	private static void dashboard(User user) {
		ProblemManager manager = new ProblemManager(user.getUsername());
		boolean loggedIn = true;
		while (loggedIn) {
			System.out.println("\n========================================");
			System.out.println("Welcome, " + user.getName() + "!");
			System.out.println("1. Add Problem\n2. View All Problems\n3. Search Problem");
			System.out.println("4. Filter by Topic\n5. Filter by Difficulty\n6. Mark Problem Solved");
			System.out.println("7. Record Attempt\n8. Mark Problem Unsolved\n9. View Progress");
			System.out.println("10. View Statistics\n11. Get Recommendation\n12. Profile\n13. Logout");
			switch (readInt("Enter choice: ")) {
				case 1: addProblem(manager); break;
				case 2: manager.displayAllProblems(); break;
				case 3: manager.searchProblem(readRequired("Search keyword: ")); break;
				case 4: manager.filterByTopic(readTopic()); break;
				case 5: manager.filterByDifficulty(readDifficulty()); break;
				case 6: manager.markSolved(readInt("Problem ID: ")); break;
				case 7: manager.addAttempt(readInt("Problem ID: ")); break;
				case 8: manager.markUnsolved(readInt("Problem ID: ")); break;
				case 9: ProgressTracker.display(manager); break;
				case 10: Statistics.display(manager); break;
				case 11: RecommendationEngine.recommend(manager); break;
				case 12: profile(user); break;
				case 13: loggedIn = false; break;
				default: System.out.println("Invalid choice.");
			}
		}
	}
//addProblem method banaya to add the problem
	private static void addProblem(ProblemManager manager) {
		String title = readRequired("Problem title: ");
		String topic = readTopic();
		String difficulty = readDifficulty();
		manager.addProblem(title, topic, difficulty);
	}
//readTopic method banaya to read the topic from the user
	private static String readTopic() {
		while (true) {
			System.out.println("Topics: " + String.join(", ", InputValidator.TOPICS));
			String topic = readRequired("Topic: ");
			if (InputValidator.isValidTopic(topic)) {
				for (String valid : InputValidator.TOPICS) {
					if (valid.equalsIgnoreCase(topic)) return valid;
				}
			}
			System.out.println("Invalid topic.");
		}
	}
//readDifficulty method banaya to read the difficulty from the user
	private static String readDifficulty() {
		while (true) {
			String difficulty = readRequired("Difficulty (Easy/Medium/Hard): ");
			if (InputValidator.isValidDifficulty(difficulty)) {
				for (String valid : InputValidator.DIFFICULTIES) {
					if (valid.equalsIgnoreCase(difficulty)) return valid;
				}
			}
			System.out.println("Invalid difficulty.");
		}
	}
//profile method banaya to show the user profile
	private static void profile(User user) {
		System.out.println("\nName: " + user.getName());
		System.out.println("Username: " + user.getUsername());
		if (readYesNo("Change password? (y/n): ")) {
			String current = readRequired("Current password: ");
			String next = readRequired("New password (minimum 4 characters): ");
			if (next.length() >= 4 && userManager.changePassword(user, current, next)) {
				System.out.println("Password changed successfully.");
			} else {
				System.out.println("Password change failed.");
			}
		}
	}
	private static int readInt(String prompt) {
		while (true) {
			try {
				return Integer.parseInt(readRequired(prompt));
			} catch (NumberFormatException exception) {
				System.out.println("Please enter a valid number.");
			}
		}
	}
	private static String readRequired(String prompt) {
		while (true) {
			System.out.print(prompt);
			String value = scanner.nextLine().trim();
			if (!value.isEmpty()) return value;
			System.out.println("Input cannot be empty.");
		}
	}
//readYesNo method banaya to read the yes or no from the user
	private static boolean readYesNo(String prompt) {
		while (true) {
			String answer = readRequired(prompt);
			if (answer.equalsIgnoreCase("y")) return true;
			if (answer.equalsIgnoreCase("n")) return false;
			System.out.println("Please enter y or n.");
		}
	}
}
