class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // 1. create pseudo array for storing and soritng
        int [] dummy = arr.clone();
        Arrays.sort(dummy);

        //2. initialise the condition |larger index larger array| |same index same array|
        int index = 0;
        for(int rank : dummy){
            if( index == 0 || dummy[index - 1] != rank){
                dummy[index++] = rank;
            }
        }
        //3. give ranking to elements using binary search
        int[] unique = Arrays.copyOf( dummy, index);
        for(int i =0; i< arr.length; i++){
            arr[i] = Arrays.binarySearch(unique, arr[i]) + 1 ;
        }
        return arr; 
    }
}