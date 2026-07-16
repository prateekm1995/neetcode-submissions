class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int idx = Arrays.binarySearch(arr, x);
        int l,r;
        int count=0;
        if(idx <0) {
            r = -idx - 1;
            l = r-1;
        } else {
            count++;
            l = idx-1;
            r = idx+1;
        }

        while(l >= 0 && r < arr.length && r-l-1 < k) {
            if(Math.abs(arr[r] - x) < Math.abs(arr[l] - x) ) {
                r++;
            } else {
                l--;
            }
            count++;
        }

        while(l >=0 && r-l-1 < k) {
            count++;
            l--;
        }
        while(r<arr.length && r-l-1 < k) {
            count++;
            r++;
        }
        for(int i=l+1; i < r; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}