import java.util.Arrays;
import java.util.List;

/**
 * Idea: We create 3 list which each list contain all character in row of keyboard.
 *       Then we check fist character of each word in String Array to find the row.
 *       We compare all character of that word are contain by the list of that row
 *      
 *      if  is not return false else return true and add that word to the array that need to return
 *          
 *      
 */

class _500_Keyboard_Row{
    
    //List of each character of row in keyboard
    static List<Character> row1 = Arrays.asList('q','w','e','r','t','y','u','i','o','p');
    static List<Character> row2 = Arrays.asList('a','s','d','f','g','h','j','k','l');
    static List<Character> row3 = Arrays.asList('z','x','c','v','b','n','m');
    
    public static String[] findWords(String[] words) {
        String[] result = new String[words.length];
        int index = 0;
        for(int i = 0; i<words.length; i++){
            if(check(words[i]) == true){
                result[index++] = words[i];
            }
        }

       
        return Arrays.copyOf(result, index);
    }

    //Function to check all character of word are in row.
    public static boolean check(String word){
        char firstChar = word.toLowerCase().charAt(0);
        List row = checkrow(firstChar);
        for (int i = 0; i < word.length(); i++) {
            if(row.contains(word.toLowerCase().charAt(i)) == false)
                return false;
        }

        return true;
    }

    //Function to check the row that suitable for the first character of word
    public static List checkrow(char c){
        if(row1.contains(c) == true)
            return row1;
        if(row2.contains(c) == true)
            return row2;
        
        return row3;
    }

    public static void main(String[] args) {
       String[] check = new String[] {"Hello","Alaska","Dad","Peace"};
       String[] result = findWords(check);
       System.out.println("done");

    }
}

