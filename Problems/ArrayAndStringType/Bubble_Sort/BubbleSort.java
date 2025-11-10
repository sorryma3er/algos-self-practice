package ArrayAndStringType.Bubble_Sort;

public class BubbleSort {
    public static int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++){
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[][] cases = {
            {64, 34, 25, 12, 22, 11, 90},
            {5, 1, 4, 2, 8},
            {1, 2, 3, 4}, // already sorted
            {4, 3, 2, 1}, // reverse
            {}, // empty
            {7} // single
        };

        for (int[] arr : cases) {
            int[] before = arr.clone();
            int[] after = bubbleSort(before);

            System.out.print("before: ");
            printArray(before);
            System.out.print(" -> after: ");
            printArray(after);
            System.out.println();
        }
    }
}
