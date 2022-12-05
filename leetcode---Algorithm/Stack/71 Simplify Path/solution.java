import java.util.Stack;

class Solution {
    // This solution have time complexity is O(2n)
    // Assume that when we split string we have array string that has length is n
    // We have n time to tralve all elemnt in String array to push to stack
    // And we have n time to pop element out stakc so time complexity is O(2n)

    // Idea is we split string with "/" into String array and we push String to
    // stack expect ("" and "."), if we find element
    // that is ".." and in stack is not empty so we pop the element in top and go to
    // next element in array
    // and if stack is empty we just go to next element
    public static String simplifyPath(String path) {
        String[] splitStr = path.split("/");
        Stack<String> stack = new Stack<>();

        // do not push string in (".", "", "..")
        // we use ".." when in stack have directory and pop that directory in top of
        // stack
        for (String string : splitStr) {
            if (!string.equals("") && !string.equals(".")) {
                if (string.equals("..")) {
                    if (stack.isEmpty()) {
                        continue;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(string);
                }
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }

        return result.isEmpty() ? "/" : result;
    }

    //This solution have time complexity is O(2n)
    //But when run is leetcode complie is faste that code above because we use stringbuild to append string
    //and this is faster when we concate string in normal way
    public String simplifyPath2(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String p[] = path.split("/");

        for (int i = 0; i < p.length; i++) {
            if (!s.isEmpty() && p[i].equals("..")) {
                s.pop();
            }
            if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")) {
                s.push(p[i]);
            }
        }
        if (s.isEmpty())
            return "/";
        while (!s.isEmpty()) {
            res.insert(0, s.pop()).insert(0, "/");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../ab/bc//../ab"));
    }
}