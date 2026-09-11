import java.util.HashMap;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixFrequency =
                new HashMap<>();

        // Empty prefix
        prefixFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            int requiredSum = currentSum - k;

            if (prefixFrequency.containsKey(requiredSum)) {

                count += prefixFrequency.get(requiredSum);
            }

            prefixFrequency.put(
                    currentSum,
                    prefixFrequency.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println("Number of Subarrays: " + result);
    }
}