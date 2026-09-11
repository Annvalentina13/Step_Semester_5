import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        // Forward pass
        // answer[i] = product of all elements to the left
        int leftProduct = 1;

        for (int i = 0; i < n; i++) {

            answer[i] = leftProduct;

            leftProduct = leftProduct * nums[i];
        }

        // Backward pass
        // Multiply by product of all elements to the right
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {

            answer[i] = answer[i] * rightProduct;

            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }
}