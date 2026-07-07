class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum = 0 - nums[i];
            if((i > 0) && (nums[i] == nums[i-1])){
                continue;
            }
            int l=i+1;
            int r=nums.length-1;

            while( l<r){
                if(l == i){
                    l++;
                    continue;
                }
                if(r == i){
                    r--;
                    continue;
                }
                if(nums[l] + nums[r] == sum){
                    List<Integer> cur = new ArrayList();
                    cur.add(nums[i]);
                    cur.add(nums[l]);
                    cur.add(nums[r]);
                    ans.add(cur);
                    l++;r--;
                    while(l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                    while(l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                } else if(nums[l] + nums[r] > sum){
                    r--;
                } else {
                    l++;
                }


            }
        }

        return ans;
    }
}
