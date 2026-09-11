import java.util.*;

public class ThreeSum {

    static int[][] threeSum(int[] nums) {

        Arrays.sort(nums);

        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Since array is sorted, if nums[i] > 0,
            // three numbers cannot add up to zero.
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(new int[]{
                            nums[i],
                            nums[left],
                            nums[right]
                    });

                    left++;
                    right--;

                    // Skip duplicate left values
                    while (left < right &&
                            nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right &&
                            nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    left++;

                } else {

                    right--;
                }
            }
        }

        // Convert ArrayList<int[]> to int[][]
        int[][] answer = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        int[][] result = threeSum(nums);

        System.out.println(Arrays.deepToString(result));
    }
}