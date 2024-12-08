class Solution {

    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    public int helper(int[] nums, int start, int end, int k) {
        int pivotIndex = partition(nums, start, end);
        if (pivotIndex == nums.length - k) {
            return nums[pivotIndex];
        } else if (pivotIndex > (nums.length - k)) {
            return helper(nums, start, pivotIndex - 1, k);
        } else {
            return helper(nums, pivotIndex + 1, end, k);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int pi = new Random().nextInt(end - start + 1) + start;
        int pivot = nums[pi];
        swap(nums, pi, end);

        int ptr = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, ptr);
                ptr++;
            }
        }
        swap(nums, ptr, end);
        return ptr;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}