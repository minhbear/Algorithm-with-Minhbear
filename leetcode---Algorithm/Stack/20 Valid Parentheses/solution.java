import java.util.Stack;

public class solution {
    public static boolean isValid(String s) {
        Stack<Character> KeepParentheses = new Stack<>();

        //Loop string s
        for (int i = 0; i < s.length(); i++) {
            //find open parentheses push in to stack
            if(s.charAt(i) == '(' || s.charAt(i) ==     '[' || s.charAt(i) == '{'){
                KeepParentheses.push(s.charAt(i));
            }else{
                //check close parenthese is proper with the top element in stack
                //if not return false
                if(KeepParentheses.empty()) return false;

                if(s.charAt(i) == ')' && KeepParentheses.pop() != '(') return false;
                if(s.charAt(i) == ']' && KeepParentheses.pop() != '[') return false;
                if(s.charAt(i) == '}' && KeepParentheses.pop() != '{') return false;
            }
        }

        return KeepParentheses.empty();
    }

    public static void main(String[] args) {
        // String s = "()[]{}";
        // String s = "()";
        String s = "(]";
        System.out.println(isValid(s));
    }
}
