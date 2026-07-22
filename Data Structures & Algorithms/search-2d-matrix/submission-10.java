class Solution {
    private static boolean binarySearch(int[] arr, int target){
        int high = arr.length - 1;
        int low = 0;

        

        while(low <= high){
            int midpoint = (high + low)/2;
            if(arr[midpoint] == target) return true;
            else if(arr[midpoint] < target){
                low = midpoint + 1;
            }
            else{
                high = midpoint - 1;
            }
        }
        return false;

    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int high = matrix.length - 1;
        int low = 0;

        if(matrix.length == 1) return binarySearch(matrix[0], target);

        
        while(low <= high){
            int midpoint = (high + low)/2;
            if(matrix[midpoint][0] <= target && target <= matrix[midpoint][matrix[0].length - 1]){ 
                return binarySearch(matrix[midpoint], target); 
                }

            else if(matrix[midpoint][0] > target){
                high = midpoint -1;
            }
            else{
                low = midpoint +1;
            }
        }
        return false;
    }
}
