package codevault;
public class ProgressTracker {
	public static long solvedCount(ProblemManager manager) {
		return manager.getProblems().stream().filter(Problem::isSolved).count();
	}

	public static int totalAttempts(ProblemManager manager) {
		return manager.getProblems().stream().mapToInt(Problem::getAttempts).sum();
	}
//display method banaya to display the progress of the user
	public static void display(ProblemManager manager) {
		int total = manager.getProblems().size();
		long solved = solvedCount(manager);
		double completion = total == 0 ? 0 : solved * 100.0 / total;
		System.out.println("\n========== MY DSA PROGRESS ==========");
		System.out.println("Total Problems       : " + total);
		System.out.println("Solved Problems      : " + solved);
		System.out.println("Unsolved Problems    : " + (total - solved));
		System.out.printf("Completion Rate      : %.1f%%%n", completion);
		System.out.println("Total Attempts       : " + totalAttempts(manager));
		for (String difficulty : InputValidator.DIFFICULTIES) {
			long count = manager.getProblems().stream()
					.filter(problem -> problem.isSolved() && problem.getDifficulty().equalsIgnoreCase(difficulty))
					.count();
			System.out.println("Solved " + difficulty + "          : " + count);
		}
		System.out.println("=====================================");
	}
}
