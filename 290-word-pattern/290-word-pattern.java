class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>h=new HashMap<>();
        String a[]=s.split(" ");// to split around whitespace have to write //s
        int j=0;
        for(int i=0;i<pattern.length();i++){
            if(j>=a.length) return false;
            if(h.containsKey(pattern.charAt(i))){
                if(h.get(pattern.charAt(i)).equals(a[j])==false){
                    return false;
                }
            }else{
                h.put(pattern.charAt(i),a[j]);
            }
            j++;
        }
        HashMap<String,Character>hh=new HashMap<>();
        a=s.split(" ");// to split around whitespace have to write //s
        j=0;
        for(int i=0;i<a.length;i++){
            if(j>=pattern.length()) return false;
            if(hh.containsKey(a[i])){
                if(hh.get(a[i]).equals(pattern.charAt(j))==false){
                    return false;
                }
            }else{
                hh.put(a[i],pattern.charAt(j));
            }
            j++;
        }
        return true;
    }
}