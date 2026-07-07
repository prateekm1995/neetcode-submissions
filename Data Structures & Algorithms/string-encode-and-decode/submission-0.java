class Solution {

    public String encode(List<String> strs) {
         StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length());
            sb.append("d");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
         ArrayList<String> list = new ArrayList<>();
         for(int i=0; i < str.length();) {
            int k=i;
            while( str.charAt(k) != 'd') {
                k++;
            }
            int length = Integer.parseInt(str.substring(i,k));
            list.add(str.substring(k+1, k+1+length));
            i = k+1+length;
         }
         return list;

    }
}
