class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 2){return Math.min(nums[0],nums[1]);}
        int min = nums[0]; //min = "pivot"
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(left <= right){
            mid = (right + left)/2;
            if(nums[mid] > min){
                left = mid + 1;
            }
            else{
                min = nums[mid];
                right = mid - 1;
            }
        }
        return min;
    }
}
