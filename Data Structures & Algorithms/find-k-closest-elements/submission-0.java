class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int idx = Arrays.binarySearch(arr, x);
        int l,r;
        if(idx <0) {
            r = -idx - 1;
            l = r-1;
        } else {
            ans.add(arr[idx]);
            l = idx-1;
            r = idx+1;
        }

        while(l >= 0 && r < arr.length && ans.size() < k) {
            if(Math.abs(arr[r] - x) < Math.abs(arr[l] - x) ) {
                ans.add(arr[r]);
                r++;
            } else {
                ans.add(arr[l]);
                l--;
            }
        }

        while(l >=0 && ans.size() < k) {
            ans.add(arr[l]);
            l--;
        }
        while(r<arr.length && ans.size() < k) {
            ans.add(arr[r]);
            r++;
        }
        ans.sort(null);
        return ans;
    }
}