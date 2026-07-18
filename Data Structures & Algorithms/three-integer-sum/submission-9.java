class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int x,l,r;
        x=0;
        while(x < nums.length -2) {
            if (x > 0 && nums[x] == nums[x-1]) {
                x++;
                continue;
            }
             l = x + 1;
             r = nums.length - 1;
             while (l < r) {
                int sum = nums[x] + nums[l] + nums[r];
                if((l > x+1 && nums[l] == nums[l-1]) || sum < 0) {
                        l++;
                } else if((r < nums.length-1 && nums[r] == nums[r+1]) || sum > 0) {
                    r--;
                } else {
                    ans.add(List.of(nums[x],nums[l],nums[r]));
                    r--;
                }
             }
             x++;       
        } 
        return ans;
    } 
}
