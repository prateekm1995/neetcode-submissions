class Solution {
    public int findMin(int[] a) {
        int l=0, r = a.length-1;

        while(l <=r ) {
            int mid = l + (r-l)/2;

            if(mid != 0 && a[mid-1] > a[mid]) {
                return a[mid];
            }

            if(a[mid] >= a[r]) {
                l = mid+1;
            } else {
                r = mid-1;
            }


                    
        }
        return a[0];
    }
}
