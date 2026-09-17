package codevault;
import java.util.LinkedHashMap;
import java.util.Map;
//we make the class called statistics
public class Statistics {
	public static void display(ProblemManager manager) {
		int total = manager.getProblems().size();
		long solved = ProgressTracker.solvedCount(manager);
		double average = total == 0 ? 0 : (double) ProgressTracker.totalAttempts(manager) / total;
		Map<String, int[]> topicCounts = topicCounts(manager);
		String strongest = "N/A";
		String weakest = "N/A";
		for (Map.Entry<String, int[]> entry : topicCounts.entrySet()) {
			if (strongest.equals("N/A") || entry.getValue()[1] > topicCounts.get(strongest)[1]) {
				strongest = entry.getKey();
			}
			if (weakest.equals("N/A") || entry.getValue()[1] < topicCounts.get(weakest)[1]) {
				weakest = entry.getKey();
			}
		}
		System.out.println("\n============= STATISTICS =============");
		System.out.println("Total Problems       : " + total);
		System.out.println("Solved               : " + solved);
		System.out.println("Unsolved             : " + (total - solved));
		System.out.printf("Success Rate         : %.1f%%%n", total == 0 ? 0 : solved * 100.0 / total);
		System.out.printf("Average Attempts     : %.2f%n", average);
		System.out.println("Strongest Topic      : " + strongest);
		System.out.println("Weakest Topic        : " + weakest);
		System.out.println("\nTopic              Total  Solved");
		for (Map.Entry<String, int[]> entry : topicCounts.entrySet()) {
			System.out.printf("%-18s %-6d %d%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
		}
		System.out.println("=======================================");
	}
//topicCounts method banaya to count the total and solved problems for each topic
	public static Map<String, int[]> topicCounts(ProblemManager manager) {
		Map<String, int[]> result = new LinkedHashMap<>();
		for (Problem problem : manager.getProblems()) {
			int[] counts = result.computeIfAbsent(problem.getTopic(), key -> new int[2]);
			counts[0]++;
			if (problem.isSolved()) {
				counts[1]++;
			}
		}
		return result;
	}
	public static String weakestTopic(ProblemManager manager) {
		String weakest = null;
		for (Map.Entry<String, int[]> entry : topicCounts(manager).entrySet()) {
			if (weakest == null || entry.getValue()[1] < topicCounts(manager).get(weakest)[1]) {
				weakest = entry.getKey();
			}
		}
		return weakest;
	}
}
