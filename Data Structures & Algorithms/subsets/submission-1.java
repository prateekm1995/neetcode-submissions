class Solution {
    private List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList();
        List<Integer> list = new ArrayList();
        createList(nums, new ArrayList(list), 1);
        list.add(nums[0]);
        createList(nums, new ArrayList(list), 1);
        return ans;
        
    }

    private void createList(int[] nums, List<Integer> list, int i) {
        if(i == nums.length){
            ans.add(list);
            return;
        }
        List<Integer> cur = new ArrayList();
        createList(nums, new ArrayList(list), i+1);
        list.add(nums[i]);
        createList(nums, new ArrayList(list), i+1);
    }
}
