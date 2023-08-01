class Solution {
    public String minimumString(String a, String b, String c) {
        String[] arr = {merge(merge(a,b),c),merge(merge(b,a),c),merge(merge(a,c),b),merge(merge(c,a),b),merge(merge(b,c),a),merge(merge(c,b),a)};

        Arrays.sort(arr, (s1, s2) -> s1.length()==s2.length() ? s1.compareTo(s2) : s1.length()-s2.length());
        return arr[0];
    }

    private String merge(String s,String t){
        if(s.indexOf(t)>=0){
            return s;
        }
        for(int i=t.length();i>0;i--){
            if(s.endsWith(t.substring(0,i))){
                return s + t.substring(i);
            }
        }
        return s + t;
    }
}