class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList();

        backtrack(nums, 0, new ArrayList());
        return ans;
    }

    private void backtrack(int[] nums, int i, List<Integer> cur) {
        if(i == nums.length){
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for(int j=i; j < nums.length; j++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            
            backtrack(nums, i+1, cur);
            

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }            
        
    }


}
