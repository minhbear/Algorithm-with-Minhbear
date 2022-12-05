class KMP{
    //Build temporary Array for the pattern
    static int[] computeTemporaryArray(char[] pattern){
        int[] temporaryArray = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length;) {
            if(pattern[i] == pattern[index]){
                temporaryArray[i] = index + 1;
                i++;
                index++;
            }else{
                if(index != 0){
                    index = temporaryArray[index - 1];
                }else{
                    temporaryArray[i] = 0;
                    i++;
                }
            }
        }

        return temporaryArray;
    }

    //KMP algorithm
    static boolean KMPAlgorithm(char[] text, char[] pattern){
        int i=0,j=0;
        int[] lps = computeTemporaryArray(pattern); //Build temporary array
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }

        if(j == pattern.length)
            return true;
        
        return false;
    }

    public static void main(String[] args) {
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        boolean result = KMPAlgorithm(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
    }
}