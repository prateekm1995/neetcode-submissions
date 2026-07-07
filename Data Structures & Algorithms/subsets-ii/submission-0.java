class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList());
        return ans;
    }

    private void backtrack(int[] nums, int i, List<Integer> cur){
        if(i == nums.length){
            ans.add(new ArrayList(cur));
            return ;
        }

        cur.add(nums[i]);
        backtrack(nums, i+1, cur);
        cur.remove(cur.size()-1);

        while(i<nums.length - 1 && nums[i] == nums[i+1]){
            i++;
        }
        backtrack(nums, i+1, cur);
    }
}
