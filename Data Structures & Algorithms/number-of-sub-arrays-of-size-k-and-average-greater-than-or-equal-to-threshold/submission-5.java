class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l=0,r=0;
        int count=0;
        int sum=0;
        for(;r<k;r++) {
            sum+=arr[r];
        }
        if(sum/k >= threshold) {
            count++;
        }
        
        while(r< arr.length) {
            sum-=arr[l];
            sum+=arr[r];
            if(sum/k >= threshold) {
                count++;
            }
            l++;
            r++;
        }
        return count;
    }
}