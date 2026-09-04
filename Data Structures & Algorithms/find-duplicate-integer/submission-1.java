class Solution {
    public int findDuplicate(int[] nums) {
        //nums[i] = other element in list, treat it like linkedlist
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        System.out.println(slow);
        System.out.println(fast);
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
        
    }
}
