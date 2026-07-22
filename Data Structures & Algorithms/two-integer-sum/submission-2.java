class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> solutions = new HashMap<>();
        //nums[i] == target - nums[j]
        for(int i = 0; i < nums.length; i++){
            solutions.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            if(solutions.containsKey(target - nums[i]) && i != solutions.get(target - nums[i])){
                return new int[] {i,solutions.get(target - nums[i])};
            }
        }
        return new int[]{6,7};
    }
}
