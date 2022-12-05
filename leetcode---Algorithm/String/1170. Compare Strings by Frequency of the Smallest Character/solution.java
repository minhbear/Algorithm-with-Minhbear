import java.util.Arrays;

class Solution {
    static public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        
        for(int i = 0; i < queries.length; i++){
            q[i] = f(queries[i]);
        }
        for(int i = 0; i < words.length; i++){
            w[i] = f(words[i]);
        }
        
        Arrays.sort(w);
        for(int i = 0; i < q.length; i++){
            int lowerBound = 0;
            int upperBound = words.length - 1;
            while(lowerBound <= upperBound){
                int mid = lowerBound + (upperBound - lowerBound) / 2;
                if(q[i] < w[mid]){
                    upperBound = mid - 1;
                }
                else lowerBound = mid + 1;
            }
            q[i] = w.length - lowerBound;
        }
        return q;
    }
    
    //best solution to find  frequqency of smallest character in string 
    static public int f(String s){
        char[] c = s.toCharArray();
        int index = 0;
        //find index of smallest character in string
        for(int i = 0; i < c.length; i++){
            if(c[i] < c[index]){
                index = i;
            }
        }
        char ch = s.charAt(index);
        int count = 0;
        for(char x : c){
            if(ch == x) count++;
        }
        return count;
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