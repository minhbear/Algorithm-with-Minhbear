import java.util.ArrayList;
import java.util.List;

class solution{
    //Idea we use backtracking technique to use this problem
    //To understand more make sure you understand of recursion and brute force(duyệt trâu)
    //Wirte each step in you paper to understand what we are doing

    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }

        String[] dict = {"","","abc","def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtracking(result, digits.toCharArray(), "", dict);

        return result;
    }

    private static void backtracking(List<String> result, char[] digits, String s, String[] dict){
        //base case
        if(s.length() == digits.length){
            //posibile combine letter has created
            result.add(s);
            return;
        }

        int digit = digits[s.length()] - '0';// '2' - '0' = 2
        for (char letter : dict[digit].toCharArray()) {
            backtracking(result, digits, s + Character.toString(letter), dict);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        for (String string : result) {
            System.out.print(string + ", ");
        }
        //expected output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }

    
}