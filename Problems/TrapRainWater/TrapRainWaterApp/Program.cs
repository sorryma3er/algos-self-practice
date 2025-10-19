public class Solution
{
    public int Trap(int[] height)
    {
        int start = 0;
        int end = 0;
        int total = 0;
        for (int i = 0; i < height.Length; i++)
        {
            if (i < end) continue;

            if (height[i] > 0)
            {
                start = i;

                for (int j = start + 1; j < height.Length; j++)
                {
                    if (height[j] >= height[i])
                    {
                        end = j;
                        break;
                    }
                }
            }

            if (end != 0)
            {
                int treashold = height[start] >= height[end] ? height[end] : height[start];
                for (int j = start + 1; j < end; j++)
                {
                    if (height[j] < treashold)
                    {
                        total += treashold - height[j];
                    }
                }
            }
        }
        return total;
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        int[] test = [4,2,0,3,2,5];
        Console.WriteLine(new Solution().Trap(test));
    }
}