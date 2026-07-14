class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> stack = new ArrayDeque();
       int[] ng = new int[nums.length];
       Arrays.fill(ng, nums.length);


       for(int i=0;i<nums.length ; i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ng[stack.pop()] = i;
            }
            stack.push(i);
       } 

        int ans[] = new int[nums.length - k +1];
        for(int i=0 ; i< ans.length ; i++) {
            if(ng[i] == nums.length || ng[i] - i >= k) {
                ans[i] = nums[i];

            } else {
                int j= ng[i];
                while(ng[j] < i + k) {
                    j = ng[j];
                }
                ans[i] = nums[j];
            }
        }

        return ans;
    }
}
