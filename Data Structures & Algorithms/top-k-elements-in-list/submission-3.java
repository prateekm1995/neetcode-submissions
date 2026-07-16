class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(q.size() < k) {
                q.offer(entry);
            } else {
                if(q.peek().getValue() < entry.getValue()) {
                    q.poll();
                    q.offer(entry);
                }
            }
        }

        return q.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();

    }

    private class Element {
        int v;
        int f;

        Element(int v, int f) {
            this.v = v;
            this.f =f ;
        } 
    }
}
