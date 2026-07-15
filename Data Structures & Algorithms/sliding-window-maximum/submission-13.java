class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[q.peek()] <= nums[i]) {
                q.poll();
            }
            q.offer(i);
        }
        // edge case - k=n
        ans[0] = nums[q.peekFirst()];

        //slide the windo
        for(int i=k ; i< nums.length ; i++) {
            while(!q.isEmpty() && q.peek() < i-k + 1){
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peek()] <= nums[i]) {
                q.poll();
            }

            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.offer(i);


            ans[i-k+1] = nums[q.peek()];
        }

        return ans;
    }
}
