class Solution {
    public int search(int[] nums, int target) {
        //check right half until you find the split then do ordinary binary search
        //find pivot, then every element is ((length + i - pivot) % length) 
    
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    int pivot = left;

    // Binary search in the "unrotated" virtual array
    left = 0;
    right = nums.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        int realIndex = (mid + pivot) % nums.length;

        if (nums[realIndex] == target) {
            return realIndex;
        } else if (nums[realIndex] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1;


    }
}
