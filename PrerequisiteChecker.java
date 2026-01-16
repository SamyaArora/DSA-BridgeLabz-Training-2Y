import java.util.HashSet;
public class PrerequisiteChecker {

    // -------------------------------
    // Implementation A: Nested Loop
    // Time: O(m * n), Space: O(1)
    // -------------------------------
    public static boolean checkNestedLoop(int[] completedCourses, int[] prerequisites) {

        for (int i = 0; i < prerequisites.length; i++) {
            boolean found = false;

            for (int j = 0; j < completedCourses.length; j++) {
                if (prerequisites[i] == completedCourses[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }
        return true;
    }

    // -------------------------------
    // Implementation B: Hash Set
    // Time: O(n + m), Space: O(n)
    // -------------------------------
    public static boolean checkUsingHashSet(int[] completedCourses, int[] prerequisites) {

        HashSet<Integer> completedSet = new HashSet<>();

        for (int course : completedCourses) {
            completedSet.add(course);
        }

        for (int prereq : prerequisites) {
            if (!completedSet.contains(prereq)) {
                return false;
            }
        }
        return true;
    }

    // -------------------------------
    // Hybrid Approach
    // -------------------------------
    public static boolean checkHybrid(int[] completedCourses, int[] prerequisites) {

        if (prerequisites.length <= 2) {
            return checkNestedLoop(completedCourses, prerequisites);
        } else {
            return checkUsingHashSet(completedCourses, prerequisites);
        }
    }

    // -------------------------------
    // MAIN METHOD (Test Case)
    // -------------------------------
    public static void main(String[] args) {

        // Completed courses by student
        int[] completedCourses = {101, 102, 103, 104, 105, 106};

        // Prerequisites for advanced course
        int[] prerequisites = {102, 104, 106};

        System.out.println("Nested Loop Result: "
                + checkNestedLoop(completedCourses, prerequisites));

        System.out.println("HashSet Result: "
                + checkUsingHashSet(completedCourses, prerequisites));

        System.out.println("Hybrid Result: "
                + checkHybrid(completedCourses, prerequisites));
    }
}
