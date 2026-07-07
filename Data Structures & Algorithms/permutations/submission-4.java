class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList();

        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int i) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList();
            for (int val : nums) {
                cur.add(val);
            }
            ans.add(cur);
            return;
        }

        backtrack(nums, i + 1);
        for (int j = i+1; j < nums.length; j++) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            backtrack(nums, i + 1);

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

}
