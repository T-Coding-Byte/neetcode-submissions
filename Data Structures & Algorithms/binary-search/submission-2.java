class Solution {
    public int search(int[] nums, int target) {
        int front = 0;
        int rear = nums.length -1;
        int midpoint = 0;
        while(front <= rear){
            midpoint = (rear + front)/2;
            if(nums[midpoint] == target) return midpoint;
            else if(nums[midpoint] < target) front = midpoint + 1;
            else {rear = midpoint-1;} 

        }
    return -1;   
    }
}
