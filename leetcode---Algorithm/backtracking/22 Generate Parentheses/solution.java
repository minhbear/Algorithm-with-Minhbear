import java.util.ArrayList;
import java.util.List;

public class solution {
    //idea: We use backtracking technique to solve this problem
    //each recursion we will keep track the open parathense and close parathense 
    //For number of open parathense haev created we will have proper close parathense so that we can keep the parathense is valid with description

    //to understand more you can write each step in your paper or draw the tree at each step to keep track the result

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, n, 0, 0, "");

        return result;
    }

    private static void backtracking(List<String> result, int maxCount, int LimitedOpen, int LimitedClose, String s ){
        if((LimitedOpen == maxCount) && (LimitedClose == maxCount)){
            result.add(s);
            return;
        }

        if(LimitedOpen < maxCount){
            backtracking(result, maxCount, LimitedOpen+1, LimitedClose, s + "(");
        }

        //with the number of open Parathense we have proper close parathense so the condition is LimitedClose muse be less than LimitedOpen
        if(LimitedClose < LimitedOpen){
            backtracking(result, maxCount, LimitedOpen, LimitedClose+1, s + ")");
        }
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        for (String string : result) {
            System.out.print(string + ", ");
        }
        //expected output: ["((()))","(()())","(())()","()(())","()()()"]
    }
}
