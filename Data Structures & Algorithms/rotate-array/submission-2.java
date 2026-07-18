class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int count = 0;
        int i=0;
        int j=i;
        int next = nums[i];
        int  prev;

        while(count < n ) {
            j=i;
             next = nums[i];
            do {
                
                prev = next;
                j = (j+k)%n;
                next = nums[j];
                nums[j] = prev;
                count++;
                
            } while(i != j);
            i++;
        }

        return ;
    }
}
    