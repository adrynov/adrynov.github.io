namespace CSharp;

public class SimpleLogic
{
    /**
     * Find the maximum number.
     */
    public static int findMaximum(int a, int b, int c)
    {
        var max = a;

        if (b > max) max = b;
        if (c > max) max = c;

        return max;
    }
}