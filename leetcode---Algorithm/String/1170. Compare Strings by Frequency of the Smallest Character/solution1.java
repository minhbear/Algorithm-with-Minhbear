import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class solution1{
    /**
     * Difficult : MEDIUM
     * 
     * The idea for this solution is, I use hashMap to store character with the value if frequency in String and 
     * that sort hashMap by the key to pick smallest character with the value of it.
     * 
     * after that I create two array integer proper with two array string queries and words
     * the first array is store frequqency of smallest character of each word in queries array
     * and do that action for the second array. 
     * We sort second array and modify the binary search to find the length of value that each value is greater than f(queries[i])
     * 
     * this solution is run with 25ms is not good because we have complex method to find the smallest character and the freaquency 
     * the better method is in solution.java you can read to understand that 
     */
    
    //sort hashmap by the key to find smallest character appear in string
    static char sortByKey(Map<Character, Integer> x){
        ArrayList<Character> sortedKeys = new ArrayList<Character>(x.keySet());
        Collections.sort(sortedKeys);

        return sortedKeys.get(0);
    }

    //use hash map to store charater with the frequency in string
    static int frequencySmallestCharacter(String x){
        Map<Character, Integer> htable = new HashMap<>();
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if(htable.containsKey(c)){
                htable.put(c, htable.get(c) + 1);
            }
            else{
                htable.put(c, 1);
            }
        }

        char smallestChar = sortByKey(htable);
        return htable.get(smallestChar);
    }


    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] numberFrequencyQuerie = new int[queries.length];
        int[] numberFrequencyWord = new int[words.length];

        for (int i = 0; i < queries.length; i++) {
            numberFrequencyQuerie[i] = frequencySmallestCharacter(queries[i]);
        }

        for (int i = 0; i < words.length; i++) {
            numberFrequencyWord[i] = frequencySmallestCharacter(words[i]);
        }

        Arrays.sort(numberFrequencyWord);
        //use binary search to find how many word that f(queries[i]) < f(word)
        for (int i = 0; i < numberFrequencyQuerie.length; i++) {
            int lowerBound = 0;
            int upperBound = words.length - 1;

            //find the length of the number in array that less than f(queries[i])
            while(lowerBound <= upperBound){
                int mid = lowerBound + (upperBound - lowerBound) / 2;
                if(numberFrequencyQuerie[i] < numberFrequencyWord[mid]){
                    upperBound = mid - 1;
                }
                else lowerBound = mid + 1;
            }
            numberFrequencyQuerie[i] = numberFrequencyWord.length - lowerBound;
        }


        return numberFrequencyQuerie;
    }

    public static void main(String[] args) {
        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};
        int[] result = numSmallerByFrequency(queries, words); 
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}