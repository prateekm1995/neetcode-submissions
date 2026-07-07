class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList();

        backtrack(nums, 0, new ArrayList());
        return ans;
    }

    private void backtrack(int[] nums, int i, List<Integer> cur) {
        if(i == nums.length){
            ans.add(new ArrayList(cur));
            return;
        }

        for(int j=i; j < nums.length; j++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            cur.add(nums[i]);
            backtrack(nums, i+1, cur);
            cur.remove(cur.size()-1);

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }            
        
    }


}
