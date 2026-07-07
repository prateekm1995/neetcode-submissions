class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
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
                if(nums[l] + nums[r] + nums[i] == 0){
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;r--;
                    while(l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                    while(l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                } else if(nums[l] + nums[r] + nums[i]> 0 ){
                    r--;
                } else {
                    l++;
                }


            }
        }

        return ans;
    }
}
