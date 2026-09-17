package codevault;
// class used to recommend a problem to the user based on their weakest topic
public class RecommendationEngine {
	public static void recommend(ProblemManager manager) {
		String weakest = Statistics.weakestTopic(manager);
		Problem recommendation = null;
		for (Problem problem : manager.getProblems()) {
			if (!problem.isSolved() && (weakest == null || problem.getTopic().equalsIgnoreCase(weakest))) {
				recommendation = problem;
				break;
			}
		}
		if (recommendation == null) {
			System.out.println("\nNo unsolved problems available. Add more problems to keep practicing!");
			return;
		}
		System.out.println("\n========== DAILY RECOMMENDATION ==========");
		System.out.println("Weakest Topic: " + (weakest == null ? recommendation.getTopic() : weakest));
		System.out.println("Problem ID   : " + recommendation.getId());
		System.out.println("Title        : " + recommendation.getTitle());
		System.out.println("Topic        : " + recommendation.getTopic());
		System.out.println("Difficulty   : " + recommendation.getDifficulty());
		System.out.println("Reason       : Practice an unsolved problem in this topic.");
		System.out.println("==========================================");
	}
}
