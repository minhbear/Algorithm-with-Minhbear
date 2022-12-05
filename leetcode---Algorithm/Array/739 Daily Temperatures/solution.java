import java.util.Stack;

//medium solution
//The idea it we push the next day into the stack and use it that a storage to know what is the next day is wammer of this current day

public class solution {

    //this solution have time complexity O(n^2)
    //Idea is in each loop we will loop to find the next day that wammer, if we find is so size of stack is the day we need to wait
    //But this is not good for the big array because we need to loop to much in each loop.
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> tempStack = new Stack<Integer>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < answer.length; i++) {
            int j = i+1;
            while(j<answer.length){
                tempStack.push(temperatures[j]);
                if(tempStack.peek() > temperatures[i]){
                    answer[i] = tempStack.size();
                    tempStack.clear();
                    break;
                }
                j++;
            }
            if(!tempStack.isEmpty()){
                answer[i] = 0;
                tempStack.clear();
            }
        }

        return answer;
    }

    //this solution have time complexity is O(n)
    //Idea is about we use stack to keep the index of temperature, each loop we will push index into array 
    //and if we find the day that index of top stack of temperature smaller so we will have the day we wait is index of current day - stack.pop()
    public static int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> tempStack = new Stack<Integer>();

        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temperatures[currDay];
            while(!tempStack.isEmpty() && temperatures[tempStack.peek()] < currentTemp){
                int preDay = tempStack.pop();
                answer[preDay] = currDay - preDay;
            }

            tempStack.push(currDay);
        }

        return answer;

    }

    public static void main(String[] args) {
        // int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] temperatures = {55,38,53,81,61,93,97,32,43,78};
        int[] answer = dailyTemperatures2(temperatures);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
