import java.util.Arrays;
import java.util.HashSet;

public class UsernameSearchDemo {
	// Algorithm A: Linear Search
    public static boolean linearSearch(String[] userList, String target) {
        for (int i = 0; i < userList.length; i++) {
            if (userList[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    // Algorithm B: Binary Search (list must be sorted)
    public static boolean binarySearch(String[] sortedUserList, String target) {
        int left = 0;
        int right = sortedUserList.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (sortedUserList[mid].equals(target)) {
                return true;
            } else if (sortedUserList[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // Algorithm C: Hash Table Lookup
    public static boolean hashSearch(HashSet<String> userSet, String target) {
        return userSet.contains(target);
    }

    public static void main(String[] args) {

        // Sample data (small demo)
        String[] users = {
                "alice", "bob", "charlie", "david", "emma",
                "frank", "george", "harry", "irene", "jack"
        };

        String targetUsername = "emma";

        // -------- Linear Search --------
        boolean foundLinear = linearSearch(users, targetUsername);
        System.out.println("Linear Search: " + foundLinear);

        // -------- Binary Search --------
        Arrays.sort(users); // MUST sort before binary search
        boolean foundBinary = binarySearch(users, targetUsername);
        System.out.println("Binary Search: " + foundBinary);

        // -------- Hash Table Search --------
        HashSet<String> userSet = new HashSet<>();
        for (String user : users) {
            userSet.add(user);
        }

        boolean foundHash = hashSearch(userSet, targetUsername);
        System.out.println("Hash Table Search: " + foundHash);
    }

}
