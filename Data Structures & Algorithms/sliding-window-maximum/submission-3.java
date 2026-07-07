

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int  n = nums.length;
        int l=0, r=0, i=0;

        int[] ans = new int[n-k+1];

        for(; r<k; r++) {
            maxHeap.offer(nums[r]);
        }
        ans[i] = maxHeap.peek();

        for(; r<n; r++) {
            int curmax = maxHeap.peek();
            
                maxHeap.remove(nums[l]);
                curmax = maxHeap.peek() == null ? Integer.MIN_VALUE : maxHeap.peek();
            
            l++;
            maxHeap.offer(nums[r]);
            i++;
            ans[i] = maxHeap.peek();
        }
        return ans;
    }
}
