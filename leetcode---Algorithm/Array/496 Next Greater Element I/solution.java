import java.util.HashMap;
import java.util.Stack;

public class solution {

    static int indexOf(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }

        return -1;
    }

    //this solution run in time complexity
    /**
     * Idea: we find the element x in nums 1 that proper in nums2 and use loop to find the next greater element
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        for (int i = 0; i < answer.length; i++) {
            int curData = nums1[i];
            int j = indexOf(nums2, curData);
            boolean canFind = false;
            while(j < nums2.length){
                if(curData < nums2[j]){
                    answer[i] = nums2[j];
                    canFind = true;
                    break;
                }
                j++;
            }
            if(!canFind)
                answer[i] = -1;
        }   

        return answer;
    }

    //this solution run in time complexity is O(m + n) with m is length of nums1 and n is length of nums2
    /**
     * Idea: Assume we have array that in descending: [5,4,5,2,1,6]
     * So we see that 6 is the element that is next greater for all rest element in previous
     * 
     * So the idea in here we will use stack to keep track the descending array of nums2, if we find the element x
     * that greater the stack.pop() we will use hashmap to keep the value and the value greater of that
     * 
     * For understanding let look with example
     * 
     * Assume nums2 have [5,9,3,4,7,6]
     * so first stack we have is 5 and the next is 9 and that is greater than stack.pop() in this case is 5
     * so we keep in hash map is {5: 9} and push 9 into stack
     * 
     * the next one is 3 and not greater than stack.pop() in this case is 9 so we skip and evaluate the next element of 3
     * so our case we have is [9,3,4] and we see 7 is greater of 3 and 4 
     * so we will pop stack until 7 is not greater that stack.pop() in this case is 9
     * so we have in hash map is {3: 7}, {4: 7} and our stack is [9,7]
     * 
     * the process will do untill we go thourgh the nums2 and the result we have is hashmap keep the value in nums2 and the next greater value
     * 
     * we use each element in mums1 and use that is a key for find the value of key in hashmap tha we build before
     * if we find the value of key so answer[i] = map.getkey() and if no is -1
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
    
        Stack<Integer> stack = new Stack<>();// keep track decreasing of nums2
        HashMap<Integer, Integer> map = new HashMap<>();// map the x is the key and value is the value greater and next x
        int[] answer = new int[nums1.length];

        for (int num : nums2) {
            while(!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = map.getOrDefault(nums1[i], -1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};

        int[] answer = nextGreaterElement2(nums1, nums2);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
