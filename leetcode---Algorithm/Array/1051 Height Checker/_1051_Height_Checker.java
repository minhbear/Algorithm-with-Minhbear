import java.util.Arrays;

/**
 * Idea: The simple way is just sort the array of height and we use 
 * loop to compare each index in two arrays, if we see the different value
 * increasing count and then return
 */

//NOTE: We can not use simple sort because when we create an array that same another array
//EX: int[] expected = heights 
//That is we just define an reference that point to array Height. And if we sort array Expected
//We also sort Height !!!! :(((. Becareful that

class _1051_Height_Checker{
    public static int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < expected.length; i++) {
            if(expected[i] != heights[i])
                count++;
        }

        return count;
    }


    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }
}