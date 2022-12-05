import java.util.ArrayList;
import java.util.List;

class Solution {
    //value array
    private int[] value = {1,2,4,8,1,2,4,8,16,32};
    private int TURN_ON = 0;
    List<String> result = new ArrayList<>();

    //backtracking
    private void backtracking(int curIndex, int countLed, int hour, int min){
        
        //led has value is {0, 1}
        for (int i = 0; i <= 1; i++) {
            if(i == 1){
                countLed++;
                //if curIndex <=3 is in the range of hour{1,2,4,8}
                if(curIndex <= 3){
                    hour += value[curIndex];
                }
                //if currIndex > 3 is in range of minutes {1,2,4,8,16,32}
                else{
                    min += value[curIndex];
                }
            }

            //finish structuring
            if(curIndex == value.length - 1){
                if(countLed == TURN_ON && hour < 12 && min < 60){
                    String time = String.format("%d:%02d", hour, min);
                    this.result.add(time);
                }
            }else{
                backtracking(curIndex+1, countLed, hour, min);
            }
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        TURN_ON = turnedOn;
        backtracking(0, 0, 0, 0);
        return this.result;
    }

    public static void main(String[] args) {
    }
}