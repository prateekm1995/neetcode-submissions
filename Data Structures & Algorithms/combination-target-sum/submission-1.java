class Solution {
    private List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList();
        sum(nums, target, new ArrayList(),0);

        return ans;



    }

    private void sum(int[] nums, int target, List<Integer> curList, int i) {
        if(target == 0) {
            ans.add(new ArrayList(curList));
            return;
        }
        if( i >= nums.length || target < 0){
            return;
        }
        sum(nums, target, curList,  i+1);
        curList.add(nums[i]);
        sum(nums, target-nums[i], curList,  i);
        curList.remove(curList.size()-1);
    }
}
