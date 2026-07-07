class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet();
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
                    set.add(cur);
                    l++;
                } else if(nums[l] + nums[r] > sum){
                    r--;
                } else {
                    l++;
                }


            }
        }

        return new ArrayList(set);
    }
}
