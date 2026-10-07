class KthLargest {
    int size;
    int[] nums;
    int k;

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private static int[] resize(int[] nums) {
        int newSize = nums.length == 0 ? 1 : 2 * nums.length;
        int[] newArr = new int[newSize];

        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i];
        }

        return newArr;
    }

    public KthLargest(int k, int[] nums) {
        this.k = k;
        size = 0;

        this.nums = new int[Math.max(1, nums.length)];

        for (int i = 0; i < nums.length; i++) {
            addNoRemoval(nums[i], this.nums);
        }
    }

    public int removal(int[] nums, int tempSize, int repetition) {
        if (repetition == 1) {
            return nums[0];
        }

        swap(nums, 0, tempSize - 1);

        int current = 0;

        while (true) {
            int left = (current * 2) + 1;
            int right = (current * 2) + 2;

            // No left child
            if (left >= tempSize - 1) {
                break;
            }

            int nextIndex;

            // Only left child exists
            if (right >= tempSize - 1) {
                nextIndex = left;
            } 
            // Both children exist, choose larger
            else {
                nextIndex = nums[left] > nums[right] ? left : right;
            }

            // Parent already satisfies max-heap property
            if (nums[current] >= nums[nextIndex]) {
                break;
            }

            swap(nums, current, nextIndex);
            current = nextIndex;
        }

        return removal(nums, tempSize - 1, repetition - 1);
    }

    public void addNoRemoval(int val, int[] nums) {
        nums[size] = val;

        int current = size;

        while (current > 0) {
            int parent = (current - 1) / 2;

            if (nums[parent] < nums[current]) {
                swap(nums, parent, current);
                current = parent;
            } 
            else {
                break;
            }
        }

        size++;
    }

    public int add(int val) {
        if (size >= nums.length) {
            nums = resize(nums);
        }

        nums[size] = val;

        int current = size;

        while (current > 0) {
            int parent = (current - 1) / 2;

            if (nums[parent] < nums[current]) {
                swap(nums, parent, current);
                current = parent;
            } 
            else {
                break;
            }
        }

        size++;

        // Don't destroy the actual heap
        int[] temp = nums.clone();

        return removal(temp, size, k);
    }
}