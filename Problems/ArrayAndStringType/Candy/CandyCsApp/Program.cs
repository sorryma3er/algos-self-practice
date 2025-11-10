public class Program
{
    public static void Main(string[] args)
    {
        int[] ratings = [1,2,87,87,87,2,1];
        Console.WriteLine(new Solution().Candy(ratings));
    }
}



public class Solution
{
    public int Candy(int[] ratings)
    {
        int[] result = new int[ratings.Length];
        Array.Fill(result, 1);

        for (int i = 1; i < ratings.Length; i++)
        {
            if (ratings[i] > ratings[i - 1]) result[i] = result[i - 1] + 1;
        }

        for (int i = ratings.Length - 2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i + 1]) result[i] = Math.Max(result[i + 1] + 1, result[i]);
        }

        int total = 0;
        foreach (var res in result)
        {
            total += res;
        }

        return total;
    }

}