import java.util.HashMap;
import java.util.Map;

public class solution {

    //The idea in here is we will use another data structure to keep track score edge of each node in graph
    //So we use hashMap, we traversal all element in edges array and plus all node to key node
    //and we will traversal again to find which node has score edge highest 
    public static int edgeScore(int[] edges) {
        Map<Integer, Long> scoreEdge = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            scoreEdge.put(edges[i], scoreEdge.getOrDefault(edges[i], (long)0) + i);
        }

        int node = 0; 
        
        long max = Integer.MIN_VALUE;
        
        for (Map.Entry<Integer, Long> element : scoreEdge.entrySet()) {
            if(max < element.getValue()){
                max = element.getValue();
                node = element.getKey();
            }else if(max == element.getValue()) {
                if(element.getKey() < node){
                    node = element.getKey();
                }
            }
        }

        return node;
    }  

    //another solution but same idea to keep track score of each node by array
    public int edgeScore1(int[] edges) {
        int n = edges.length;
        long[] scoreEdge = new long[n];
        
        for(int i = 0; i<n; i++) {
            scoreEdge[edges[i]] += i;
        }
        
        int node = -1;
        long mã = Long.MIN_VALUE;
        
        for(int i = 0; i<n; i++) {
            if(scoreEdge[i] > mã) {
                node = i;
                mã = scoreEdge[i];
            }
        }
        
        return node;
    }
    
    public static void main(String[] args) {
        // int[] edges = {2,0,0,2};
        int[] edges = {1,0,1,1,1,1,1,1};
        System.out.println(edgeScore(edges));
    }
}
