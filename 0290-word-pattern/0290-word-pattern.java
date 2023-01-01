class Solution {
    public boolean wordPattern(String s, String a) {
        String c[]=a.split(" ");
        if(s.length()!=c.length) return false;
        HashMap<Character,String>h=new HashMap<>();
        HashSet<String>used=new HashSet<>();
        for(int i=0;i<c.length;i++){
            char d=s.charAt(i);
            if(h.containsKey(d)){
                if(c[i].equals(h.get(d))==false) return false;
            }else{
                if(used.contains(c[i])) return false;
                else used.add(c[i]);
                h.put(d,c[i]);
            }
        }
        return true;
    }
}