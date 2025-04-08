class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        int start = 0;

        while (start < nums.length) {
            Set<Integer> set = new HashSet<>();
            boolean hasDuplicate = false;

            for (int i = start; i < nums.length; i++) {
                if (!set.add(nums[i])) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (!hasDuplicate) {
                break;
            }

            start += 3;
            count++;
        }

        return count;
    }
}