class Solution {
    private Set<List<Integer>> ans = new HashSet();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        ans = new HashSet();
        sum(nums, target, new ArrayList(),0);
        return new ArrayList(ans);
    }

    private void sum(int[] nums, int target, List<Integer> curList, int i) {
        if(target == 0) {
            ans.add(new ArrayList(curList));
            return;
        }
        if( i >= nums.length || target < 0){
            return;
        }
        curList.add(nums[i]);
        sum(nums, target-nums[i], curList,  i+1);
        curList.remove(curList.size()-1);

        while( i < nums.length-1 && nums[i] == nums[i+1]){
            i++;
        }

        sum(nums, target, curList,  i+1);
    }

}
