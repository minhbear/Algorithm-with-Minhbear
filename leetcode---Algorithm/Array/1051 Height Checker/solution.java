public class solution {

    /**
     * Idea: We just count frequency(tần số xuất hiện) of each height
     * (We can use hashmap or int[] to build this frequency array)
     * and we use two pointer to comparision
     *      result: this pointer use to count the different 
     *      currHeight: travel the (hashmap or array depend on you use) to see differenrt frequency of two side
     * 
     * EX: Height = {1,1,4,2,1,3}
     * We use array to build array's frequency
     * We initial array with the lenght is 101. Please read carefully the description to see the reason
     * frequency = 0  1  2  3  4 ..... 101
     *             0  3  1  1  1 .....  0
     * We can travel the height 's array to build the frequency arrays, and the index of 
     * frequency's array is the height in the Height 's array, the value of each index is the frequency that height
     * appear in height's array.
     * 
     * We use loop to comparision two array, we use loop and travel each element in Heigh array
     * we start in currHeigh is 0
     * if currHeight is 0 we increasing because that heigh did not appear in height's array
     * if we find the different that currHeight != Height[i], we increasing result to 1
     * 
     * We decreasing the value of frequency[currHieght] to 1 in loop
     * 
     * we return result 
     * 
     * Time complexity: O(2n)
     */
    public static int heightChecker(int[] heights) {
       int[] frequency = new int[101];

       //Build the value to frequency's array
       for (int height : heights) {
            frequency[height]++;
       }

       int result = 0, currHeigh = 0;

       //Use loop to comparision two arrays
       for (int i = 0; i < heights.length; i++) {
            //if frequency[currHeight] == 0 is mean that heigh does not appear in heights's array
            while(frequency[currHeigh] == 0){
                currHeigh++;
            }

            //if currHeight != heights[i] increasing result to 1
            if(currHeigh != heights[i]){
                result++;
            }

            frequency[currHeigh]--;
       }

       return result;
    }
}
