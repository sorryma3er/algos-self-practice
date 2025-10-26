using System;

public class Solution
{
    public int LengthOfLastWord(string s)
    {
        string[] words = s.Split(' ', StringSplitOptions.RemoveEmptyEntries); // remove the "" empty entry
        return words.Length == 0 ? 0 : words[^1].Length;
    }

    public static void Main(string[] args)
    {
        string str = "   fly me   to   the moon  ";
        int sth = new Solution().LengthOfLastWord(str);
        Console.WriteLine(sth);
    }
}

