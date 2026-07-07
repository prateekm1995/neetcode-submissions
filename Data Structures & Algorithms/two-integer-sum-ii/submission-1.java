class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int r = numbers.length-1;
        int l=0;
        while(l<r) {
            if(numbers[l] + numbers[r] == target) {

                  int[] ans = {l+1, r+1};
                 return ans;
            }
            if(numbers[l] + numbers[r] > target ) r--;
            if(numbers[l] + numbers[r] < target) l++;
        }
      int[] ans = {l+1, r+1};
      return ans;
    }
}