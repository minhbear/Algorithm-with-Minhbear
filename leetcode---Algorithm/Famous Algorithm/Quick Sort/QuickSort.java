class QuickSort{
    private static void swap(int i, int j, int[] arr){
        int swapValue = arr[i];
        arr[i] = arr[j];
        arr[j] = swapValue;
    }

    //Partition function
    //This function take the last element of range [low, high] is pivot
    //return the correct index pivot value of array
    private static int partition(int low, int high, int[] arr){
        int pivot = arr[high];

        //The index of last pivot value
        //keep track the index that element small then pivot
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {

            //if find element smaller than pivot
            if(arr[j] < pivot){
                //increment the i to take correct index of element smaller then pivot
                i++;
                //swap with element that greater with pivot right now is arr[i]
                swap(i, j, arr);
            }
            //else do not thing
        }

        //take pivot to the correct index 
        swap(i+1, high, arr);
        return i+1;
    }

    private static void implementQuickSort(int low, int high, int[] arr){
        if(low < high){
            int lastPivotIndex = partition(low, high, arr);

            //sort element in left pivot
            implementQuickSort(low, lastPivotIndex-1, arr);
            //sort element in right pivot
            implementQuickSort(lastPivotIndex+1, high, arr);
        }
    }

    public static void quickSort(int[] arr){
        implementQuickSort(0, arr.length - 1, arr);
    }

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        quickSort(arr);
        printArray(arr);
    }
}