class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList();
        Arrays.sort(nums);
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
        HashSet<Integer> set = new HashSet();
        set.add(nums[i]);

        backtrack(nums, i + 1);
        for (int j = i+1; j < nums.length; j++) {
            if(set.contains(nums[j])){
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            set.add(nums[i]);

            backtrack(nums, i + 1);

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

}
