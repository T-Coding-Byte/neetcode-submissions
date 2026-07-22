class Solution {
    public boolean hasDuplicate(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int offset = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > largest){
                largest = nums[i];
            }
            if(nums[i] < offset){
                offset = nums[i];
            }
        }
        offset = (offset < 0) ? -offset : offset;
        System.out.println(largest);
        System.out.println(offset);
        boolean[] hash = new boolean[largest + 100 + offset];
        for(int i = 0; i < nums.length; i++){
        
            if(hash[nums[i] + offset]) return true;
            hash[nums[i] + offset] = true;
        }
        return false;
    }
}