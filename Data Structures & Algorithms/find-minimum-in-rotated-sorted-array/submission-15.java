class Solution {
    public int findMin(int[] a) {
        int l=0, r = a.length-1;
        int min=a[0];

        while(l <=r ) {

            if(a[l] < a[r]) {
                min = Math.min(min,a[l]);
                break;
            }
            int mid = l + (r-l)/2;
            min = Math.min(min,a[mid]);

            if(a[mid] > a[r]) {
                l = mid+1;
            } else {
                r = mid-1;
            }    
        }
        return min;
    }
}
