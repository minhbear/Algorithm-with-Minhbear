import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    //We see in description that each turn we take two element that in max in array so if 
    //we just sort array and take 2 element and add the result of subtrack of 2 element that and 
    //loop process when the array is most 1 element we have time complexity is N^2Log(N) 
    //With NLog(n) is the time complexity we use is merger of heap sort and N time is the element 
    //each turn we add to array

    //So to have faster we use data structure is heap, so the heapify function of array have n lenght is nlogn
    //so after we poll 2 element and add element to array we just tak log(n) time for each element
    //so array have n lentgh we have timecomplexity is nlogn
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        //add all element of stones to priority queue
        for (int integer : stones) {
            maxHeap.add(integer);
        }

        while(maxHeap.size() > 1){
            //x alway greater or equals y
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x > y)
                maxHeap.add(x - y);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(lastStoneWeight(arr));
    }
}