import java.util.HashMap;
import java.util.Map;

public class solution {
    //Use Map to keep track the n step it have number way to go via 1 step and 2 step
    //We see that n = 2 we have 1+1 and 2 ways
    //So n =3 will be n = 2 + 1 step it means that (1+1)+1 and (2)+1 and 1+(2) ways to go  
    //Time Complexity O(n) Space Complexity O(n)
    public static int climbStairs(int n) {
        Map<Integer, Integer> climb = new HashMap<>();   
        climb.put(1, 1);
        climb.put(2, 2);
        return calculateClimb(n, climb);
    }

    private static int calculateClimb(int step, Map<Integer, Integer> climb){
        if(climb.containsKey(step)){
            return climb.get(step);
        }

        climb.put(step, calculateClimb(step-1, climb) + calculateClimb(step-2, climb));
        return climb.get(step);
    }
}
