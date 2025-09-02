using System;

class Program
{
    public static int[] BubbleSort(int[] nums)
    {
        int n = nums.Length;
        for (int i = nums.Length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[j] > nums[j + 1])
                {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static void PrintArray(int[] arr)
    {
        Console.Write("[");
        for (int i = 0; i < arr.Length; i++)
        {
            Console.Write(arr[i]);
            if (i != arr.Length - 1)
                Console.Write(", ");
        }
        Console.Write("]");
    }

    public static void Main(string[] args)
    {
        int[][] cases = [
            [64, 34, 25, 12, 22, 11, 90],
            [5, 1, 4, 2, 8],
            [1, 2, 3, 4], // already sorted
            [4, 3, 2, 1], // reverse
            [], // empty
            [7] // single
        ];

        foreach (var arr in cases)
        {
            Console.Write("before: ");
            PrintArray(arr);
            int[] after = BubbleSort(arr);
            Console.Write(" -> after: ");
            PrintArray(after);
            Console.WriteLine();
        }
    }
}